package br.com.traderhelper.neuraltrainer;

import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.evaluation.NumericPrediction;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.timeseries.WekaForecaster;
import weka.core.Debug;
import weka.core.Instances;
import weka.core.Utils;

import java.io.FileReader;
import java.util.List;

/**
 * Created by Michael on 31/05/2017.
 */
public class Trainer {

    public static void training(String filepath) {
        try {
            FileReader trainreader = new FileReader(filepath);
            FileReader testreader = new FileReader(filepath);

            Instances train = new Instances(trainreader);
            Instances test = new Instances(testreader);
            train.setClassIndex(train.numAttributes() - 1);
            test.setClassIndex(test.numAttributes() - 1);

            MultilayerPerceptron mlp = new MultilayerPerceptron();
            mlp.setOptions(Utils.splitOptions("-L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H 4"));
//Setting Parameters
            /*mlp.setLearningRate(0.3);
            mlp.setMomentum(0.2);
            mlp.setTrainingTime(500);
            mlp.setValidationSetSize(0);
            mlp.setSeed(0);
            mlp.setValidationThreshold(20);
            mlp.setHiddenLayers("4");*/

            mlp.buildClassifier(train);
            mlp.classifyInstance(train.get(10));

            Evaluation eval = new Evaluation(train);
            eval.evaluateModel(mlp, test);
            System.out.println(eval.toSummaryString("\nResults\n======\n", true));
            System.out.println(eval.errorRate()); //Printing Training Mean root squared Error
            trainreader.close();
            testreader.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

    public static double getPrediction(String filepath) throws Exception {
        // read data
        Instances num = new Instances(new FileReader(filepath));
        // new forecaster
        WekaForecaster forecaster = new WekaForecaster();
        forecaster.setFieldsToForecast("company10");
        forecaster.buildForecaster(num, System.out);
        forecaster.primeForecaster(num);
        List<List<NumericPrediction>> forecast = forecaster.forecast(1, System.out);
        // output
        List<NumericPrediction> predsAtStep = forecast.get(0);
        NumericPrediction predForTarget = predsAtStep.get(0);
        double p = predForTarget.predicted();
        return p;
    }

    public static void simpleWekaTrain(String filepath) {
        try {
            //Reading training arff or csv file
            FileReader trainreader = new FileReader(filepath);
            Instances train = new Instances(trainreader);
            train.setClassIndex(train.numAttributes() - 1);
            //Instance of NN
            MultilayerPerceptron mlp = new MultilayerPerceptron();
            //Setting Parameters
            mlp.setLearningRate(0.1);
            mlp.setMomentum(0.2);
            mlp.setTrainingTime(2000);
            mlp.setHiddenLayers("4,5");
            mlp.buildClassifier(train);

            //Evaluating
            int kfolds = 2;
            Evaluation eval = new Evaluation(train);
            eval.evaluateModel(mlp, train);
            eval.crossValidateModel(mlp, train, kfolds, new Debug.Random(1));
            System.out.println(eval.errorRate()); //Printing Training Mean root squared Error
            System.out.println(eval.toSummaryString()); //Summary of Training

            /*Instances datapredict = new Instances(new BufferedReader(new FileReader( < Predictdatapath >)));*/
            FileReader predictreader = new FileReader(filepath);
            Instances datapredict = new Instances(predictreader);
            datapredict.setClassIndex(datapredict.numAttributes() - 1);
            Instances predicteddata = new Instances(datapredict);
            //Predict Part
            for (int i = 0; i < datapredict.numInstances(); i++) {
                double clsLabel = mlp.classifyInstance(datapredict.instance(i));
                predicteddata.instance(i).setClassValue(clsLabel);
            }
            System.out.println(predicteddata.toString());
            //Storing again in arff
            /*BufferedWriter writer = new BufferedWriter(new FileWriter( < Output File Path >));
            writer.write(predicteddata.toString());
            writer.newLine();
            writer.flush();
            writer.close();*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        String pathArff = "C:\\dev\\theProjects\\git\\traderhelper.neuraltrainer\\src\\main\\resources\\stock.arff";
        //training(pathArff);
        //simpleWekaTrain(pathArff);
        getPrediction(pathArff);
/*
        ConverterUtils.DataSource dataSource = new ConverterUtils.DataSource("C:\\dev\\theProjects\\git\\traderhelper.neuraltrainer\\src\\main\\resources\\stock.arff");

        Instances train = dataSource.getDataSet().trainCV(10, 0);
        train.setClassIndex(train.numAttributes() - 1);
        Instances test = dataSource.getDataSet().testCV(10, 0);
        test.setClassIndex(test.numAttributes() - 1);

        Remove rm = new Remove();
        rm.setAttributeIndices("1");  // remove 1st attribute
        // classifier
        LinearRegression linearRegression = new LinearRegression();
        // meta-classifier
        FilteredClassifier fc = new FilteredClassifier();
        fc.setFilter(rm);
        fc.setClassifier(linearRegression);
        // train and make predictions
        fc.buildClassifier(train);
        for (int i = 0; i < test.numInstances(); i++) {
            double pred = fc.classifyInstance(test.instance(i));
            System.out.print("ID: " + test.instance(i).value(0));
            System.out.print(", actual: " + test.instance(i).classValue());
            System.out.println(", predicted: " + pred);
        }*/
        /*Instances dataset = dataSource.getDataSet();
        dataset.setClassIndex(dataset.numAttributes() - 1);

        LinearRegression lr = new LinearRegression();
        lr.buildClassifier(dataset);
        System.out.println(lr);

        SMOreg smo = new SMOreg();
        smo.buildClassifier(dataset);
        System.out.println(smo);

        weka.experiment.InstanceQuery iq = new InstanceQuery();

        ArrayList<Attribute> atts = new ArrayList<Attribute>();
        atts.add(new Attribute("attribute1"));
        atts.add(new Attribute("attribute2"));
        atts.add(new Attribute("id", (ArrayList<String>) null));
        Instances data = new Instances("yourData", atts, 0);*/

        /*DAOModel dao = getYourDaoModelHereFromHibernateHoweverYouWantIt();
        for (Model m : dao.findAll()) {
            vals = new double[data.numAttributes()];
            vals[0] = m.getAttribute1();
            vals[1] = m.getAttribute2();
            vals[2] = data.attribute(2).addStringValue(m.getId());
            data.add(new DenseInstance(1.0, vals));
        }*/
    }

}

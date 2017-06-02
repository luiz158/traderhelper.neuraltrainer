package br.com.traderhelper.neuraltrainer;

import br.com.traderhelper.neuraltrainer.service.impl.AmostraDadosServiceImpl;
import br.com.traderhelper.neuraltrainer.service.impl.NeuralServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Michael on 23/03/2017.
 */
@Component
public class Start implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AmostraDadosServiceImpl cotacaoService;

    @Autowired
    NeuralServiceImpl neuralService;

    public void run(String... args) {
        try {

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date de = formato.parse("01/04/2017");
            Date ate = formato.parse("28/04/2017");
            //List<Dado> dadoList = cotacaoService.buscaDadosNoPeriodo(de, ate, "ABEV3");


        } catch (Exception e) {
            logger.error("Erro", e);
        }
    }
}

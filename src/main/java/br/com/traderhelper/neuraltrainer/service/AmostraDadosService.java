package br.com.traderhelper.neuraltrainer.service;

import br.com.traderhelper.neuraltrainer.domain.Dado;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Michael Sta. Helena on 01/06/2017.
 */
@Service
public interface AmostraDadosService {

    List<Dado> buscaDadosNoPeriodo(Date de, Date ate, String codNeg);

    List<Dado> buscaDadosNoPeriodo(Date de, Date ate, long codAcao);

}

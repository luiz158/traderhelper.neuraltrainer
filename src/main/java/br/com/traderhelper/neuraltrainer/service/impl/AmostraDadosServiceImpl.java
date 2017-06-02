package br.com.traderhelper.neuraltrainer.service.impl;

import br.com.traderhelper.neuraltrainer.dao.AcaoRepository;
import br.com.traderhelper.neuraltrainer.dao.CotacaoRepository;
import br.com.traderhelper.neuraltrainer.domain.Dado;
import br.com.traderhelper.neuraltrainer.domain.DadoBuilder;
import br.com.traderhelper.neuraltrainer.entity.Acao;
import br.com.traderhelper.neuraltrainer.entity.Cotacao;
import br.com.traderhelper.neuraltrainer.service.AmostraDadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Michael Sta. Helena on 01/06/2017.
 */
@Service
public class AmostraDadosServiceImpl implements AmostraDadosService {

    @Autowired
    AcaoRepository acaoRepository;

    @Autowired
    CotacaoRepository cotacaoRepository;

    @Override
    public List<Dado> buscaDadosNoPeriodo(Date de, Date ate, String codAcao) {
        final Acao acao = acaoRepository.findByCodigoPapel(codAcao);
        return getDadosNoPeriodo(de, ate, acao);
    }

    @Override
    public List<Dado> buscaDadosNoPeriodo(Date de, Date ate, long idAcao) {
        final Acao acao = acaoRepository.findOne(idAcao);
        return getDadosNoPeriodo(de, ate, acao);
    }

    private List<Dado> getDadosNoPeriodo(Date de, Date ate, Acao acao) {
        List<Dado> dadoList = new ArrayList();
        List<Cotacao> cotacaoList = cotacaoRepository.findByAcaoAndDataPregaoBetween(acao, de, ate);
        for (Cotacao cotacao : cotacaoList) {
            dadoList.add(new DadoBuilder(acao, cotacao).build());
        }
        return dadoList;
    }
}

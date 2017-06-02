package br.com.traderhelper.neuraltrainer.dao;

import br.com.traderhelper.neuraltrainer.entity.Acao;

import java.util.List;

/**
 * Created by Michael on 23/03/2017.
 */
public interface AcaoRepositoryCustom {

    List<Acao> get();

    void batchSave(List acoes);

    void batchMerge(List acoes);
}

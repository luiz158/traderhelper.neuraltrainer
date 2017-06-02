package br.com.traderhelper.neuraltrainer.dao.impl;


import br.com.traderhelper.neuraltrainer.dao.CotacaoRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Michael on 23/03/2017.
 */
@Repository
@Transactional
public class CotacaoRepositoryImpl extends BulkSaver implements CotacaoRepositoryCustom {
}

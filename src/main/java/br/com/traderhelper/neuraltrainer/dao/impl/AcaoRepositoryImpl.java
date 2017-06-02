package br.com.traderhelper.neuraltrainer.dao.impl;

import br.com.traderhelper.neuraltrainer.dao.AcaoRepositoryCustom;
import br.com.traderhelper.neuraltrainer.entity.Acao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Michael on 23/03/2017.
 */
@Repository
@Transactional
public class AcaoRepositoryImpl extends BulkSaver implements AcaoRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    public List<Acao> get() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Acao> query = builder.createQuery(Acao.class);
        Root<Acao> root = query.from(Acao.class);

        return em.createQuery(query.select(root)).getResultList();
    }
}

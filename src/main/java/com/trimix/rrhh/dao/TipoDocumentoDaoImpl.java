package com.trimix.rrhh.dao;

import com.trimix.rrhh.model.TipoDocumento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TipoDocumentoDaoImpl implements TipoDocumentoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public TipoDocumento get(int id) {
        return sessionFactory.getCurrentSession().get(TipoDocumento.class, id);
    }


    @Override
    public List<TipoDocumento> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<TipoDocumento> cq = cb.createQuery(TipoDocumento.class);
        Root<TipoDocumento> root = cq.from(TipoDocumento.class);
        cq.select(root);
        Query<TipoDocumento> query = session.createQuery(cq);
        return query.getResultList();
    }
}

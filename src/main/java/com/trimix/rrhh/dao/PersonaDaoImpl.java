package com.trimix.rrhh.dao;

import com.trimix.rrhh.exception.PersonaNotFoundException;
import com.trimix.rrhh.utils.DateUtils;
import com.trimix.rrhh.dto.PersonaDTO;
import com.trimix.rrhh.model.Persona;
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
public class PersonaDaoImpl implements PersonaDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private TipoDocumentoDao tipoDocumentoDao;

    @Override
    public int save(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        sessionFactory.getCurrentSession().save(personaDTOWrapper(persona, personaDTO));
        return persona.getPerId();
    }

    @Override
    public Persona get(int id) throws PersonaNotFoundException {
        Persona p = sessionFactory.getCurrentSession().get(Persona.class, id);
        if (p == null) {
            throw new PersonaNotFoundException("La persona no existe");
        }
        return p;
    }

    @Override
    public List<Persona> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
        Root<Persona> root = cq.from(Persona.class);
        cq.select(root);
        Query<Persona> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(PersonaDTO personaDTO) {
        Session session = sessionFactory.getCurrentSession();
        Persona persona = session.byId(Persona.class).load(personaDTO.getPerId());
        persona = personaDTOWrapper(persona, personaDTO);
        session.save(persona);
        session.flush();
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Persona persona = session.byId(Persona.class).load(id);
        session.delete(persona);
    }

    private Persona personaDTOWrapper(Persona persona, PersonaDTO personaDTO) {
        persona.setPerNombre(personaDTO.getPerNombre());
        persona.setPerApellido(personaDTO.getPerApellido());
        persona.setPerTipoDocumento(tipoDocumentoDao.get(personaDTO.getPerTpoId()));
        persona.setPerNumeroDocumento(personaDTO.getPerNumeroDocumento());
        persona.setPerFechaNacimiento(DateUtils.convertUtilToSql(personaDTO.getPerFechaNacimiento()));
        return persona;
    }
}

package com.trimix.rrhh.service;

import com.trimix.rrhh.dao.PersonaDao;
import com.trimix.rrhh.dto.PersonaDTO;
import com.trimix.rrhh.exception.PersonaNotFoundException;
import com.trimix.rrhh.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDao personaDao;

    @Transactional
    @Override
    public int save(PersonaDTO personaDTO) {
        return personaDao.save(personaDTO);
    }

    @Override
    public Persona get(int id) throws PersonaNotFoundException {
        return personaDao.get(id);
    }

    @Override
    public List<Persona> list() {
        return personaDao.list();
    }

    @Transactional
    @Override
    public void update(PersonaDTO personaDTO) {
        personaDao.update(personaDTO);
    }

    @Transactional
    @Override
    public void delete(int id) {
        personaDao.delete(id);
    }
}

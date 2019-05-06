package com.trimix.rrhh.dao;

import com.trimix.rrhh.dto.PersonaDTO;
import com.trimix.rrhh.exception.PersonaNotFoundException;
import com.trimix.rrhh.model.Persona;

import java.util.List;

public interface PersonaDao {

    int save(PersonaDTO personaDTO);

    Persona get(int id) throws PersonaNotFoundException;

    List<Persona> list();

    void update(PersonaDTO personaDTO);

    void delete(int id);
}

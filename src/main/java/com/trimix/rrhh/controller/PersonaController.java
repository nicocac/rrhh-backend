package com.trimix.rrhh.controller;

import com.trimix.rrhh.dto.PersonaDTO;
import com.trimix.rrhh.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.trimix.rrhh.model.Persona;
import com.trimix.rrhh.service.PersonaService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    /*---Add new persona---*/
    @PostMapping
    public ResponseEntity<?> save(@RequestBody PersonaDTO personaDTO) {
        int id = personaService.save(personaDTO);
        return ResponseEntity.ok().body(new Response(0, "Persona dada de alta correctamente.", null));
    }

    /*---Get a persona by id---*/
    @GetMapping("/{id}")
    public ResponseEntity<Persona> get(@PathVariable("id") int id) {
        Persona persona = personaService.get(id);
        return ResponseEntity.ok().body(persona);
    }

    /*---get all personas---*/
    @GetMapping()
    public ResponseEntity<List<Persona>> list() {
        List<Persona> personas = personaService.list();
        return ResponseEntity.ok().body(personas);
    }

    /*---Update a persona by id---*/
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody PersonaDTO personaDTO) {
        personaService.update(personaDTO);
        return ResponseEntity.ok().body(new Response(0, "Persona modificada correctamente.", null));
    }

    /*---Delete a persona by id---*/
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        personaService.delete(id);
        return ResponseEntity.ok().body(new Response(0, "Persona eliminada correctamente.", null));
    }
}

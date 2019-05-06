package com.trimix.rrhh.controller;

import com.trimix.rrhh.model.TipoDocumento;
import com.trimix.rrhh.service.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tipo-documento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    /*---get all tipos de documento---*/
    @GetMapping()
    public ResponseEntity<List<TipoDocumento>> list() {
        List<TipoDocumento> personas = tipoDocumentoService.list();
        return ResponseEntity.ok().body(personas);
    }
}

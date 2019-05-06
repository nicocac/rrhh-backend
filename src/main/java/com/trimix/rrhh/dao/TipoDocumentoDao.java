package com.trimix.rrhh.dao;

import com.trimix.rrhh.model.TipoDocumento;

import java.util.List;

public interface TipoDocumentoDao {
    List<TipoDocumento> list();
    TipoDocumento get(int id);
}

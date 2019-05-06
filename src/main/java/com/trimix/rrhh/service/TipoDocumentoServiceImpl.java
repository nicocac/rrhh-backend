package com.trimix.rrhh.service;

import com.trimix.rrhh.dao.TipoDocumentoDao;
import com.trimix.rrhh.model.TipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TipoDocumentoServiceImpl implements TipoDocumentoService {
    @Autowired
    private TipoDocumentoDao tipoDocumentoDao;

    @Override
    public List<TipoDocumento> list() {
        return tipoDocumentoDao.list();
    }
}

package com.seguridad.seguridad.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.seguridad.seguridad.modelo.TipoPrivacidad;
import com.seguridad.seguridad.repositorio.TipoPrivacidadRepositorio;
import org.springframework.stereotype.Service;

@Service  
public class TipoPrivacidadServicio {

    @Autowired
    private TipoPrivacidadRepositorio tipoPrivacidadRepositorio;

    public List<TipoPrivacidad> listarTipoPrivacidad() {
        return tipoPrivacidadRepositorio.findAll();
    }
    
}
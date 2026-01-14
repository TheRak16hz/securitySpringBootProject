package com.seguridad.seguridad.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.seguridad.seguridad.modelo.Usuario;
import com.seguridad.seguridad.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

@Service  
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }
    
}
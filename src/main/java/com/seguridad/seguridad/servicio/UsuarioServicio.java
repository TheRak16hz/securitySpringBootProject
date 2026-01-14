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

    //metodo para agregar un rol
    public void agregarUsuario(Usuario usuario){
        //Usando getters para obtener los valores
        usuarioRepositorio.usuario_agregar(
            usuario.getAli_usu(),
            usuario.getEma_usu(),
            usuario.getCla_usu(),
            usuario.getEst_usu()
        );
    }

    //metodo para modificar un rol
    public void  modificarUsuario(Usuario usuario){
        //Usando getters para obtener los valores
        usuarioRepositorio.usuario_modificar(
            usuario.getCod_usu(),
            usuario.getAli_usu(),
            usuario.getEma_usu(),
            usuario.getCla_usu(),
            usuario.getEst_usu()
        );
    }

    //Metodo para buscar un rol por su id
    public Usuario buscarPorId(int cod_usu){
        //Obtener el rol desde el repositorio
        return usuarioRepositorio.usuario_buscar(cod_usu);
    }

    //Metodo para eliminar un rol
    public boolean eliminarUsuario(int cod_usu){
        Usuario usuario = usuarioRepositorio.findById(cod_usu).orElse(null);
        if(usuario !=null){
            usuarioRepositorio.usuario_eliminar(cod_usu);
            return true;
        }
    return false;
    }
    
}
package com.seguridad.seguridad.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.seguridad.seguridad.modelo.Rol;
import com.seguridad.seguridad.repositorio.RolRepositorio;
import org.springframework.stereotype.Service;

@Service  
public class RolServicio {

    @Autowired
    private RolRepositorio rolRepositorio;

    public List<Rol> listarRoles() {
        return rolRepositorio.findAll();
    }

    // Metodo para agregar un rol
    public void agregarRol(Rol rol){
        // Corregido el nombre de la variable (antes rolRespositorio)
        rolRepositorio.rol_agregar(
            rol.getNom_rol(),
            rol.getDes_rol(),
            rol.getEst_rol()
        );
    }

    public void modificarRol(Rol rol) {
        // Se eliminó la coma sobrante después del último parámetro
        rolRepositorio.rol_modificar(
            rol.getCod_rol(),
            rol.getNom_rol(),
            rol.getDes_rol(),
            rol.getEst_rol()
        );
    }

    // Metodo para buscar un rol por su id
    public Rol buscarPorId(int cod_rol) {
        return rolRepositorio.findById(cod_rol).orElse(null);
    }

    // Se cambió el tipo de retorno a boolean para que coincida con return true/false
    public boolean eliminarRol(int cod_rol) {
        // Corregida la sintaxis de orElse(null)
        Rol rol = rolRepositorio.findById(cod_rol).orElse(null);
        if (rol != null) {
            rolRepositorio.rol_eliminar(cod_rol);
            return true;
        }
        return false;
    }
}
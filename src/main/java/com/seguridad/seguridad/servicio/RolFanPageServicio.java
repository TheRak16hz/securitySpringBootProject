package com.seguridad.seguridad.servicio;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.seguridad.seguridad.modelo.Rol_Fan_Page;
import com.seguridad.seguridad.repositorio.RolFanPageRepositorio;

public class RolFanPageServicio {
    @Autowired
    private RolFanPageRepositorio rolFanPageRepositorio;

    /**@return*/

    public List<Rol_Fan_Page> listar(){

        List<Object> resultado = rolFanPageRepositorio.rol_fan_page_listar();
        List<Rol_Fan_Page> lista = new ArrayList<>();
        for (Object obj:resultado){
            if (obj instanceof Rol_Fan_Page rolFanPage){
                lista.add(rolFanPage);
            }
        }
        return lista;
    }
}

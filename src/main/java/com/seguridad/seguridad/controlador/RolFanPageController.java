package com.seguridad.seguridad.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.seguridad.seguridad.modelo.Rol_Fan_Page;
import com.seguridad.seguridad.repositorio.RolFanPageRepositorio;

@Controller
public class RolFanPageController {
    @GetMapping("/rol_fan_page")
    public String showRolFanPageView(){
        return "rol_fan_page";
    }
    

    @Autowired
    private RolFanPageRepositorio rolFanPageRepositorio;

    @GetMapping("/rol_fan_page_listar")
    public String RolFanPageListar(Model modelo){
        //Consulta estandar JPA
        System.out.println("Entro al controlador");
        List<Rol_Fan_Page> rolfanpages = rolFanPageRepositorio.findAll();
        modelo.addAttribute("rolfanpages", rolfanpages);
        return "rol_fan_page_listar";
    }
}

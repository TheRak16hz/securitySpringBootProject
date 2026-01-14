package com.seguridad.seguridad.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.seguridad.seguridad.modelo.Rol;
import java.util.List;
import com.seguridad.seguridad.servicio.RolServicio;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RolController {

    @Autowired
    private RolServicio rolServicio;

    @GetMapping("/rol")
    public String showRolView() {
        return "rol";
    }

    @GetMapping("/rol_listar")
    public String Rollistar(Model modelo) {
        List<Rol> rols = rolServicio.listarRoles();
        modelo.addAttribute("rols", rols);
        return "rol_listar";
    }

    @GetMapping("/rol_agregar")
    public String agregarRol(Model modelo) {
        Rol nuevoRol = new Rol();
        nuevoRol.setNom_rol(""); 
        nuevoRol.setDes_rol("");
        nuevoRol.setEst_rol("");
        modelo.addAttribute("rol", nuevoRol);
        return "rol_agregar";
    }
    
    @PostMapping("/rol_agregar")
    public String agregarRol(@ModelAttribute("rol") Rol formRol, RedirectAttributes redirectAttrs) {
        try {
            formRol.setNom_rol(formRol.getNom_rol() != null ? formRol.getNom_rol().trim() : "");
            formRol.setDes_rol(formRol.getDes_rol() != null ? formRol.getDes_rol().trim() : "");
            formRol.setEst_rol(formRol.getEst_rol() != null ? formRol.getEst_rol().toUpperCase() : "A");
            rolServicio.agregarRol(formRol);
            redirectAttrs.addFlashAttribute("exito", "¡Rol agregado exitosamente!");
        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("error", "Ocurrió un error al agregar el rol: " + e.getMessage());
        }
        return "redirect:/rol_listar";
    }

    @GetMapping("/rol_editar")
    public String editarRol(@RequestParam("cod_rol") int cod_rol, Model modelo) {
        Rol rol = rolServicio.buscarPorId(cod_rol);
        modelo.addAttribute("rol", rol);
        return "rol_editar";
    }
    
    @PostMapping("/rol_editar")
    public String editarRol(@ModelAttribute("rol") Rol rol, RedirectAttributes redirectAttrs) {
        try {
            rolServicio.modificarRol(rol);
            redirectAttrs.addFlashAttribute("exito", "Rol modificado exitosamente");
        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("error", "Ocurrió un error al editar el rol");
        }
        return "redirect:/rol_listar";
    }

    @GetMapping("/rol_eliminar")
    public String eliminarRol(@RequestParam("cod_rol") int cod_rol, RedirectAttributes flash) {
        try {
            boolean eliminado = rolServicio.eliminarRol(cod_rol);
            if (eliminado) {
                flash.addFlashAttribute("exito", "El rol ha sido eliminado correctamente");
            } else {
                flash.addFlashAttribute("error", "El rol no existe o ya fue eliminado");
            }
        } catch (Exception e) {
            flash.addFlashAttribute("error", "No se pudo eliminar el rol");
        }
        return "redirect:/rol_listar";
    }
}
package com.seguridad.seguridad.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.seguridad.seguridad.modelo.TipoPrivacidad;
import java.util.List;
import com.seguridad.seguridad.servicio.TipoPrivacidadServicio;

@Controller
public class TipoPrivacidadController {
    
    // Vista del menú principal de Tipo Privacidad
    @GetMapping("/tipo_privacidad")
    public String showTipoPrivacidadView(){
        return "tipo_privacidad";
    }

    @Autowired
    private TipoPrivacidadServicio tipoPrivacidadServicio;

    // Vista de la lista (tabla)
    @GetMapping("/tipo_privacidad_listar")
    public String TipoPrivacidadListar(Model modelo) {
        List<TipoPrivacidad> listaTipos = tipoPrivacidadServicio.listarTipoPrivacidad();
        modelo.addAttribute("tiposPrivacidad", listaTipos);
        return "tipo_privacidad_listar";
    }
}
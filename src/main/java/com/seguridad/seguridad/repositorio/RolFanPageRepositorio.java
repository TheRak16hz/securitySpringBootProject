package com.seguridad.seguridad.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.seguridad.seguridad.modelo.Rol_Fan_Page;
import java.util.List;


public interface RolFanPageRepositorio extends JpaRepository<Rol_Fan_Page, Integer>{

    @Query(value = "SELECT * FROM seguridad.rol_fan_page_listar()", nativeQuery = true)
    List<Object> rol_fan_page_listar();
    
    /**
     * @param fky_per
     * @param fky_fan_pag
     * @param fky_rol
     * @param est_rol_fan
     * @return 
     */

    @org.springframework.transaction.annotation.Transactional
    @org.springframework.data.jpa.repository.Query(value= "SELECT seguridad.rol_fan_page_agregar(:fky_per,:fky_fan_pag,:fky_rol,:est_rol_fan)", nativeQuery = true)
    Integer rol_fan_page_agregar(
        @org.springframework.data.repository.query.Param("fky_per") int fky_per,
        @org.springframework.data.repository.query.Param("fky_fan_pag") int fky_fan_pag,
        @org.springframework.data.repository.query.Param("fky_rol") int fky_rol,
        @org.springframework.data.repository.query.Param("est_rol_fan") String est_rol_fan
    
    );
}


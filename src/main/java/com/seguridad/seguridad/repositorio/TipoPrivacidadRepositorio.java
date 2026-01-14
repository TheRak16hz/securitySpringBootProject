package com.seguridad.seguridad.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.seguridad.seguridad.modelo.TipoPrivacidad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface TipoPrivacidadRepositorio extends JpaRepository<TipoPrivacidad, Integer>{
 // Metodo para invocar el procedimiento almacenado:
 @Query(value = "SELECT * FROM seguridad.tipo_privacidad_listar()", nativeQuery = true)
 List<Object> tipo_privacidad_listar();
}
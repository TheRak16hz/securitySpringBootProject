package com.seguridad.seguridad.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.seguridad.seguridad.modelo.Rol;
import jakarta.transaction.Transactional;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Integer>{
 //Metodo para invocar el procedimiento almacenado (mas seguro):
 @Query(value = "SELECT * FROM seguridad.rol_listar()", nativeQuery = true)
 List<Rol> rol_listar();

 //Metodo para invocae wl procedimiento almacenado (mas seguro)
 //falto aqui

 @Transactional
 @Query(value="SELECT seguridad.rol_agregar(:nom_rol, :des_rol, :est_rol)", nativeQuery = true)
 Integer rol_agregar(@Param("nom_rol") String nom_rol, @Param("des_rol") String des_rol, @Param("est_rol") String est_rol);

 //para modificar si la funcion retorna un integer, tambien NO USAR @modifying
 @Transactional
 @Query(value ="SELECT seguridad.rol_modificar(:cod_rol, :nom_rol, :des_rol, :est_rol)", nativeQuery = true)
 Integer rol_modificar(@Param("cod_rol")int cod_rol, @Param("nom_rol") String nom_rol, @Param ("des_rol") String des_rol, @Param("est_rol") String est_rol);

    //metodo para eliminar
    @Transactional
    @Query (value = "SELECT seguridad.rol_eliminar(:cod_rol)", nativeQuery = true)
    Integer rol_eliminar(@Param("cod_rol") int cod_rol);

    //nuevo: buscar nu rol por su codigo usando el procedimiento/funcion seguridad.rol_buscar
    @Query (value = "SELECT * FROM seguridad.rol_buscar(:cod_rol)", nativeQuery = true)
    Integer rol_buscar(@Param("cod_rol") int cod_rol);


}

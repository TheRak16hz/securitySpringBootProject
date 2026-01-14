package com.seguridad.seguridad.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seguridad.seguridad.modelo.Usuario;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
 // Metodo para invocar el procedimiento almacenado (si existe en tu BD como usuario_listar):
 @Query(value = "SELECT * FROM seguridad.usuario_listar()", nativeQuery = true)
 List<Object> usuario_listar();

  //Metodo para invoca el procedimiento almacenado (mas seguro)
 //falto aqui

 @Transactional
 @Query(value="SELECT seguridad.usuario_agregar(:ali_usu, :ema_usu, :cla_usu, :est_usu)", nativeQuery = true)
 Integer usuario_agregar(@Param("ali_usu") String ali_usu, @Param("ema_usu") String ema_usu, @Param("cla_usu") String cla_usu, @Param("est_usu") String est_usu);

 //para modificar si la funcion retorna un integer, tambien NO USAR @modifying
 @Transactional
 @Query(value ="SELECT seguridad.usuario_modificar(:cod_usu, :ali_usu, :ema_usu, :cla_usu, :est_usu)", nativeQuery = true)
 Integer usuario_modificar(@Param("cod_usu")int cod_usu, @Param("ali_usu") String ali_usu, @Param ("ema_usu") String ema_usu, @Param("cla_usu") String cla_usu, @Param("est_usu") String est_usu);

 //Metodo para eliminar un rol
 @Transactional
 @Query(value = "SELECT seguridad.usuario_eliminar(:cod_usu)", nativeQuery = true)
 Integer usuario_eliminar(@Param("cod_usu") int cod_usu);

 //Nuevi: buscar un rol por su codigo usando el procedimiento/funcion seguridad.usuario_buscar
 @Query(value = "SELECT * FROM seguridad.usuario_buscar(:cod_usu)", nativeQuery = true)
 Usuario usuario_buscar(@Param("cod_usu") int cod_usu);
}
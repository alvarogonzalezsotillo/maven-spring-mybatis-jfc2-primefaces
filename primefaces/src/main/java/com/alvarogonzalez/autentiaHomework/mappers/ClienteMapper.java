package com.alvarogonzalez.autentiaHomework.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.alvarogonzalez.autentiaHomework.model.Cliente;

public interface ClienteMapper {
		  @Insert("INSERT INTO cliente(usuario, password, nombre,"
		          + "apellidos, fechaNacimiento) VALUES"
		          + "(#{usuario},#{password}, #{nombre}, #{apellidos},"
		          + "#{fechaNacimiento})")
		  @Options(useGeneratedKeys=true, keyProperty="idUsuario", flushCache=true, keyColumn="idUsuario")
		  public void insertCliente(Cliente student);

		  @Select("SELECT USUARIO as USUARIO, PASSWORD as PASSWORD, "
		          + "NOMBRE as NOMBRE, APELLIDOS as APELLIDOS, "
		          + "FECHANACIMIENTO as FECHANACIMIENTO "
		          + "FROM clientes WHERE usuario = #{usuario}")
		  public Cliente getClienteByUsuario(String usuario);

	
}

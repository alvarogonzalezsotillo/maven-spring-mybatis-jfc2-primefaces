package daw.clientes.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import daw.clientes.model.Cliente;

public interface ClienteMapper {
    @Insert("INSERT INTO cliente(usuario, password, nombre,"
            + "apellidos, fechaNacimiento) VALUES"
            + "(#{usuario},#{password}, #{nombre}, #{apellidos},"
            + "#{fechaNacimiento})")
    @Options(useGeneratedKeys = true, keyProperty = "idUsuario", flushCache = true, keyColumn = "idUsuario")
    public void insertCliente(Cliente student);

    @Select("SELECT USUARIO as USUARIO, PASSWORD as PASSWORD, "
            + "NOMBRE as NOMBRE, APELLIDOS as APELLIDOS, "
            + "FECHANACIMIENTO as FECHANACIMIENTO "
            + "FROM cliente WHERE usuario = #{usuario}")
    public Cliente getClienteByUsuario(String usuario);

}

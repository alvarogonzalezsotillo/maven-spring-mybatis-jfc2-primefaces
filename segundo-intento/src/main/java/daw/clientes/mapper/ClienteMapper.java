package daw.clientes.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    
    @Update("UPDATE USUARIO set nombre=#{nombre}, apellidos=#{apellidos}, usuario=#{usuario}, password=#{password}, fechaNacimiento=#{fechaNacimiento}"+
            "WHERE idUsuario=#{idUsuario}")
    public void updateCliente(Cliente cliente);

    @Select("SELECT USUARIO as USUARIO, PASSWORD as PASSWORD, "
            + "NOMBRE as NOMBRE, APELLIDOS as APELLIDOS, "
            + "FECHANACIMIENTO as FECHANACIMIENTO "
            + "FROM cliente")
    public List<Cliente> getClientes();
}

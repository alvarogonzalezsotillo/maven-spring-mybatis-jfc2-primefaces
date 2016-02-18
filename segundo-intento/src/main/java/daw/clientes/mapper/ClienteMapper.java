package daw.clientes.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import daw.clientes.model.Cliente;

public interface  ClienteMapper{
    @Insert("INSERT INTO cliente(usuario, password, nombre,"
            + "apellidos, fechaNacimiento) VALUES"
            + "(#{usuario},#{password}, #{nombre}, #{apellidos},"
            + "#{fechaNacimiento})")
    @Options(useGeneratedKeys = true, keyProperty = "idCliente", flushCache = true, keyColumn = "idCliente")
    public void insertNewCliente(Cliente cliente);

    @Select("SELECT IDCLIENTE as IDCLIENTE, USUARIO as USUARIO, PASSWORD as PASSWORD, "
            + "NOMBRE as NOMBRE, APELLIDOS as APELLIDOS, "
            + "FECHANACIMIENTO as FECHANACIMIENTO "
            + "FROM cliente WHERE usuario = #{usuario}")
    public Cliente getClienteByUsuario(String usuario);
    
    @Select("SELECT IDCLIENTE as IDCLIENTE, USUARIO as USUARIO, PASSWORD as PASSWORD, "
            + "NOMBRE as NOMBRE, APELLIDOS as APELLIDOS, "
            + "FECHANACIMIENTO as FECHANACIMIENTO "
            + "FROM cliente")
    public List<Cliente> getClientes();

    @Insert("update cliente set usuario=#{usuario},  password=#{password}, nombre=#{nombre},"
            + "apellidos=#{apellidos}, fechaNacimiento=#{fechaNacimiento} where idCliente=#{idCliente}" )
    public void updateCliente(Cliente cliente);

    @Delete("delete from cliente where idCliente=#{idCliente}")
    public void deleteCliente(Cliente c);
}

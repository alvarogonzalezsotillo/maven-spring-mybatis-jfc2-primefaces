package daw.clientes.service;

import daw.clientes.model.Cliente;





public interface ClienteService {

	void insertCliente(Cliente cliente);

	boolean getClienteByLogin(String usaurio, String password);

	boolean getClienteByUsuario(String usaurio);

}

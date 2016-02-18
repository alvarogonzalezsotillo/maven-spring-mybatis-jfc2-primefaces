package daw.clientes.service;

import org.springframework.stereotype.Service;

import daw.clientes.model.Cliente;

import java.util.List;

public interface ClienteService {

	void insertNewCliente(Cliente cliente);
	
	void updateCliente(Cliente cliente);

	boolean getClienteByLogin(String usaurio, String password);

	boolean getClienteByUsuario(String usaurio);

	public List<Cliente> getClientes();

}

package com.alvarogonzalez.autentiaHomework.service;

import com.alvarogonzalez.autentiaHomework.model.Cliente;

public interface ClienteService {

	void insertCliente(Cliente cliente);

	boolean getClienteByLogin(String usaurio, String password);

	boolean getClienteByUsuario(String usaurio);

}

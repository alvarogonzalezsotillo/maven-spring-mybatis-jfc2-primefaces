package com.alvarogonzalez.autentiaHomework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alvarogonzalez.autentiaHomework.mappers.ClienteMapper;
import com.alvarogonzalez.autentiaHomework.model.Cliente;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {

  @Autowired
  private ClienteMapper clienteMapper;

  @Transactional
  public void insertCliente(Cliente student) {        
      clienteMapper.insertCliente(student);
  }

  public boolean getClienteByLogin(String userName, String password) {        
      Cliente student = clienteMapper.getClienteByUsuario(userName);

      if(student != null && student.getPassword().equals(password)) {
          return true;
      }

      return false;
  }

  public boolean getClienteByUsuario(String userName) {
	  Cliente student = clienteMapper.getClienteByUsuario(userName);

      if(student != null) {
          return true;
      }

      return false;
  }

}
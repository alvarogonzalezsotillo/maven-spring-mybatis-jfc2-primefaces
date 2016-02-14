package daw.clientes.controller;

import static daw.clientes.UnLogger.log;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import daw.clientes.model.ClienteLogin;
import daw.clientes.service.ClienteService;

@ManagedBean
public class LoginController {

  @Autowired
  private ClienteService clienteService;
  
  public LoginController(){
      log( "Creado LoginController");
  }
  


}
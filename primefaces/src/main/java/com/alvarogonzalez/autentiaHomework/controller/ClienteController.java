package com.alvarogonzalez.autentiaHomework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alvarogonzalez.autentiaHomework.model.Cliente;
import com.alvarogonzalez.autentiaHomework.service.ClienteService;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  @RequestMapping(value="/signup", method=RequestMethod.GET)
  public String signup(Model model) {
      Cliente cliente = new Cliente();
      model.addAttribute("cliente", cliente);
      return "signup";
  }

  @RequestMapping(value="/signup", method=RequestMethod.POST)
  public String signup(@ModelAttribute("cliente") Cliente cliente, Model model) {
      if(clienteService.getClienteByUsuario(cliente.getUsuario())) {
          model.addAttribute("message", "El usuario ya existe");
          return "signup";
      } else {
          clienteService.insertCliente(cliente);
          model.addAttribute("message", "Detalles del cliente en base de datos");
          return "redirect:login.html";
      }
  }

}
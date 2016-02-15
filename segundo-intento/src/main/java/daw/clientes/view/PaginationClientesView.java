package daw.clientes.view;


import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import daw.clientes.model.Cliente;
import daw.clientes.service.ClienteService;
import java.util.List;
import static daw.clientes.UnLogger.log;

@ManagedBean
@Controller
@Scope("request")
public class PaginationClientesView {


    @Autowired
    private ClienteService elClienteService;

	public PaginationClientesView() {
	    log( "Crean un PaginationClientesView");
	}

	public List<Cliente> getClientes(){
		return elClienteService.getClientes();
	}
}

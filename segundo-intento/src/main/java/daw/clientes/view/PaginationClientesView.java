package daw.clientes.view;


import static daw.clientes.UnLogger.log;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import daw.clientes.model.Cliente;
import daw.clientes.service.ClienteService;

@ManagedBean
@Controller
@Scope("request")

public class PaginationClientesView {

    private Cliente _selectedCliente;

    public Cliente getSelectedCliente() {
        return _selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        _selectedCliente = selectedCliente;
        log( "PaginationClientesView: setSelected:" + _selectedCliente );
    }

    @Autowired
    private ClienteService elClienteService;

	public PaginationClientesView() {
	    log( "Crean un PaginationClientesView");
	}

	public List<Cliente> getClientes(){
		return elClienteService.getClientes();
	}
	
    public void nuevoClienteAction(ActionEvent actionEvent) {
        log( "nuevoClienteAction: " + actionEvent );
        Cliente c = new Cliente();
        c.setUsuario( "nuevo usuario");
        setSelectedCliente(c);
    }

    public void nuevoClienteAction() {
        log( "nuevoClienteAction" );
        Cliente c = new Cliente();
        c.setUsuario( "nuevo usuario");
        setSelectedCliente(c);
    }
     
}

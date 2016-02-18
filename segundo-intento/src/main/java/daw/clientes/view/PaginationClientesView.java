package daw.clientes.view;


import static daw.clientes.UnLogger.log;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import daw.clientes.model.Cliente;
import daw.clientes.service.ClienteService;

@ManagedBean
@Controller
@ViewScoped
public class PaginationClientesView {

    private Cliente _selectedCliente;
    private Cliente _editedCliente;

    
    public static int INVALID_CLIENTE_ID = -1;
    public static int NEW_CLIENTE_ID = 0;
    
    public Cliente getSelectedCliente() {
        if( _selectedCliente == null ){
            return nuevoClienteInvalido();
        }
        return _selectedCliente;
    }

    private Cliente nuevoClienteInvalido() {
        Cliente c = new Cliente();
        c.setIdCliente(INVALID_CLIENTE_ID);
        c.setUsuario("");
        c.setPassword("");
        c.setNombre("");
        c.setApellidos("");
        c.setFechaNacimiento(new Date());
        
        return c;
        
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
	

    public void nuevoClienteAction() {
        log( "nuevoClienteAction" );
        Cliente c = nuevoClienteInvalido();
        c.setUsuario( "nuevo usuario");
        c.setIdCliente(NEW_CLIENTE_ID);
        setEditedCliente(c);
    }
    
    public void editarClienteSeleccionadoAction(){
        Cliente c = getSelectedCliente();
        log( "Editar cliente:" + c );
        setEditedCliente(c);
    }
    
    public void salvarClienteAction(){
        Cliente c = getEditedCliente();
        log( "salvarClienteAction:" + c );
        if( c.getIdCliente() == NEW_CLIENTE_ID ){
            elClienteService.insertNewCliente(c);
        }
        else if( c.getIdCliente() == INVALID_CLIENTE_ID ){
            throw new IllegalStateException();
        }
        else{
            elClienteService.updateCliente(c);
        }
    }

    public Cliente getEditedCliente() {
        if( _editedCliente == null ){
            return nuevoClienteInvalido();
        }
        return _editedCliente;
    }

    public void setEditedCliente(Cliente editedCliente) {
        log( "PaginationClientesView: setEdited:" + editedCliente );
        
        _editedCliente = editedCliente;
    }
     
}

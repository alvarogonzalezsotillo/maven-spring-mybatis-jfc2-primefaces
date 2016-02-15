package daw.clientes.view;


import static daw.clientes.UnLogger.log;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import daw.clientes.model.Cliente;
import daw.clientes.service.ClienteService;

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
	
	public void onCellEditTableComplete(CellEditEvent event) {
		log("onCellEditTableComplete: " + event );
	    DataTable dataTable = (DataTable) event.getSource();
	    Cliente c = (Cliente) dataTable.getRowData();
	    log("onCellEditTableComplete: c:" + c );
	}
	
	public void rowEdit(RowEditEvent event) {
	    log("rowEdit:" + event );
	    log("  source"+event.getSource());
	    log("  component"+event.getComponent());
	    log("  object"+event.getObject());
	}
}

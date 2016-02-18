package daw.clientes.service;

import static daw.clientes.UnLogger.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daw.clientes.mapper.ClienteMapper;
import daw.clientes.model.Cliente;

@Service("elClienteService")
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    @Transactional
    public void insertNewCliente(Cliente student) {
        clienteMapper.insertNewCliente(student);
    }

    @Override
    public boolean getClienteByLogin(String userName, String password) {
        Cliente student = clienteMapper.getClienteByUsuario(userName);

        if (student != null && student.getPassword().equals(password)) {
            return true;
        }

        return false;
    }

    @Override
    public boolean getClienteByUsuario(String userName) {
        Cliente student = clienteMapper.getClienteByUsuario(userName);

        if (student != null) {
            return true;
        }

        return false;
    }

    @Override
    public List<Cliente> getClientes() {
        log("ClienteService: getClientes");
        return clienteMapper.getClientes();
    }

    @Override
    @Transactional
    public void updateCliente(Cliente cliente) {
        clienteMapper.updateCliente(cliente);
    }
}
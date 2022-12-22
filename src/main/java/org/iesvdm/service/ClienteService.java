package org.iesvdm.service;

import java.util.List;
import java.util.Optional;

import org.iesvdm.dao.ClienteDAO;
import org.iesvdm.modelo.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	private ClienteDAO clienteDAO;
	
	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public ClienteService(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
	public List<Cliente> listAll() {
		
		return clienteDAO.getAll();
		
	}
	
	public void newCliente(Cliente cliente) {
		
		clienteDAO.create(cliente);
	
	}
	
	public Cliente find(int id) {
		
		Optional<Cliente> opCli = clienteDAO.find(id);
		
		if(opCli.isPresent()) {
			return opCli.get();
		}else {
			return null;
		}
	
	}
	
	public void updateCliente(Cliente cliente) {
		clienteDAO.update(cliente);
	}
	
	public void deleteCliente(Integer id) {
		clienteDAO.delete(id);
	}

}

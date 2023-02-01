package org.iesvdm.service;

import java.util.List;
import java.util.Optional;

import org.iesvdm.dao.ComercialDAO;
import org.iesvdm.dao.PedidoDAO;
import org.iesvdm.dao.ClienteDAO;
import org.iesvdm.modelo.ClienteDTO;
import org.iesvdm.modelo.Comercial;
import org.iesvdm.modelo.ComercialDTO;
import org.iesvdm.modelo.Pedido;
import org.iesvdm.modelo.PedidoDTO;
import org.springframework.stereotype.Service;

@Service
public class ComercialService {
	
	private ComercialDAO comercialDAO;
	private PedidoDAO pedidoDAO;
	private ClienteDAO clienteDAO;
	
	public ComercialService(ComercialDAO comercialDAO, PedidoDAO pedidoDAO, ClienteDAO clienteDAO) {
		this.comercialDAO = comercialDAO;
		this.pedidoDAO = pedidoDAO;
		this.clienteDAO = clienteDAO;
	}
	
	public List<Comercial> listAll() {
		
		return comercialDAO.getAll();
		
	}
	
	public void newComercial(Comercial comercial) {
		
		comercialDAO.create(comercial);
	
	}
	
	public Comercial find(int id) {
		
		Optional<Comercial> opCli = comercialDAO.find(id);
		
		if(opCli.isPresent()) {
			return opCli.get();
		}else {
			return null;
		}
	
	}
	
	public void updateComercial(Comercial comercial) {
		comercialDAO.update(comercial);
	}
	
	public void deleteComercial(Integer id) {
		comercialDAO.delete(id);
	}

	public List<Pedido> getPedidos(Integer id) {
		return pedidoDAO.getSelectedFromComercial(id);
	}
	
	public List<PedidoDTO> getPedidosDTO(Integer id) {
		return pedidoDAO.getSelectedFromComercialWClients(id);
	}
	
	public ComercialDTO findwData(int id) {
		
		Optional<ComercialDTO> opComDTO = comercialDAO.findwData(id);
		
		if(opComDTO.isPresent()) {
			return opComDTO.get();
		}else {
			return null;
		}
	}
	
	public List<ClienteDTO> listClientebyTotalPedido(int id){
		return clienteDAO.getfromComerciantebyTotalPedido(id);
	}
	
	public Pedido getMaxFromComercial(int id) {
		return pedidoDAO.getMaxFromComercial(id);
	}
	
	public Pedido getMinFromComercial(int id) {
		return pedidoDAO.getMinFromComercial(id);
	}
	
	public int getCountPedidosfCliente(int id) {
		return comercialDAO.getCountPedidosfCliente(id);
	}
}

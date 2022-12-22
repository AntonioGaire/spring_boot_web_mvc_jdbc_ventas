package org.iesvdm.service;

import java.util.List;
import java.util.Optional;

import org.iesvdm.dao.ComercialDAO;
import org.iesvdm.dao.PedidoDAO;
import org.iesvdm.modelo.Comercial;
import org.iesvdm.modelo.Pedido;
import org.iesvdm.modelo.PedidoDTO;
import org.springframework.stereotype.Service;

@Service
public class ComercialService {
	
	private ComercialDAO comercialDAO;
	private PedidoDAO pedidoDAO;
	
	public ComercialService(ComercialDAO comercialDAO, PedidoDAO pedidoDAO) {
		this.comercialDAO = comercialDAO;
		this.pedidoDAO = pedidoDAO;
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
}

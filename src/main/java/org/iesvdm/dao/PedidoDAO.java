package org.iesvdm.dao;

import java.util.List;

import org.iesvdm.modelo.Pedido;
import org.iesvdm.modelo.PedidoDTO;

public interface PedidoDAO {
	public List<Pedido> getAll();
	public List<PedidoDTO> getAllWClients();
	
	public List<Pedido> getSelectedFromComercial(int id);
	public List<PedidoDTO> getSelectedFromComercialWClients(int id);
}

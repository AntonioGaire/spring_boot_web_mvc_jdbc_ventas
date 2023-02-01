package org.iesvdm.dao;

import java.util.List;
import java.util.Optional;

import org.iesvdm.DTO.ComercialDTOMS;
import org.iesvdm.modelo.Cliente;
import org.iesvdm.modelo.ClienteDTO;

public interface ClienteDAO {

	public void create(Cliente cliente);
	
	public List<Cliente> getAll();
	public Optional<Cliente>  find(int id);
	
	public void update(Cliente cliente);
	
	public void delete(long id);
	
	public List<ClienteDTO> getfromComerciantebyTotalPedido(int id);
	
	public List<ComercialDTOMS> getComerciaeslwNPedidos(int id);
	
	public int getPedidoswTime(int id, int timeframe);
	
}

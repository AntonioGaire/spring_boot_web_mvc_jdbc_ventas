package org.iesvdm.dao;

import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Comercial;
import org.iesvdm.modelo.ComercialDTO;

public interface ComercialDAO {

	public void create(Comercial comercial);
	
	public List<Comercial> getAll();
	public Optional<Comercial>  find(int id);
	
	public void update(Comercial comercial);
	
	public void delete(int id);
	
	public List<ComercialDTO> getAllwStats();
	public Optional<ComercialDTO> findwData(int id);
	
	public int getCountPedidosfCliente(int id);
	
}

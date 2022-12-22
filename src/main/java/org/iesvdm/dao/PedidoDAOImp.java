package org.iesvdm.dao;

import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Pedido;
import org.iesvdm.modelo.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository

@Slf4j

@AllArgsConstructor

public class PedidoDAOImp implements PedidoDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Pedido> getAll() {
		List<Pedido> listPed = jdbcTemplate.query(
                "SELECT * FROM pedido",
                (rs, rowNum) -> new Pedido(rs.getInt("id"),
                						 	rs.getFloat("total"),
                						 	rs.getString("fecha"),
                						 	rs.getInt("id_cliente"),
                						 	rs.getInt("id_comercial")
                						 	)
        );
		
		log.info("Devueltos {} registros.", listPed.size());
		
        return listPed;
	}

	@Override
	public List<PedidoDTO> getAllWClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> getSelectedFromComercial(int id) {
		List<Pedido> listPed =  jdbcTemplate
				.query("SELECT * FROM pedido WHERE id_comercial = ?"														
								, (rs, rowNum) -> new Pedido(rs.getInt("id"),
            						 	rs.getFloat("total"),
            						 	rs.getString("fecha"),
            						 	rs.getInt("id_cliente"),
            						 	rs.getInt("id_comercial")
            						 	)
								, id
								);
		
		log.info("Devueltos {} registros.", listPed.size());
		
        return listPed;
	}

	@Override
	public List<PedidoDTO> getSelectedFromComercialWClients(int id) {
		List<PedidoDTO> listPed =  jdbcTemplate
				.query("\n"
						+ "SELECT pedido.id, pedido.total, pedido.fecha, pedido.id_cliente, pedido.id_comercial, concat_WS(\" \", cliente.nombre, cliente.apellido1, cliente.apellido2) as nombre_cliente FROM pedido inner join cliente on pedido.id_cliente=cliente.id WHERE id_comercial = ?;"														
								, (rs, rowNum) -> new PedidoDTO(rs.getInt("pedido.id"),
            						 	rs.getFloat("pedido.total"),
            						 	rs.getString("pedido.fecha"),
            						 	rs.getInt("pedido.id_cliente"),
            						 	rs.getInt("pedido.id_comercial"),
            						 	rs.getString("nombre_cliente")
            						 	)
								, id
								);
		
		log.info("Devueltos {} registros.", listPed.size());
		
        return listPed;
	}

}

package org.iesvdm.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PedidoDTO extends Pedido{
	public String nombre_cliente;

	public PedidoDTO(int id, float total, String fecha, int id_cliente, int id_comercial, String nombre_cliente) {
		super(id, total, fecha, id_cliente, id_comercial);
		this.nombre_cliente=nombre_cliente;
	}

	
	
}

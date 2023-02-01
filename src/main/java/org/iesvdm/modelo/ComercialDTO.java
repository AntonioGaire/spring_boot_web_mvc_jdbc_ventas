package org.iesvdm.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ComercialDTO extends Comercial{
	
	private float totalPedidos;
	private float mediaPedidos;
	public ComercialDTO(int id, String nombre, String apellido1, String apellido2, float comision, float totalPedidos, float mediaPedidos) {
		
		super(id, nombre, apellido1, apellido2, comision);
		this.totalPedidos=totalPedidos;
		this.mediaPedidos=mediaPedidos;
		
	}
	
	
}

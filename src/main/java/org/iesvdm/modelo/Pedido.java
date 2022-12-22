package org.iesvdm.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pedido {
	
	public int id;
	public float total;
	public String fecha;
	public int id_cliente;
	public int id_comercial;

}

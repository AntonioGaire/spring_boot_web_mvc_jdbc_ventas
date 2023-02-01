package org.iesvdm.DTO;

import java.util.List;

import org.iesvdm.modelo.ClienteDTO;
import org.iesvdm.modelo.Pedido;
import org.iesvdm.modelo.PedidoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor


public class ComercialDTOMS {

	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private float comision;

	private int pedidosRealizados;

}

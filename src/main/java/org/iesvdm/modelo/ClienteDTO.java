package org.iesvdm.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteDTO extends Cliente {
	private float totalpedido;

	public ClienteDTO(long id, String nombre, String apellido1, String apellido2, String ciudad, int categoria,String email, float totalpedido) {
		super(id, nombre, apellido1, apellido2, ciudad, categoria, email);
		this.totalpedido = totalpedido;
	}
	
	
}

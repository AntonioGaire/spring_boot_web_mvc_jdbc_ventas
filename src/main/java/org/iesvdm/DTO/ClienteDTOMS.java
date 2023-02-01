package org.iesvdm.DTO;

import java.util.List;

import org.iesvdm.modelo.Comercial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor

public class ClienteDTOMS {

	private long id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String ciudad;
	private int categoria;
	private String email;
	
	private List<ComercialDTOMS> comercialesAsociados;
	
	private int pedidosTrimestre;
	private int pedidosSemestre;
	private int pedidosYear;
	private int pedidosLustro;

}

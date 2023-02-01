package org.iesvdm.modelo;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//La anotación @Data de lombok proporcionará el código de: 
//getters/setters, toString, equals y hashCode
//propio de los objetos POJOS o tipo Beans
@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("unused")

public class Comercial {
	private int id;
	
	@NotBlank(message="Introduce nombre")
	@Size(max=30, message="Nombre demasiado largo")
	private String nombre;
	
	@NotBlank(message="Introduce apellido")
	@Size(max=30, message="Apellido demasiado largo")
	private String apellido1;
	private String apellido2;
	
	@DecimalMin(value="0.276", inclusive=true, message="Comisión inferior a 0.276") 
	@DecimalMax(value="0.946", inclusive=true, message="Comisión superior a 0.946")
	private float comision;
}

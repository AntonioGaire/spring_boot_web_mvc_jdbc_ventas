package org.iesvdm.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.iesvdm.validator.RangoCategoria;

import jakarta.validation.constraints.*;
//La anotación @Data de lombok proporcionará el código de: 
//getters/setters, toString, equals y hashCode
//propio de los objetos POJOS o tipo Beans
@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
public class Cliente {
	
	public Cliente(){}
	
	private long id;
	
	@NotBlank(message="Introduce nombre")
	@Size(max=30, message="{error.name.length.max}")
	private String nombre;
	
	@NotBlank(message="Introduce apellido")
	@Size(max=30, message="Apellido demasiado largo")
	private String apellido1;
	
	private String apellido2;
	
	@Size(max=50, message="Nombre de Ciudad demasiado largo")
	private String ciudad;
	/*
	@Min(value=100, message="Categoria minima 100")
	@Max(value=10000, message="Categoria maxima 1000")
	*/
	@RangoCategoria({100,101, 200, 300, 400, 500, 600, 700, 800, 900, 1000})
	private int categoria;
	
	@Email(message = "Formato de email incorrecto. Ha introducido '${validatedValue}'", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	private String email;
	
}

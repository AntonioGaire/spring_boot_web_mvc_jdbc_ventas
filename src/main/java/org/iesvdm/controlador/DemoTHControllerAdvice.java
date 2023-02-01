package org.iesvdm.controlador;

import org.iesvdm.excepcion.MiExcepcion;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DemoTHControllerAdvice {
	
	@ExceptionHandler(MiExcepcion.class)
	public String handleMiExcepcion(Model model, MiExcepcion miExcepcion) {
		
		model.addAttribute("traza", miExcepcion.getMessage());
		return "error-mi-excepcion";
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handleUncoughtException(Model model, RuntimeException exception){
		model.addAttribute("traza", exception.getMessage());
		return "error";
	}
}

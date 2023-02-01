package org.iesvdm.controlador;

import java.util.Comparator;
import java.util.List;

import org.iesvdm.excepcion.MiExcepcion;
import org.iesvdm.mapstruct.ComercialMapper;
import org.iesvdm.modelo.ClienteDTO;
import org.iesvdm.modelo.Comercial;
import org.iesvdm.modelo.ComercialDTO;
import org.iesvdm.modelo.Pedido;
import org.iesvdm.modelo.PedidoDTO;
import org.iesvdm.service.ComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.validation.Valid;

@Controller

public class ComercialController {
	
	private ComercialService comercialService;
	
	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public ComercialController(ComercialService comercialService) {
		this.comercialService = comercialService;
	}
	
	
	@GetMapping("/comerciales") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
	public String listar(Model model) {
		
		List<Comercial> listaComerciales =  comercialService.listAll();
		model.addAttribute("listaComerciales", listaComerciales);
				
		return "comerciales";
		
	}
	
	@GetMapping("/comerciales/crear")
	public String crear(Model model) {
		
		Comercial comercial = new Comercial();
		
		model.addAttribute("comercial", comercial);
		
		return "crear-comercial";
	}
	
	@PostMapping({"/comerciales/crear", "/comerciales/crear/"})
	public String submitCrear(@Valid @ModelAttribute("comercial") Comercial comercial, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "crear-comercial";
		}
		
		comercialService.newComercial(comercial);
				
		return "redirect:/comerciales";
		
	}
	
	@GetMapping("/comerciales/{id}")
	public String detalle(Model model, @PathVariable Integer id ) {
		
		/*
		Comercial comercial = comercialService.find(id);
		
		model.addAttribute("comercial", comercial);
		
		List<Pedido> pedidos = comercialService.getPedidos(id);
		model.addAttribute("listaPedidos", pedidos);
		 */
		
		ComercialDTO comercial = comercialService.findwData(id);
		
		model.addAttribute("comercial", comercial);

		List<PedidoDTO> pedidos = comercialService.getPedidosDTO(id);
		model.addAttribute("listaPedidos", pedidos);
		
		Pedido maxPedido = comercialService.getMaxFromComercial(id);
		Pedido minPedido = comercialService.getMinFromComercial(id);
		
		model.addAttribute("maxPedido", maxPedido);
		model.addAttribute("minPedido", minPedido);
		
		List<ClienteDTO> clientes = comercialService.listClientebyTotalPedido(id);
		model.addAttribute("clientes",clientes);
		
		return "detalle-comercial";
		
	}
	
	@GetMapping("/comerciales/editar/{id}")
	public String editar(Model model, @PathVariable Integer id) {
		
		Comercial comercial = comercialService.find(id);
		
		model.addAttribute("comercial", comercial);
		
		return "editar-comercial";
	}
	
	@PostMapping("/comerciales/editar/{id}")
	public String submitEditar(@Valid @ModelAttribute("comercial") Comercial comercial, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "editar-comercial";
		}
		
		comercialService.updateComercial(comercial);
				
		return "redirect:/comerciales";
		
	}
	
	@PostMapping("comerciales/borrar/{id}")
	public RedirectView submitBorrar(@PathVariable Integer id) {
		comercialService.deleteComercial(id);
		return new RedirectView("/comerciales");
	}
	
	@GetMapping("/demoth-runtime-excepcion")
	public String demothRuntimeException() {
		throw new RuntimeException("PRUEBA DE RUNTIME EXCEPTION");
	}
	
	@GetMapping("/comerciales/demoth-mi-excepcion")
	public String demothMiException() throws MiExcepcion{
		throw new MiExcepcion();
	}
	

}

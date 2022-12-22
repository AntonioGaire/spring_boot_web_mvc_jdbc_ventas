package org.iesvdm.controlador;

import java.util.List;

import org.iesvdm.modelo.Comercial;
import org.iesvdm.modelo.Pedido;
import org.iesvdm.modelo.PedidoDTO;
import org.iesvdm.service.ComercialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

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
	public RedirectView submitCrear(@ModelAttribute("comercial") Comercial comercial) {
		
		comercialService.newComercial(comercial);
				
		return new RedirectView("/comerciales") ;
		
	}
	
	@GetMapping("/comerciales/{id}")
	public String detalle(Model model, @PathVariable Integer id ) {
		
		Comercial comercial = comercialService.find(id);
		
		model.addAttribute("comercial", comercial);
		
		/*
		List<Pedido> pedidos = comercialService.getPedidos(id);
		model.addAttribute("listaPedidos", pedidos);
		 */

		List<PedidoDTO> pedidos = comercialService.getPedidosDTO(id);
		model.addAttribute("listaPedidos", pedidos);
		
		return "detalle-comercial";
	}
	
	@GetMapping("/comerciales/editar/{id}")
	public String editar(Model model, @PathVariable Integer id) {
		
		Comercial comercial = comercialService.find(id);
		
		model.addAttribute("comercial", comercial);
		
		return "editar-comercial";
	}
	
	@PostMapping("/comerciales/editar/{id}")
	public RedirectView submitEditar(@ModelAttribute("comercial") Comercial comercial) {
		
		comercialService.updateComercial(comercial);
				
		return new RedirectView("/comerciales") ;
		
	}
	
	@PostMapping("comerciales/borrar/{id}")
	public RedirectView submitBorrar(@PathVariable Integer id) {
		comercialService.deleteComercial(id);
		return new RedirectView("/comerciales");
	}
	
	
	

}

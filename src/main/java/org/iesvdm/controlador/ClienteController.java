package org.iesvdm.controlador;

import java.util.List;

import org.iesvdm.DTO.ClienteDTOMS;
import org.iesvdm.DTO.ComercialDTOMS;
import org.iesvdm.mapstruct.ClienteMapper;
import org.iesvdm.modelo.Cliente;
import org.iesvdm.modelo.Comercial;
import org.iesvdm.service.ClienteService;
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
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /clientes como
//prefijo.
//@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteMapper clienteMapper;
	
	private ClienteService clienteService;
	private ComercialService comercialService;
	
	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public ClienteController(ClienteService clienteService, ComercialService comercialService) {
		this.clienteService = clienteService;
		this.comercialService = comercialService;
	}
	
	//@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	//equivalente a la siguiente anotación
	@GetMapping("/clientes") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
	public String listar(Model model) {
		
		List<Cliente> listaClientes =  clienteService.listAll();
		model.addAttribute("listaClientes", listaClientes);
				
		return "clientes";
		
	}
	
	@GetMapping("/clientes/crear")
	public String crear(Model model) {
		
		Cliente cliente = new Cliente();
		
		model.addAttribute("cliente", cliente);
		
		return "crear-cliente";
	}
	
	@PostMapping({"/clientes/crear", "/clientes/crear/"})
	public String submitCrear(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult bindingResult) {
				
		if (bindingResult.hasErrors()) {
			return "crear-cliente";
		}
				
		clienteService.newCliente(cliente);
		
		return "redirect:/clientes";
		
	}
	
	@GetMapping("/clientes/{id}")
	public String detalle(Model model, @PathVariable Integer id ) {
		
		Cliente cliente = clienteService.find(id);
		
		int npedtri = clienteService.getPedidoswTime(id, 90);
		int npedsem = clienteService.getPedidoswTime(id, 180);
		int npedyea = clienteService.getPedidoswTime(id, 365);
		int npedlus = clienteService.getPedidoswTime(id, 1825);
		
		List<ComercialDTOMS> comerciales= clienteService.getComerciaeslwNPedidos(id);
		
		ClienteDTOMS clienteDTO = clienteMapper.ClienteAClienteDTOMS(cliente, comerciales, npedtri, npedsem, npedyea, npedlus);
		
		model.addAttribute("cliente", clienteDTO);

		return "detalle-cliente";
	}
	
	@GetMapping("/clientes/editar/{id}")
	public String editar(Model model, @PathVariable Integer id) {
		
		Cliente cliente = clienteService.find(id);
		
		model.addAttribute("cliente", cliente);
		
		return "editar-cliente";
	}
	
	@PostMapping("/clientes/editar/{id}")
	public String submitEditar(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "editar-cliente";
		}
		
		clienteService.updateCliente(cliente);
				
		return "redirect:/clientes";
		
	}
	
	@PostMapping("clientes/borrar/{id}")
	public RedirectView submitBorrar(@PathVariable Integer id) {
		clienteService.deleteCliente(id);
		return new RedirectView("/clientes");
	}

}

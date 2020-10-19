package br.com.alura.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dao.PedidoDao;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoDao pedidoDao;

	@GetMapping("/formulario")
	public String formulario() {
		System.out.println("chegou");
		return "home";
	}
}

package br.com.alura.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dao.PedidoDao;
import br.com.alura.mvc.mudi.dto.RequestNovoPedido;
import br.com.alura.mvc.mudi.model.Pedido;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoDao pedidoDao;

	@GetMapping("formulario")
	public String formulario() {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String cadastraPedido(RequestNovoPedido requisicao) {
		Pedido pedido = requisicao.toPedido();
		pedidoDao.save(pedido);
		return "home";
	}
}

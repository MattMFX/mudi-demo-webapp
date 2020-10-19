package br.com.alura.mvc.mudi.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.dao.PedidoDao;
import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeController {


	@Autowired
	private PedidoDao pedidoDao;
	
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNome("Echo dot");
		pedido.setData(LocalDateTime.now());
		pedido.setDescricao("Caixa de som com alexa integrada");
		pedido.setValor(new BigDecimal(200.00));
		pedido.setUrlProduto("https://www.amazon.com.br/Echo-Dot-3%C2%AA-Gera%C3%A7%C3%A3o-Cor-Preta/dp/B07PDHSJ1H/ref=sr_1_1?__mk_"
				+ "pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=19VM998APKE9U&dchild=1&keywords=echo+dot&qid=1602550531&smid=A1ZZFT5FULY4LN&s"
				+ "prefix=echo+do%2Caps%2C1863&sr=8-1");
		pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/61Rr8uxmREL._AC_SL1000_.jpg");
		
		pedidoDao.createPedido(pedido);	
		List<Pedido> pedidos = pedidoDao.readPedidos();
		
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
	
}

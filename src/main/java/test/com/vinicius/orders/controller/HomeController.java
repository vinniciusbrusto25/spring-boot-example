package test.com.vinicius.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import test.com.vinicius.orders.model.ProductOrder;
import test.com.vinicius.orders.repository.ProductOrderRepository;

@Controller
public class HomeController {
	
	@Autowired
	private ProductOrderRepository productOrderRepository;
	
	@GetMapping("/home")
	public String home(Model model) {
		List<ProductOrder> productsList = productOrderRepository.findAll();
		model.addAttribute("productList", productsList);
		return "home";
	}

}

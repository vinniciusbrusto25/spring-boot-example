package test.com.vinicius.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import test.com.vinicius.orders.enums.ProductOrderStatus;
import test.com.vinicius.orders.model.ProductOrder;
import test.com.vinicius.orders.repository.ProductOrderRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private ProductOrderRepository productOrderRepository;
	
	@GetMapping
	public String home(Model model) {
		List<ProductOrder> productsList = productOrderRepository.findAll();
		model.addAttribute("productList", productsList);
		return "home";
	}
	
	/**
	 * Variable path usage example. {status} is a variable
	 * that user defines its value by the request method.
	 * 
	 * @param model
	 * @return view to be showed.
	 */
	
	@GetMapping("/{status}")
	public String byStatus(@PathVariable("status") String status, Model model) {
		List<ProductOrder> productsList = productOrderRepository.findByOrderStatus(ProductOrderStatus.valueOf(status.toUpperCase()));
		model.addAttribute("productList", productsList);
		model.addAttribute("status", status);
		return "home";
	}
	
	/**
	 * Exception treatment of bad requests. In this case, it is redirecting to 
	 * home page.
	 * 
	 * @return
	 */
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}

}

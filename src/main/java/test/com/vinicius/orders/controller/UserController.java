package test.com.vinicius.orders.controller;

import java.security.Principal;
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
@RequestMapping("user")
public class UserController {

	@Autowired
	private ProductOrderRepository productOrderRepository;
	
	/**
	 * "Principal" argument provides user details information, like the user name.
	 * 
	 * @param model
	 * @param principal
	 * @return
	 */
	
	@GetMapping("orders")
	public String home(Model model, Principal principal) {
		List<ProductOrder> productsList = productOrderRepository.findAllByUsername(principal.getName());
		model.addAttribute("productList", productsList);
		return "user/home";
	}
	
	/**
	 * Variable path usage example. {status} is a variable
	 * that user defines its value by the request method.
	 * 
	 * @param model
	 * @return view to be showed.
	 */
	
	@GetMapping("orders/{status}")
	public String byStatus(@PathVariable("status") String status, Model model, Principal principal) {
		List<ProductOrder> productsList = productOrderRepository.findByOrderStatusAndUser(ProductOrderStatus.valueOf(status.toUpperCase()), principal.getName());
		model.addAttribute("productList", productsList);
		model.addAttribute("status", status);
		return "user/home";
	}
	
	/**
	 * Exception treatment of bad requests. In this case, it is redirecting to 
	 * home page.
	 * 
	 * @return
	 */
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/user/home";
	}
	
}

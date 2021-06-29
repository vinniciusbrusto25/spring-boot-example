package test.com.vinicius.orders.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import test.com.vinicius.orders.dto.RequestNewProductDto;
import test.com.vinicius.orders.model.ProductOrder;
import test.com.vinicius.orders.model.User;
import test.com.vinicius.orders.repository.ProductOrderRepository;
import test.com.vinicius.orders.repository.UserRepository;

@Controller
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	private ProductOrderRepository productOrderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Calls the form page and needs the RequestNewProductDto too.
	 * 
	 * @return String view page.
	 */
	
	@GetMapping("newProductForm")
	public String newProductForm(RequestNewProductDto requestNewProductDto) {
		return "order/newProductForm";
	}
	
	/**
	 * This is called by the "Submit" button in the form using POST method. 
	 * 
	 * The @valid annotation means say to spring that it need
	 * to validate attributes annotated with some validation 
	 * annotation.
	 * 
	 * @param requestNewProductDto
	 * @param bindingResult
	 * @return view to be showed
	 */
	
	@PostMapping("newProduct")
	public String newProduct(@Valid RequestNewProductDto requestNewProductDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("Has errors!");
			return "order/newProductForm";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(username);
		
		
		ProductOrder productOrder = requestNewProductDto.toProductOrder();
		productOrder.setUser(user);
		productOrderRepository.save(productOrder);
		return "redirect:/home";
	}

}

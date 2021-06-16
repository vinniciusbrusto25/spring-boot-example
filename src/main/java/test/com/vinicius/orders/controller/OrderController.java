package test.com.vinicius.orders.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import test.com.vinicius.orders.dto.RequestNewProductDto;
import test.com.vinicius.orders.model.ProductOrder;
import test.com.vinicius.orders.repository.ProductOrderRepository;

@Controller
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	private ProductOrderRepository productOrderRepository;
	
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
	 * This method is called by the "Submit" button in the form using POST. 
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
		
		ProductOrder productOrder = requestNewProductDto.toProductOrder();
		productOrderRepository.save(productOrder);
		return "redirect:/home";
	}

}

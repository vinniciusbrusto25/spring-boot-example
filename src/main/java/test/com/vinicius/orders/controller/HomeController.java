package test.com.vinicius.orders.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import test.com.vinicius.orders.enums.ProductOrderStatus;
import test.com.vinicius.orders.model.ProductOrder;
import test.com.vinicius.orders.repository.ProductOrderRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private ProductOrderRepository productOrderRepository;
	
	/**
	 * "Principal" argument provides user details information, like the user name.
	 * "Sort" is used to use the "Order by" clause.
	 * "PageRequest" provides a Pageable object.
	 * 
	 * @param model
	 * @param principal
	 * @return
	 */
	
	@GetMapping
	public String home(Model model, Principal principal) {
		Sort sort = Sort.by("deliveryDate").descending();
		PageRequest pages = PageRequest.of(0, 1, sort);
		
		List<ProductOrder> productsList = productOrderRepository.findByOrderStatus(ProductOrderStatus.DELIVERED, pages);
		model.addAttribute("productList", productsList);
		return "home";
	}

}

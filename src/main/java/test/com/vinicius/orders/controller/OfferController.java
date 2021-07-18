package test.com.vinicius.orders.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OfferController {
	
	@GetMapping
	public String getOffersForm() {
		return "offers/home";
	}

}

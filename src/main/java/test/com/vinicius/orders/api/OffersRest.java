package test.com.vinicius.orders.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.com.vinicius.orders.dto.RequestNewOfferDto;
import test.com.vinicius.orders.model.Offer;
import test.com.vinicius.orders.model.ProductOrder;
import test.com.vinicius.orders.repository.ProductOrderRepository;

@RestController
@RequestMapping("/api/offers")
public class OffersRest {
	
	@Autowired
	private ProductOrderRepository orderRepository;
	
	@PostMapping
	public Offer createOffer(@Valid @RequestBody RequestNewOfferDto request) {
		
		Optional<ProductOrder> orderFound = orderRepository.findById(request.getOrderId());
		if (!orderFound.isPresent()) {
			return null;
		}
		
		ProductOrder order = orderFound.get();
		Offer newOffer = request.toOffer();
		newOffer.setProductOrder(order);
		order.getOffers().add(newOffer);
		orderRepository.save(order);
		
		return newOffer;
	}

}

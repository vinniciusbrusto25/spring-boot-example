package test.com.vinicius.orders.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.com.vinicius.orders.enums.ProductOrderStatus;
import test.com.vinicius.orders.model.ProductOrder;
import test.com.vinicius.orders.repository.ProductOrderRepository;

@RestController
@RequestMapping("/api/orders")
public class OrdersRest {
	
	@Autowired
	private ProductOrderRepository orderRepository;
	
	@GetMapping("waiting")
	public List<ProductOrder> ordersWaiting() {
		Sort sort = Sort.by("id").descending();
		PageRequest pg = PageRequest.of(0, 10, sort);
		
		return orderRepository.findByOrderStatus(ProductOrderStatus.WAITING, pg);
	}

}

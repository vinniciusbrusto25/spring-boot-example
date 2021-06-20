package test.com.vinicius.orders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.com.vinicius.orders.enums.ProductOrderStatus;
import test.com.vinicius.orders.model.ProductOrder;

/*
 * The inheritance of JpaRepository interface provides all
 * of its methods. So, I don't need explicit here I want to
 * use findAll() method, for example.
 *  
 * */

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {

	List<ProductOrder> findByOrderStatus(ProductOrderStatus status);

	
	
}

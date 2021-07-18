package test.com.vinicius.orders.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	@Cacheable("ordersByStatus")
	List<ProductOrder> findByOrderStatus(ProductOrderStatus status, Pageable pages);

	@Query("SELECT p FROM ProductOrder p JOIN p.user u WHERE u.username = :username")
	List<ProductOrder> findAllByUsername(@Param("username") String username);

	@Query("SELECT p FROM ProductOrder p JOIN p.user u WHERE u.username = :username AND p.orderStatus = :status")
	List<ProductOrder> findByOrderStatusAndUser(@Param("status") ProductOrderStatus status, @Param("username") String username);
	
}

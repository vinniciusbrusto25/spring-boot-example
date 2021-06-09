package br.com.example.springmvcapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.example.springmvcapp.model.ProductOrder;

/*
 * The inheritance of JpaRepository interface provides all
 * of its methods. So, I don't need explicit here I want to
 * use findAll() method, for example.
 *  
 * */

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
	
}

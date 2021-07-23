package test.com.vinicius.orders.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Offer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal value;
	private LocalDate deliveryDate;
	private String comment;
	@ManyToOne(fetch = FetchType.LAZY)
	private ProductOrder productOrder;
	
	/*Getters and Setters*/
	
	public ProductOrder getProductOrder() {
		return productOrder;
	}
	
	public void setProductOrder(ProductOrder productOrder) {
		this.productOrder = productOrder;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public BigDecimal getValue() {
		return value;
	}
	
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

}

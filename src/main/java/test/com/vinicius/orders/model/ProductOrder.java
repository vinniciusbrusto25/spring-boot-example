package test.com.vinicius.orders.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import test.com.vinicius.orders.enums.ProductOrderStatus;

@Entity
public class ProductOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String productName;
	private BigDecimal productValue;
	private LocalDate deliveryDate;
	private String productUrl;
	private String imageUrl;
	private String description;

	@Enumerated(EnumType.STRING)
	private ProductOrderStatus orderStatus;

	public BigDecimal getProductValue() {
		return productValue;
	}

	public void setProductValue(BigDecimal productValue) {
		this.productValue = productValue;
	}

	public ProductOrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(ProductOrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getValue() {
		return productValue;
	}

	public void setValue(BigDecimal value) {
		this.productValue = value;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

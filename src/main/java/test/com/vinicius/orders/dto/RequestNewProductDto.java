package test.com.vinicius.orders.dto;

import javax.validation.constraints.NotBlank;

import test.com.vinicius.orders.enums.ProductOrderStatus;
import test.com.vinicius.orders.model.ProductOrder;

/*
 * DTO (Data Transfer Object)
 * 
 * Class used by Spring for mapping the requisition parameters.
 * 
 * Attributes must be named as the same input name in HTML page
 * to make this automatic mapping works. 
 * 
 * */

public class RequestNewProductDto {

	/*@NotBlank means a null or blank validation.*/
	
	@NotBlank
	private String productName;
	
	@NotBlank
	private String productUrl;
	
	@NotBlank
	private String imageUrl;
	private String description;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public ProductOrder toProductOrder() {
		ProductOrder order = new ProductOrder();
		order.setProductName(productName);
		order.setProductUrl(productUrl);
		order.setImageUrl(imageUrl);
		order.setDescription(description);
		order.setOrderStatus(ProductOrderStatus.WAITING);

		return order;
	}

}

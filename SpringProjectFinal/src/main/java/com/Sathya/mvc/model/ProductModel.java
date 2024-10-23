package com.Sathya.mvc.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductModel {
	private Long proId;
	@NotBlank(message = "Field cannot be blank")
	@Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
	private String proName;
	@Min(value = 0, message = "Must be more than 0")
	private Double proPrice;
	@NotBlank(message="Product brand cannot be blank")
	@Size(min = 3, max = 20, message = "Brand cannot be blank")
	private String proBrand;
	@NotBlank(message = "Field cannot be blank")
	private String proDescription;
	private String proCategory;
	private LocalDate createdAt;
	
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Double getProPrice() {
		return proPrice;
	}
	public void setProPrice(Double proPrice) {
		this.proPrice = proPrice;
	}
	public String getProBrand() {
		return proBrand;
	}
	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}
	public String getProDescription() {
		return proDescription;
	}
	public void setProDescription(String proDescription) {
		this.proDescription = proDescription;
	}
	public String getProCategory() {
		return proCategory;
	}
	public void setProCategory(String proCategory) {
		this.proCategory = proCategory;
	}
	public LocalDate getCreatedAt() {
	    return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
	    this.createdAt = createdAt;
	}
	

}

package com.Sathya.mvc.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.Sathya.mvc.entities.ProductEntity;
import com.Sathya.mvc.model.ProductModel;
import com.Sathya.mvc.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public void saveProductData(ProductModel productModel)
	{
	 //Read the data from Model set the data to entity 
	 ProductEntity productEntity = new ProductEntity();
	 productEntity.setProName(productModel.getProName());
	 productEntity.setProPrice(productModel.getProPrice());
	 productEntity.setProCategory(productModel.getProCategory()); 
	 productEntity.setProDescription(productModel.getProDescription()); 
	 productEntity.setProBrand(productModel.getProBrand());
	 
	 productEntity.setCreatedAt(LocalDate.now());
	 productEntity.setCreatedBy(System.getProperty("user.name"));
		 
		 productRepository.save(productEntity);	 
	}
	
	public List<ProductEntity>getAllProducts(){
		List<ProductEntity> products= productRepository.findAll();
		return products;
	}
	public void deleteProductById(Long proId) {
		productRepository.deleteById(proId);
	}

	public ProductEntity getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Update product data in the database
    public void updateProductData(Long id, ProductModel productModel) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productEntity.setProName(productModel.getProName());
        productEntity.setProPrice(productModel.getProPrice());
        productEntity.setProBrand(productModel.getProBrand());
        productEntity.setProDescription(productModel.getProDescription());
        productEntity.setProCategory(productModel.getProCategory());

        productRepository.save(productEntity); // Save updated entity
    }

	}
	
package com.Sathya.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Sathya.mvc.entities.ProductEntity;
import com.Sathya.mvc.model.ProductModel;
import com.Sathya.mvc.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/productform")
	public String getProductForm(Model model) {
		ProductModel productModel = new ProductModel();
		model.addAttribute("productModel", productModel);
		model.addAttribute("page","productform");
		return "index";
	}

	@PostMapping("/saveProduct")
	public String add(@Valid @ModelAttribute("productModel") ProductModel productModel, 
	                  BindingResult bindingResult, 
	                  Model model) {

	    // Check for validation errors
	    if (bindingResult.hasErrors()) {
	        return "add-product"; // Ensure semicolon is present and view name is correct
	    }

	    // Call the service to save product data
	    productService.saveProductData(productModel);

	    // Redirect or return success view
	    return "success";
	}

	
	@GetMapping("/getproduct")
	public String getProduct(Model model) {
		List<ProductEntity>products = productService.getAllProducts();
		model.addAttribute("products", products);
		model.addAttribute("page","getproduct");
		return "index";

	}
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable ("id") Long proId) {
		productService.deleteProductById(proId);
		return "redirect:/getproduct"; 
	}
	
	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable("id")Long proId, Model model) {
		ProductEntity productEntity = productService.getById(proId);
	    ProductModel productModel = new ProductModel();
	    
	    productModel.setProName(productEntity.getProName());
	    productModel.setProPrice(productEntity.getProPrice());
	    productModel.setProBrand(productEntity.getProBrand());
	    productModel.setProDescription(productEntity.getProDescription());
	    productModel.setProCategory(productEntity.getProCategory());
	    productModel.setProId(proId); // Assuming you add this field to ProductModel
	    
	    model.addAttribute("productModel", productModel);
	    return "edit-product";
	}
	@PostMapping("/updateProduct")
	public String updateProduct(@ModelAttribute ProductModel productModel) {
	    productService.updateProductData(productModel.getProId(), productModel);
	    return "redirect:/getproduct"; 
	}
	@GetMapping("/searchProduct")
	public String searchProduct(@RequestParam("proId") Long proId, Model model) {
	    // Get the product by ID
	    ProductEntity productEntity = productService.getById(proId);
	    
	    if (productEntity != null) {
	        // Map ProductEntity to ProductModel (if you're using ProductModel for the view)
	        ProductModel productModel = new ProductModel();
	        productModel.setProId(productEntity.getProId());
	        productModel.setProName(productEntity.getProName());
	        productModel.setProPrice(productEntity.getProPrice());
	        productModel.setProBrand(productEntity.getProBrand());
	        productModel.setProDescription(productEntity.getProDescription());
	        productModel.setProCategory(productEntity.getProCategory());
	        productModel.setCreatedAt(productEntity.getCreatedAt()); // Set createdAt

	        model.addAttribute("product", productModel);  // Pass product data to view
	    } else {
	        model.addAttribute("product", null);  // No product found, pass null
	    }
	    
	    return "product-search";  // Redirect to the product-search page
	}
	  @GetMapping("/about")
	    public String aboutUs(Model model) {
		  model.addAttribute("page","about");
	        return "index";  // Returns the about.html template
	    }
	  @GetMapping("/contact")
	    public String showcontactUs(Model model) {
//		  model.addAttribute("contact");
//		  model.addAttribute("page","contact");
	        return "contact"; 
//		

	    }
	  @GetMapping("/")
	  public String getHomePage()
	  {
		  return "index";
	  }
	}

	

	    
	


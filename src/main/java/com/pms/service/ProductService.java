package com.pms.service;

import java.util.List;

import com.pms.dto.ProductDTO;
import com.pms.exception.ResourceNotFoundException;

public interface ProductService {
	
	public ProductDTO newProduct(ProductDTO pdto);
	public List<ProductDTO> viewAllProduct();
	public ProductDTO updateProduct(int id,ProductDTO pdto)throws ResourceNotFoundException;
	
	public  void deleteProduct(int id)throws ResourceNotFoundException;
	
	public ProductDTO viewProductById(int id) throws ResourceNotFoundException;
	
	public List<ProductDTO> viewAllProductByCategory(String category);
	
	public List<ProductDTO> viewAllProductBySupplier(String supplier);

}

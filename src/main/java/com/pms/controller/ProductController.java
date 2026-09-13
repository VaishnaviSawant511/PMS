package com.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.pms.dto.ProductDTO;
import com.pms.exception.ResourceNotFoundException;
import com.pms.service.ProductService;

@RestController
@RequestMapping
public class ProductController {
	
	@Autowired
	ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService= productService;
	}
	
//	@PostMapping
//	public String addnewproduct(@RequestBody ProductDTO pdto)
//	{
//		ProductDTO dbproductDto=productService.newProduct(pdto);
//		return "saved";
//	}
	
	@PostMapping
	public ResponseEntity<String>addnewproduct(@RequestBody ProductDTO pdto)
	{
		ProductDTO dbproductDto=productService.newProduct(pdto);
		ResponseEntity<String> re=new ResponseEntity<String>("Created", HttpStatus.CREATED);
		return re;
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> displayallproduct()
	{
		List<ProductDTO> alldto=productService.viewAllProduct();
		return ResponseEntity.ok(alldto);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> putMethodName(@PathVariable int id,@RequestBody ProductDTO pdto)throws ResourceNotFoundException{
		ProductDTO savedDto=productService.updateProduct(id, pdto);
		
		return ResponseEntity.ok(savedDto);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id)throws ResourceNotFoundException{
		productService.deleteProduct(id);
		
		return ResponseEntity.ok("product deleted");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> displayproductbyid(@PathVariable int id)throws ResourceNotFoundException{
		ProductDTO pdto=productService.viewProductById(id);
		
		return ResponseEntity.ok(pdto);
	}
	
	@GetMapping("/cat/{cname}")
	public ResponseEntity<List<ProductDTO>> displayproductbycategory(@PathVariable String cname) throws ResourceNotFoundException{
		List<ProductDTO> pdto=productService.viewAllProductByCategory(cname);
		return ResponseEntity.ok(pdto);
	}
	
	@GetMapping("/sup/{sname}")
	public ResponseEntity<List<ProductDTO>> displayproductbysupplier(@PathVariable String sname) throws ResourceNotFoundException{
		List<ProductDTO> pdto=productService.viewAllProductBySupplier(sname);
		return ResponseEntity.ok(pdto);
	}
	
	
	

	

}

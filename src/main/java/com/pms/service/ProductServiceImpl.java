package com.pms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dto.ProductDTO;
import com.pms.entity.Product;
import com.pms.exception.ResourceNotFoundException;
import com.pms.mapper.ProductMapper;
import com.pms.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	public void setProductRepo(ProductRepository productRepo) {
		this.productRepo=productRepo;
	}
	
	@Override
	public ProductDTO newProduct(ProductDTO pdto) {
		
		Product p=ProductMapper.mapProductDTOToProduct(pdto);
		Product savedProduct=productRepo.save(p);
		
		ProductDTO savedProductDto=ProductMapper.mapProductToProductDTO(savedProduct);
		return savedProductDto;
	}
	
	@Override
	public List<ProductDTO> viewAllProduct(){
		List<Product> allPro=productRepo.findAll();
		
		List<ProductDTO> allprodto=allPro.stream()
		.map((product)->ProductMapper.mapProductToProductDTO(product))
		.collect(Collectors.toList());
		
		return allprodto;
		}
	
	@Override
	public ProductDTO updateProduct(int id, ProductDTO pdto)throws ResourceNotFoundException
	{
		ProductDTO productdto=null;
		
		Product p=productRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("the given id "+id+" is not exist"));
		
		p.setSupplier(pdto.getSupplier());
		p.setCost(pdto.getCost());
		
		Product savedProduct=productRepo.save(p);
		
		productdto=ProductMapper.mapProductToProductDTO(savedProduct);
		return pdto;
	}
	
	@Override
	public void deleteProduct(int id) throws ResourceNotFoundException{
		ProductDTO productdto=null;
		
		Product p=productRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("the given id "+id+" is not exist"));
		
		productRepo.deleteById(id);
	}
	
	@Override
	public ProductDTO viewProductById(int id)throws ResourceNotFoundException{
		
		Product p=productRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("the given id "+id+" is not exist"));
		
		return ProductMapper.mapProductToProductDTO(p);
	}
	
	@Override
	public List<ProductDTO> viewAllProductByCategory(String category){
	
		List<Product> allPro=productRepo.findByCategory(category);
List<Product> allPro1=productRepo.findAll();
		
		List<ProductDTO> allprodto=allPro1.stream()
		.map((product)->ProductMapper.mapProductToProductDTO(product))
		.collect(Collectors.toList());
		return allprodto;
	}

	@Override
	public List<ProductDTO> viewAllProductBySupplier(String supplier) {
//		 TODO Auto-generated method stub
		return null;
	}
	
	

}

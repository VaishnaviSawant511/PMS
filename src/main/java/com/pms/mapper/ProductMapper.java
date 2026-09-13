package com.pms.mapper;

import com.pms.dto.ProductDTO;
import com.pms.entity.Product;

public class ProductMapper {
	public static ProductDTO mapProductToProductDTO(Product product)
	{
	ProductDTO pdto=new ProductDTO(product.getPid(),product.getPname(),product.getCost(),product.getCategory(),product.getSupplier());
	return pdto;
}

	
	public static Product mapProductDTOToProduct(ProductDTO pdto)
	{
		Product p=new Product();
		p.setPid(pdto.getPid());
		p.setPname(pdto.getPname());
		p.setCost(pdto.getCost());
		p.setCategory(pdto.getCategory());
		p.setSupplier(pdto.getSupplier());
		
		return p;
	}
}

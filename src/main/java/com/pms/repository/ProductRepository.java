package com.pms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	public List<Product> findByCategory(String cname);
	public List<Product> findBySupplier(String supplier);
}

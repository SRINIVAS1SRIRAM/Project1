package com.srinivas.dao;

import java.util.List;

import com.srinivas.model.Product;

public interface ProductDAO {

	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public List<Product> listProduct();
	public Product getProduct(int productId);
}

package com.srinivas.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.srinivas.dao.ProductDAO;
import com.srinivas.model.Product;



public class ProductDAOTestCase {
	
	static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst() {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.srinivas");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
		
	}
	
	
	@Test
	public void addProductTest() {
		Product product = new Product();
		product.setProductName("Galaxy On8");
		product.setProductDesc("Samsung SmartPhones");
		product.setCategoryId(2);
		product.setStock(10);
		product.setSupplierId(4);
		product.setPrice(12000);
		assertTrue("problem in adding the product", productDAO.addProduct(product));
		
	}
	
	
	@Test
	public void updateProduct() {
		Product product = productDAO.getProduct(45);
		product.setProductName("Car");
		product.setProductDesc("Delete");
		product.setCategoryId(4);
		product.setStock(4);
		product.setSupplierId(6);
		product.setPrice(11000);
		assertTrue("problem in updating the product", productDAO.updateProduct(product));
	}
	
	
	@Test
	public void deleteProduct() {
		Product product = productDAO.getProduct(45);
		assertTrue("problem in deleting the category", productDAO.deleteProduct(product));
	}
	
	
	@Test
	public void listProductTest() {
		
		List<Product> listProduct = productDAO.listProduct();
		assertTrue("problem in listing categories", listProduct.size()>0);
		for(Product product:listProduct) {
			System.out.println("product id:" + product.getProductId());
			System.out.println("product name:" + product.getProductName());
			System.out.println("Product desc:" + product.getProductDesc());
			System.out.println("Product price:" + product.getPrice());
			System.out.println("category id:" + product.getCategoryId());
			System.out.println("Supplier Id:" + product.getSupplierId());
			System.out.println("Stock:" + product.getStock());
			
		}


	}
}

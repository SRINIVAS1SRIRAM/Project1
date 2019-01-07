package com.srinivas.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.srinivas.dao.CartDAO;
import com.srinivas.model.Cart;

public class CartDAOTestCase {
	
	static CartDAO cartDAO;
	
	@BeforeClass
	public static void executeFirst() {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.srinivas");
		context.refresh();
		
		cartDAO = (CartDAO)context.getBean("cartDAO");
	}
	
	@Ignore
	@Test
	public void addCart()
	{
		Cart cart=new Cart();
		cart.setProductId(2);
		cart.setProductName("camera");
		cart.setPrice(20000);
		cart.setQuantity(1);
		cart.setUsername("Tommy");
		cart.setPaymentStatus("NP");
		cart.setSubtotal(1000000);
		assertTrue("Problem in Cart Insertion",cartDAO.addCart(cart));
	}
	
	@Ignore
	@Test
	public void updateCart()
	{
		Cart cart = cartDAO.getCart(57);
		cart.setProductId(2);
		cart.setProductName("Nokia");
		cart.setQuantity(15);
		cart.setUsername("Rock");
		cart.setPaymentStatus("NP");
		cart.setSubtotal(2000);
		cart.setPrice(2000);
		
		assertTrue("Problem in updating Cart", cartDAO.updateCart(cart));
	}
	
	@Ignore
	@Test
	public void deleteCart()
	{
		Cart cart = cartDAO.getCart(57);
		assertTrue("Problem in deleting Cart", cartDAO.deleteCart(cart));
	}
	
	@Test
	public void listCart()
	{
		List<Cart> listcart = cartDAO.listcart("Rock");
		assertTrue("Problem in listing Cart", listcart.size()>0);
		for(Cart cart:listcart)
		{
			System.out.println("cart Id:" + cart.getCartId());
			System.out.println( "product Id" + cart.getProductId());
			System.out.println("product name" +cart.getProductName());
			System.out.println("price" + cart.getPrice());
			System.out.println("Quantity" + cart.getQuantity());
			System.out.println("Subtotal" + cart.getSubtotal());
			System.out.println("Username" + cart.getUsername());
			System.out.println("Payment Status" + cart.getPaymentStatus());
		}
	}

}

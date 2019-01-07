   package com.srinivas.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.srinivas.dao.CartDAO;
import com.srinivas.dao.ProductDAO;
import com.srinivas.model.Cart;
import com.srinivas.model.Product;

@Controller
public class CartController {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@RequestMapping(value="/cart")
	public String showCart(Model m, HttpSession session)
	{
		String user = (String)session.getAttribute("username");
		
		List<Cart> listCartItems = cartDAO.listcart(user);
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("grandtotal", this.calcGrandTotal(listCartItems));
		return "Cart";
	}
	
	@RequestMapping(value="/addcart/{productId}")
	public String AddToCart(@PathVariable("productId")int productId, @RequestParam("quantity")int quantity, Model m, HttpSession session)
	{
		Cart cart=new Cart();
		String user= (String)session.getAttribute("username");
		
		Product product=productDAO.getProduct(productId);
		cart.setProductId(productId);
		cart.setPrice(product.getPrice());
		cart.setProductName(product.getProductName());
		cart.setPaymentStatus("N");
		cart.setQuantity(quantity);
		cart.setUsername(user);
		cart.setSubtotal(product.getPrice() * quantity);
		
		cartDAO.addCart(cart);
		
		System.out.println("cart Added");
		
		List<Cart> listCartItems = cartDAO.listcart(user);
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("grandtotal", this.calcGrandTotal(listCartItems));
		return "Cart";
	}
	
	public int calcGrandTotal(List<Cart> listCartItems)
	{
		int grandtotal=0;
		int count=0;
		while(count< listCartItems.size())
		{
			Cart cart=listCartItems.get(count);
			grandtotal=grandtotal+(cart.getQuantity()*cart.getPrice());
			count++;
		}
		return grandtotal;
	}
	
	@RequestMapping(value="/updateCart/{cartId}")
	public String updateCart(@PathVariable("cartId")int cartId, @RequestParam("quantity")int quantity, Model m, HttpSession session)
	{
		String user=(String)session.getAttribute("username");
		Cart cart = cartDAO.getCart(cartId);
		cart.setQuantity(quantity);
		cartDAO.updateCart(cart);
		
		List<Cart> listCartItems = cartDAO.listcart(user);
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("grandtotal", this.calcGrandTotal(listCartItems));
		return "Cart";
	}
	
	@RequestMapping(value="/deleteCart/{cartId}")
	public String deleteCart(@PathVariable("cartId")int cartId, Model m, HttpSession session)
	{
		String user=(String)session.getAttribute("username");
		Cart cart = cartDAO.getCart(cartId);
		cartDAO.deleteCart(cart);
		
		List<Cart> listCartItems = cartDAO.listcart(user);
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("grandtotal", this.calcGrandTotal(listCartItems));
		return "Cart";
	}
	
	@RequestMapping(value="/checkout")
	public String checkout(Model m, HttpSession session)
	{
		String user=(String)session.getAttribute("username");
		
		List<Cart> listCartItems = cartDAO.listcart(user);
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("grandtotal", this.calcGrandTotal(listCartItems));
		return "OrderConfirm";
	}
}

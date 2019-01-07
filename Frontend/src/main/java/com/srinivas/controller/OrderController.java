package com.srinivas.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.srinivas.dao.CartDAO;
import com.srinivas.dao.OrderDetailDAO;
import com.srinivas.dao.UserDetailDAO;
import com.srinivas.model.Cart;
import com.srinivas.model.OrderDetail;
import com.srinivas.model.UserDetail;

@ComponentScan("com.srinivas")
@Controller
public class OrderController {
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderDetailDAO orderDAO;
	
	@Autowired
	UserDetailDAO userDAO;
	
	@RequestMapping("/payment")
	public String paymentProcess(@RequestParam("pmode")String pmode, Model m, HttpSession session)
	{
		String user= (String)session.getAttribute("username");
		
		List<Cart> listCartItems = cartDAO.listcart(user);
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setUsername(user);
		orderDetail.setOrderDate(new Date());
		orderDetail.setTranType(pmode);
		orderDetail.setTotalAmount(this.calcGrandTotalPrice(listCartItems));
		
		if(orderDAO.updateCartItemStatus(user))
		{
			orderDAO.paymentProcess(orderDetail);
			m.addAttribute("CartItems", listCartItems);
			m.addAttribute("paymentDetail", orderDetail);
			UserDetail userDetail = userDAO.getUserDetail(user);
			m.addAttribute("userdetail", userDetail);
		}
		
		m.addAttribute("cartItems", listCartItems);
		m.addAttribute("PaymentDetail", orderDetail);
		
		return "Receipt";
	}
	
	public int calcGrandTotalPrice(List<Cart> listCartItems)
	{
		int grandtotal=0;
		int count=0;
		while(count<listCartItems.size())
		{
			Cart cart = listCartItems.get(count);
			grandtotal=grandtotal+(cart.getQuantity()*cart.getPrice());
			count++;
		}
		return grandtotal;
	}

}

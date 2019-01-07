package com.srinivas.dao;

import java.util.List;

import com.srinivas.model.Cart;

public interface CartDAO {
	public boolean addCart(Cart cart);
    public Cart getCart(int cartId);
	public boolean deleteCart(Cart cart);
	public boolean updateCart(Cart cart);
	public List<Cart> listcart(String username);
	
}

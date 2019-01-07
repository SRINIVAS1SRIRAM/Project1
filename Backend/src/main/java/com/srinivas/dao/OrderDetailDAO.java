package com.srinivas.dao;

import com.srinivas.model.OrderDetail;

public interface OrderDetailDAO {
	public boolean updateCartItemStatus(String username);

	public boolean paymentProcess(OrderDetail orderDetail);


}

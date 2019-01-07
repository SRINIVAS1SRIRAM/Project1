package com.srinivas.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.srinivas.dao.UserDetailDAO;
import com.srinivas.model.UserDetail;

public class UserDetailDAOTestCase {
	
	static UserDetailDAO userDAO;

	@BeforeClass
	public static void executeFirst() {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.srinivas");
		context.refresh();
		userDAO = (UserDetailDAO) context.getBean("userDAO");

	}

	@Ignore
	@Test
	public void addUserDetailTest() {
		UserDetail user = new UserDetail();
		user.setUsername("Tommy");
		user.setPassword("12345");
		user.setEnabled(true);
		user.setRole("USER");
		user.setCustomerName("Tommy Oliver");
		user.setAddress("Dino thunder");
		user.setEmailId("tommy1@ranger.com");
		user.setMobileNumber("9999999999");
		assertTrue("problem in adding the userdetails", userDAO.addUserDetail(user));
		
	}
	
	@Ignore
	@Test
	public void updateSupplierTest() {
		UserDetail user = userDAO.getUserDetail("tommy");
		user.setPassword("12345");
		user.setEnabled(true);
		user.setRole("USER");
		assertTrue("problem in adding the userdetails", userDAO.updateUserDetail(user));
	}
	
	@Ignore
	@Test
	public void deleteSupplierTest() {
		UserDetail user = userDAO.getUserDetail("tony");
		assertTrue("problem in deleting the Userdetails", userDAO.deleteUserDetail(user));
	}
	

	@Test
	public void listSupplierTest() {
		
		List<UserDetail> listUserDetail = userDAO.listUserDetail();
		assertTrue("problem in listing UserDetails", listUserDetail.size()>0);
		for(UserDetail user:listUserDetail) {
			System.out.println("customer name:" + user.getCustomerName());
			System.out.println("customer password:" + user.getPassword());
			System.out.println("customer role:" + user.getRole());
			
		}
	}
}

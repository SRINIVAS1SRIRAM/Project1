package com.srinivas.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.srinivas.dao.UserDetailDAO;
import com.srinivas.model.UserDetail;

@Controller
public class UserController {
	
	@Autowired
	UserDetailDAO userDetailDAO;
	
	@RequestMapping(value="/Login_Success")
	public String loginSuccess(HttpSession session, Model m)
	{
		String page="";
		boolean loggedIn=false;
		
		SecurityContext sContext=SecurityContextHolder.getContext();
		Authentication authentication=sContext.getAuthentication();
		
		String username=authentication.getName();
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			
			if(role.getAuthority().equals("ADMIN"))
			{
				loggedIn=true;
				page="AdminHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				loggedIn=true;
				page="UserHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
		}
		
		return page;
	}
	
	@RequestMapping(value="/addregister", method=RequestMethod.POST)
	public String addUserDetail(@RequestParam("name")String customerName,@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("Emailid")String emailId,@RequestParam("Mobileno")String mobileNumber,@RequestParam("Address")String address)
	{
		UserDetail userDetail = new UserDetail();
		userDetail.setAddress(address);
		userDetail.setCustomerName(customerName);
		userDetail.setEmailId(emailId);
		userDetail.setEnabled(true);
		userDetail.setMobileNumber(mobileNumber);
		userDetail.setPassword(password);
		userDetail.setRole("USER");
		userDetail.setUsername(username);
		
		userDetailDAO.addUserDetail(userDetail);		
		
		return "Login";
	}

}

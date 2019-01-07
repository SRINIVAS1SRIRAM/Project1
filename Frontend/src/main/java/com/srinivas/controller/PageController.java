package com.srinivas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping(value="/userhome")
	public String showUserHome()
	{
		return "UserHome" ;
	}

	@RequestMapping(value="/adminhome")
	public String showAdminHome()
	{
		return "AdminHome" ;
	}
	
	@RequestMapping(value="/header")
	public String showHeader()
	{
		return "Header" ;
	}
	
	@RequestMapping(value="/home")
	public String showHome()
	{
		return "Home";
	}
	
	@RequestMapping(value="/login")
	public String username()
	{
		return "Login";		
	}
	
	@RequestMapping(value="/register")
	public String showRegister()
	{
		return "Register";		
	}
	
	@RequestMapping(value="/aboutus")
	public String showAboutUs()
	{
		return "Aboutus";
	}
	
	
	
	
	
	
}

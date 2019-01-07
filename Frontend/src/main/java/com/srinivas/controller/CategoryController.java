package com.srinivas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.srinivas.dao.CategoryDAO;
import com.srinivas.model.Category;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="/category")
	public String showCategory(Model m)
	{
		List<Category> listcategories = categoryDAO.listCategories();
		m.addAttribute("listca", listcategories);
		return "Category";
	}
	
	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	public String addCategoryDetail(@RequestParam("categoryName")String categoryName, @RequestParam("categoryDesc")String categoryDesc, Model m)
	{
		Category category=new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.add(category);
		
		List<Category> listcategories=categoryDAO.listCategories();
		m.addAttribute("listca", listcategories);
		
		return "Category";
	}
	
	@RequestMapping(value="/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryId, Model m)
	{
		Category category = categoryDAO.getCategory(categoryId);
		categoryDAO.delete(category);
		
		List<Category> listcategories = categoryDAO.listCategories();
		m.addAttribute("listca", listcategories);
		return "Category";
	}
	
	@RequestMapping(value="/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")int categoryId, Model m)
	{
		Category category = categoryDAO.getCategory(categoryId);
		m.addAttribute("category", category);
		return "UpdateCategory";
	}

	@RequestMapping(value="/updateCategory", method=RequestMethod.POST)
	public String updateCategory(@RequestParam("categoryId")int categoryId, @RequestParam("categoryName")String categoryName, @RequestParam("categoryDesc")String categoryDesc,Model m)
	{
		Category category = categoryDAO.getCategory(categoryId);
		
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.update(category);
		
		List<Category> listcategories=categoryDAO.listCategories();
		m.addAttribute("listca", listcategories);
		return "Category";
	}
}

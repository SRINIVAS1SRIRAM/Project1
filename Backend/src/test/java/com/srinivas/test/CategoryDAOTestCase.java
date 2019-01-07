package com.srinivas.test;




import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.srinivas.dao.CategoryDAO;
import com.srinivas.model.Category;

public class CategoryDAOTestCase {
	
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst() {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.srinivas");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}
	
	@Test
	public void addCategoryTest() {
		Category category = new Category();
		category.setCategoryName("Mobiles");
		category.setCategoryDesc("From Basic Phones to SmartPhones");
		assertTrue("problem in adding the category", categoryDAO.add(category));
		
	}
	
	
	@Test
	public void updateCategory() {
		Category category=categoryDAO.getCategory(1);
		category.setCategoryName("Childrens");
		category.setCategoryDesc("Kid's Toys, Clothing and many more!");
		assertTrue("problem in updating the category", categoryDAO.update(category));
	}
	
	
	@Test
	public void deleteCategory() {
		Category category = categoryDAO.getCategory(2);
		assertTrue("problem in deleting the category", categoryDAO.delete(category));
	}
	
	
	@Test
	public void listCategoriesTestt() {
		
		List<Category> listCategories = categoryDAO.listCategories();
		assertTrue("problem in listing categories", listCategories.size()>0);
		for(Category category:listCategories) {
			System.out.println("category id:" + category.getCategoryId());
			System.out.println("category name:" + category.getCategoryName());
			System.out.println("category desc:" + category.getCategoryDesc());
			
		}
	}

}

package com.srinivas.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.srinivas.dao.CategoryDAO;
import com.srinivas.dao.ProductDAO;
import com.srinivas.dao.SupplierDAO;
import com.srinivas.model.Category;
import com.srinivas.model.Product;
import com.srinivas.model.Supplier;

@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping(value="/product")
	public String showProductPage(Model m)
	{
		List<Product> listProducts=productDAO.listProduct();
		m.addAttribute("productlist", listProducts);
		
		Product product=new Product();
		m.addAttribute(product);
		
		m.addAttribute("categoryList", this.getCategoryList(categoryDAO.listCategories()));
		m.addAttribute("supplierList", this.getSupplierList(supplierDAO.listSupplier()));
		
		return "Product";
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@ModelAttribute("product")Product product, @PathVariable("productId")int productId, Model m)
	{
		 product = productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		
		List<Product> listProducts=productDAO.listProduct();
		m.addAttribute("productlist", listProducts);
		
		m.addAttribute("categoryList", this.getCategoryList(categoryDAO.listCategories()));
		m.addAttribute("supplierList", this.getSupplierList(supplierDAO.listSupplier()));
		
		return "Product";
	}
	
	@RequestMapping(value="/editProduct/{productId}")
	public String editProduct(@ModelAttribute("product")Product product, @PathVariable("productId")int productId, Model m)
	{
		 product = productDAO.getProduct(productId);
		 m.addAttribute(product);
		
		return "UpdateProduct";
	}
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product,@RequestParam("pimage")MultipartFile prodImage,Model m)
	{
		//Displaying Content
				System.out.println("Product Name:"+product.getProductName());
				System.out.println("Product Desc:"+product.getProductDesc());
				System.out.println("Category ID:"+product.getCategoryId());
				System.out.println("Price:"+product.getPrice());
				System.out.println("Stock:"+product.getStock());
				productDAO.addProduct(product);
				
				//Start-Image Insertion
				
				
				String path="F:\\Project1\\Frontend\\src\\main\\webapp\\resources\\images\\";
				
				path=path+String.valueOf(product.getProductId())+".jpg";
				
				File imageFile=new File(path);
				
				if(!prodImage.isEmpty())
				{
					try
					{
						byte[] buffer=prodImage.getBytes();
						FileOutputStream fos=new FileOutputStream(imageFile);
						BufferedOutputStream bs=new BufferedOutputStream(fos);
						bs.write(buffer);
						bs.close();
					}
					catch(Exception e)
					{
						System.out.println(e);
						m.addAttribute("Error","Exception Occured during the Image Uploading"+e);	
					}
				}
				else
				{
					System.out.println("error occured");
					m.addAttribute("Error","Error Occured during the Image Uploading");
				}
				//End-Image Insertion
				Product product1=new Product();
				m.addAttribute(product1);
				
				List<Product> listProducts=productDAO.listProduct();
				m.addAttribute("productlist", listProducts);
				
				m.addAttribute("categoryList", this.getCategoryList(categoryDAO.listCategories()));
				m.addAttribute("supplierList", this.getSupplierList(supplierDAO.listSupplier()));
				
				return "Product";
	}
	
	@RequestMapping(value="/updateProduct", method=RequestMethod.POST)
	public String updateCategory(@ModelAttribute("productmodelupdate")Product product,Model m)
	{
		productDAO.updateProduct(product);
		
		Product product1=new Product();
		m.addAttribute(product1);
		
		List<Product> listProducts=productDAO.listProduct();
		m.addAttribute("productlist",listProducts);
		m.addAttribute("categoryList", this.getCategoryList(categoryDAO.listCategories()));
		m.addAttribute("supplierList", this.getSupplierList(supplierDAO.listSupplier()));
		
		return "Product";
	}
	
	@RequestMapping(value="/displayProduct")
	public String displayProduct(Model m)
	{
		List<Product> listProducts=productDAO.listProduct();
		m.addAttribute("productlist", listProducts);
		return "DisplayProduct";
	}
	
	@RequestMapping(value="/productDetails/{productId}")
	public String productDetails(@PathVariable("productId")int productId,Model m)
	{
		System.out.println(productId);
		Product product=productDAO.getProduct(productId);
		int val=product.getPrice();
		System.out.println(val);
		
		m.addAttribute("productlist", product);
		String categoryName=categoryDAO.getCategory(product.getCategoryId()).getCategoryName();
		String supplierName=supplierDAO.getSupplier(product.getSupplierId()).getSupplierName();
		
		m.addAttribute("CategoryName", categoryName);
		m.addAttribute("SupplierName", supplierName);
		
		return "TotalProduct";
	}
	
	public LinkedHashMap<Integer,String>getCategoryList(List<Category> listCategories)
	{
		LinkedHashMap<Integer,String> listcategories=new LinkedHashMap<Integer,String>();
		for(Category category:listCategories)
		{
			listcategories.put(category.getCategoryId(),category.getCategoryName());
		}
		return listcategories;
	}
	
	public LinkedHashMap<Integer,String>getSupplierList(List<Supplier> listSupplier)
	{
		LinkedHashMap<Integer,String> listSuppliers=new LinkedHashMap<>();
		for(Supplier supplier:listSupplier)
		{
			listSuppliers.put(supplier.getSupplierId(), supplier.getSupplierName());
		}
		return listSuppliers;
	}
	
	
}

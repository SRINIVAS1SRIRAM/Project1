package com.srinivas.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.srinivas.dao.SupplierDAO;
import com.srinivas.model.Supplier;

public class SupplierDAOTestCase {

	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executeFirst() {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.srinivas");
		context.refresh();
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

	}
	
	@Ignore
	@Test
	public void addSupplierTest() {
		Supplier supplier = new Supplier();
		supplier.setSupplierName("Xaomi");
		supplier.setSupplierAddress("INDIA");
		assertTrue("problem in adding the supplier", supplierDAO.addSupplier(supplier));
		
	}
	
	@Ignore
	@Test
	public void updateSupplierTest() {
		Supplier supplier=supplierDAO.getSupplier(1);
		supplier.setSupplierName("Childrens");
		supplier.setSupplierAddress("Kid's Toys, Clothing and many more!");
		assertTrue("problem in updating the supplier", supplierDAO.updateSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void deleteSupplierTest() {
		Supplier supplier = supplierDAO.getSupplier(2);
		assertTrue("problem in deleting the supplier", supplierDAO.deleteSupplier(supplier));
	}
	
	
	@Test
	public void listSupplierTest() {
		
		List<Supplier> listSupplier = supplierDAO.listSupplier();
		assertTrue("problem in listing supplier", listSupplier.size()>0);
		for(Supplier supplier:listSupplier) {
			System.out.println("supplier id:" + supplier.getSupplierId());
			System.out.println("supplier name:" + supplier.getSupplierName());
			System.out.println("supplier address:" + supplier.getSupplierAddress());
			
		}
	}
}

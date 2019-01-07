package com.srinivas.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.srinivas.model.Cart;
import com.srinivas.model.Category;
import com.srinivas.model.OrderDetail;
import com.srinivas.model.Product;
import com.srinivas.model.Supplier;
import com.srinivas.model.UserDetail;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.srinivas")
public class DBConfig {

	@Bean(name="dataSource")
	public DataSource getH2DataSource() {
		
		DriverManagerDataSource dataSource =new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/testProject");
		dataSource.setUsername("Srinivas");
		dataSource.setPassword("srinivas");
		System.out.println("DataSource Object is Created");
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory() {
		
		Properties hibernateProp = new Properties();
		
		hibernateProp.put("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder factory = new LocalSessionFactoryBuilder(getH2DataSource());
		factory.addProperties(hibernateProp);
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(Supplier.class);
		factory.addAnnotatedClass(UserDetail.class);
		factory.addAnnotatedClass(Cart.class);
		factory.addAnnotatedClass(OrderDetail.class);
		
		System.out.println("SessionFactory Object is Created");
		
		return factory.buildSessionFactory();
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		
		System.out.println("TransactionManager Object is Created");
		return new HibernateTransactionManager(sessionFactory);
	}
}

package com.mvc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mvc.entity.Book;
import com.mvc.entity.Form;


@Configuration
@ComponentScan("com.mvc")
@EnableTransactionManagement
public class ORMConfig {
	
	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource conf=new DriverManagerDataSource();
		conf.setDriverClassName("com.mysql.cj.jdbc.Driver");
		conf.setUrl("jdbc:mysql://localhost:3306/springmvc");
		conf.setUsername("root");
		conf.setPassword("1234");
		return conf;
	}
	
	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean()
	{
		LocalSessionFactoryBean bean=new LocalSessionFactoryBean();
		bean.setDataSource(getDataSource());
		Properties pro=new Properties();
		
		pro.put("hibernate.hbm2ddl.auto", "update");
		pro.put("hibernate.show_sql", true);
		pro.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
		pro.put("hibernate.enable_lazy_load_no_trans", "true");
		
		bean.setHibernateProperties(pro);
		bean.setAnnotatedClasses(Form.class, Book.class);
		return bean;
	}
	
	@Bean
	public HibernateTemplate getHibernateTemplate()
	{
		HibernateTemplate hibernateTemp=new HibernateTemplate();
		hibernateTemp.setSessionFactory(getLocalSessionFactoryBean().getObject());
		return hibernateTemp;
	}
	
	@Bean
	public HibernateTransactionManager getTransaction()
	{
		HibernateTransactionManager manager=new HibernateTransactionManager();
		manager.setSessionFactory(getLocalSessionFactoryBean().getObject());
		return manager;
	}
	

}

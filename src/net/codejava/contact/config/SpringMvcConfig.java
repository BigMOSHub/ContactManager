package net.codejava.contact.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import net.codejava.contact.dao.ContactDAO;
import net.codejava.contact.dao.ContactDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "net.codejava.contact")
public class SpringMvcConfig implements WebMvcConfigurer {

	@Bean
	public DataSource getDataSource() {
		System.out.println("SrpingMVC linea 24 inicio - getDataSource");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		System.out.println("SpringMVC linea 31 fin - getDataSource");

		return dataSource;
	}

//	@Bean
//	public DataSource getDataSource() {
//		System.out.println("SrpingMVC linea 24 inicio - getDataSource");
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://mosserverazure.mysql.database.azure.com:3306/contactdb");
//		dataSource.setUsername("myadmin@mosserverazure");
//		dataSource.setPassword("8gxdGt59HQPpmf@");
//		System.out.println("SpringMVC linea 31 fin - getDataSource");
//
//		return dataSource;
//	}

	
	
	@Bean
	public ViewResolver getViewResolver() {
		System.out.println("SpringMVC linea 33 inicio - getViewResolver");
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		System.out.println("SpringMVC linea 38 fin - getViewResolver");
		
		return resolver;
	}
	
	@Bean
	public ContactDAO getContactDAO() {
		System.out.println("SpringMVC linea unica 48 - getContactDAO");
		return new ContactDAOImpl(getDataSource());
	}
	
}

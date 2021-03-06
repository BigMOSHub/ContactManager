package net.codejava.contact.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("WebAppinitializer linea 16 - inicio - onStartup Servlet");
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext(); 
		appContext.register(SpringMvcConfig.class);
		ServletRegistration.Dynamic dispatcher = 
				servletContext.addServlet("SpringDispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		System.out.println("WebAppinitializer linea 23 - fin - onStartup Servlet");

	}

}

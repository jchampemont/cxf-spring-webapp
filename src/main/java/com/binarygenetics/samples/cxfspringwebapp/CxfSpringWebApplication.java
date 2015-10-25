package com.binarygenetics.samples.cxfspringwebapp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * CXF & Spring web application
 */
public class CxfSpringWebApplication implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		ServletRegistration.Dynamic servlet;

		rootContext.register(ApplicationConfiguration.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));

		servlet = servletContext.addServlet("CXFServlet", CXFServlet.class);
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/rest/*");
	}

}

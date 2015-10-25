package com.binarygenetics.samples.cxfspringwebapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.ResourceProvider;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.binarygenetics.samples.cxfspringwebapp.api.SampleTimeServices;
import com.binarygenetics.samples.cxfspringwebapp.jaxrs.JsonProvider;
import com.binarygenetics.samples.cxfspringwebapp.jaxrs.SampleExceptionMapper;

/**
 * Application configuration
 */
@Configuration
@ComponentScan("com.binarygenetics.samples.cxfspringwebapp")
@ImportResource({ "classpath:META-INF/cxf/cxf.xml", "classpath:META-INF/cxf/cxf-servlet.xml" })
public class ApplicationConfiguration {

	@Inject
	private ApplicationContext applicationContext;

	@Inject
	private JsonProvider jsonProvider;

	@Inject
	private SampleExceptionMapper sampleExceptionMapper;

	@Inject
	private SampleTimeServices timeServices;

	@Bean
	public Server jaxRsServer() {
		JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
		List<ResourceProvider> resourceProviders = new ArrayList<>();

		resourceProviders.add(new SingletonResourceProvider(timeServices));

		factory.setBus(applicationContext.getBean(SpringBus.class));
		factory.setProviders(Arrays.asList(jsonProvider, sampleExceptionMapper));
		factory.setResourceProviders(resourceProviders);

		return factory.create();
	}

}

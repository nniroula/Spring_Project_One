package com.i28minutes.learnspringframework.example.project2;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// configuration file set up
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.i28minutes.learnspringframework.examples.a1.DependencyInjectionLauncherApplication;


@Configuration
@ComponentScan
public class BusinessCalculationService{
	private DataServiceInterface dataService;
	
	// method to find max value from data service layer
	public int findMax() {
		// use functional programming
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}
	
	// constructor dependency injection
	public BusinessCalculationService(DataServiceInterface newDataService) {
		super();
		this.dataService = newDataService;
	}
	
	public static void main(String[] args) {
		System.out.println("Multiple database services access...");
		
		// create application context to access components
		try(var context = new AnnotationConfigApplicationContext(BusinessCalculationService.class)){
			//context.getBean(MongoDBDataService.class);
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
		}
	}
}
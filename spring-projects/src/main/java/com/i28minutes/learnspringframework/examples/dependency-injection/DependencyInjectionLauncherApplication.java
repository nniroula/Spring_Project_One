package com.i28minutes.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// configuration file set up
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;



// your business class, has 2 dependencies on thier own files - Dependency1 and Dependency2

@Component
class YourBusinessClass{
	// add dependency injection using @Autowired
	
	/* 1. Field dependency injection is achieved using @Autowired with fields(or variables)*/
	//@Autowired
	Dependency1 dependency1;
	
	//@Autowired
	Dependency2 dependency2;
	
	/* 2. setters dependency injection by using @Autowired with setters */
	
	// Setters -> to generate setters in eclipse - right click on source - generate getters and setters - select setters
	
	//@Autowired
	public void setDependency1(Dependency1 dependency1) {
		System.out.println("Setter Dependency Injection for - setDependency 1");
		this.dependency1 = dependency1;
	}

	//@Autowired
	public void setDependency2(Dependency2 dependency2) {
		System.out.println("Setter Dependency Injection for - setDependency 2");
		this.dependency2 = dependency2;
	}
	
	/* 3. constructor dependency injection */
	//@Autowired
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor based Dependency Injection");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}
	
	
	// toString method to check if dependency injection is working
	public String toString() {
		return "Using " + dependency1 + " and " + dependency2;
	}
	
}


@Component
class Dependency1{
	
}


@Component
class Dependency2{
	
}



@Configuration
@ComponentScan
public class DependencyInjectionLauncherApplication {
	public static void main(String[] args) {
		// create Spring Context
//		try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class))
		// context is now present in public class, i.e, App03GamingSpringBeans
		try(var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplication.class))
		{
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			// for dependency injection
			System.out.println();
			System.out.println("Dependency Injection...");
			// context.getBean(YourBusinessClass.class);
			System.out.println(context.getBean(YourBusinessClass.class));
			
		}
		

	}

}

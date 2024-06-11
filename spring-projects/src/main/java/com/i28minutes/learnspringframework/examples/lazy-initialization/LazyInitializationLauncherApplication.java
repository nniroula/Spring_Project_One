package com.i28minutes.learnspringframework.examples.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// configuration file set up
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// create 2 components
@Component
class ClassA{
	
}

@Component
@Lazy
class ClassB{
	private ClassA classA; // variable to hold some data value
	
	public ClassB(ClassA classA) {
		// your business logic
		System.out.println("Some initialization logic");
		this.classA = classA;
	}
	
	// method to run after @Lazy is used
	public void doSomething() {
		System.out.println("After @Lazy is used on ClassB, it is initialzed only when ClassB is used in context");
	}
	
	
}


@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {


	public static void main(String[] args) {
		// create Spring Context
		try(var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class))
		{
			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			// use classB after using @Lazy annotation
			System.out.println("Initialization context is completed");
			// get classB bean
			context.getBean(ClassB.class).doSomething();
		}
		
	}

}

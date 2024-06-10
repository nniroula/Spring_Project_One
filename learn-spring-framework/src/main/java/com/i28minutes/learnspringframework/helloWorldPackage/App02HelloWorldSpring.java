package com.i28minutes.learnspringframework.helloWorldPackage;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.i28minutes.learnspringframework.game.GameRunner;
import com.i28minutes.learnspringframework.game.MarioGame;
import com.i28minutes.learnspringframework.game.PacMan;
import com.i28minutes.learnspringframework.game.SuperContraGame;

/*
 * In this class, 
 * 		Tightly coupled java code
 * 			create a game runner class instance
 * 				Game classes: Mario, SuperContra, Pacman etc
 */

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		
		//1 launch Spring context, use your configuration class bytecode as argument
		try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) // creates application context
		{

			//2 configure things you want Spring to manage
			// @Configuration with a class
			// method = @Bean
			
			// use the context to get object
			// retrieve Beans managed by Spring
			context.getBean("name");   // name is method name with @Bean in HelloWorldConfiguration file
			System.out.println(context.getBean("name"));  // name in quote is a method name
			
			// retrieve second bean value
			System.out.println(context.getBean("age"));
			
			// retrieve bean as record
			System.out.println(context.getBean("person"));
			
			// retrieve address record
			System.out.println(context.getBean("address"));
			
			// get customized Bean Name
			System.out.println(context.getBean("customizedBeanName"));
			
			// get bean using ClassName.class. No two beans with same class type should exist
			//System.out.println(context.getBean(Address.class));
			
			// interconnected beans
			System.out.println(context.getBean("person2MethodCall"));
			
			
			System.out.println("Dependency Injection concept starts...");
			System.out.println(context.getBean("person3WithParameters"));
			
			// dependency of bean
			/*
			 * If multiple beans have same data type, make one of them @Primary in config file
			 */
			System.out.println(context.getBean(Address.class));
			System.out.println(context.getBean(Person.class));
			
			// list all Spring beans
			context.getBeanDefinitionNames(); // this returns an array - use functional programming loop over array
			
			System.out.println();
			System.out.println("All Spring Beans are ...................");
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println); // :: is called method reference
			
			// Qualifier
			System.out.println();
			System.out.println("Using @Qualifier to avoid runtime error due to multiple candidate beans ...");
			System.out.println(context.getBean("Person5Qualifier"));
		
		}
		
	}

}

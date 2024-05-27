package com.i28minutes.learnspringframework;

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
		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class); // creates application context
		
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
		System.out.println(context.getBean(Address.class));
	
	}

}

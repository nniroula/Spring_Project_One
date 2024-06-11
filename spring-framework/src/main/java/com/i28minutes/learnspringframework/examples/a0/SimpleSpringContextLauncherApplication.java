package com.i28minutes.learnspringframework.examples.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// configuration file set up
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class SimpleSpringContextLauncherApplication {


	public static void main(String[] args) {
		// create Spring Context
//		try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class))
		// context is now present in public class, i.e, App03GamingSpringBeans
		try(var context = new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class))
		{
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
		
	}

}

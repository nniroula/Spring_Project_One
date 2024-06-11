package com.i28minutes.learnspringframework.examples.h1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// configuration file set up
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.i28minutes.learnspringframework.game.GameRunner;


public class XMLConfigurationContextLauncherApplication {
	public static void main(String[] args) {
		// this is for java configuration, you need xml configuration here
//		try(var context = new AnnotationConfigApplicationContext(XMLConfigurationContextLauncherApplication.class))
//		{
//			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
//		}
		
		
		// xml config
		try(var context = new ClassPathXmlApplicationContext("contextConfiguration.xml"))
		{
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			// get value for name from xml file
			System.out.println(context.getBean("name")); // name is id in xml file
			
			System.out.println(context.getBean("age")); // age is id in xml file
			
			System.out.println(context.getBean("game"));
			context.getBean(GameRunner.class).run();
		}
	}

}

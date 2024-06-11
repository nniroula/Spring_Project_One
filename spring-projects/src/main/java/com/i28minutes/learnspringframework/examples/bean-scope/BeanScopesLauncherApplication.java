package com.i28minutes.learnspringframework.examples.e1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// configuration file set up
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// create more beans

@Component
class NormalClass{
	
}

@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass{
	
}


@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {


	public static void main(String[] args) {
		// create Spring Context
		try(var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class))
		{
			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			// Normal class, you will always get same instance of the normal class - singleton 
			System.out.println(context.getBean(NormalClass.class)); // twice
			System.out.println(context.getBean(NormalClass.class));
			
			// for prototype class, will give different bean for each instance
			System.out.println(context.getBean(PrototypeClass.class)); // three times
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
		}
		
	}

}

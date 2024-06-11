package com.i28minutes.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// configuration file set up
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
class SomeClass{
	private SomeDependency someDep;
	
	// constructor
	public SomeClass(SomeDependency newDependency){
		super();
		this.someDep = newDependency;
		System.out.println("All Dependencies are ready");
	}
	
	// as soon as dependencies are wired, do some initialization - to do use @PostConstruct
	@PostConstruct
	public void initialize() {
		someDep.getReady();
	}
	
	@PreDestroy
	public void cleanup() {
		System.out.println("Clean Up");
	}
}

@Component
class SomeDependency{
	public void getReady() {
		System.out.println("Some logic using dependency");
	}
}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncherApplication {
	public static void main(String[] args) {
		// create Spring Context
//		try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class))
		// context is now present in public class, i.e, App03GamingSpringBeans
		try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class))
		{
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
		
	}

}

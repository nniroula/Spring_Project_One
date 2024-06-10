package com.i28minutes.learnspringframework.helloWorldPackage;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


// record auto creates getters, setters, constructors etc
//record Person (String name, int age) {};
record Person (String name, int age, Address address) {};
record Address(String firstLine, String city) { };
//record SecondPerson(String name, int age, Address address) { };


//this is SPring configuration class
@Configuration
public class HelloWorldConfiguration {
	
	// method to create Spring bean. This bean will be managed by Spring Context
	
	@Bean
	public String name() {
		return "Nabin from @Bean name method";
	}
	
	// Go back to HelloWorldSpring java class
	
	// second bean
	@Bean
	public int age() {
		return 16;
	}
	
	// use record
	@Bean
	@Primary
	public Person person() {
		//		var person = new Person("Steve", 24);
		//		// person.age(); -> this method is available here as getter
		//		return person;
//		return new Person("Steve", 24);
		//Address addr = new Address("Bethany Place", "Aurora, Colorado");
		return new Person("Steve", 24, new Address("Bethany Place", "Aurora, Colorado"));
	}
	
	/*
	 * When multiple beans have same data type(ex. Address), make one of them @Primary to invoke them all
	 */
	@Bean
	@Primary
	public Address address() {
		return new Address("100 Main Street", "Aurora");
	}
	
	
	// this bean name will be customized
	@Bean(name="customizedBeanName")  // with this method(bean) name becomes cusotmizedBeanName
	public Address customizedBeanName() {
		return new Address("Customized Bean address", "customized BEAN");
	}
	
	
	// interconnected beans
	
	@Bean
	public Person person2MethodCall() {
//		return new Person(name(), age()); // existing name and age
		return new Person(name(), age(), address()); // existing name and age
	}
	
	
	// constructor
//	public SecondPerson SecondPerson(String name2, int age, Address addr) {
//		return new SecondPerson(name, age, addr);
//	} };
	
	
	/*
	 	instead of calling methods directly, you are calling beans(name,age, address) -> it is called auto-wiring
		name = bean name, age = bean age(which is age mehtod), address = bean address or address()
		Use following two methods together to make sense
	 */
	
	@Bean
	public Address addressForPerson3() {
		return new Address("Damak", "Jhapa");
	}
	
	// parameter name should be same as bean name
	@Bean
	public Person person3WithParameters(String name, int age, Address addressForPerson3) {
		return new Person(name, age, addressForPerson3); 
	}
	
	
	// use following two beans together to understand the concept of bean auto wiring with @Qualifier
	// use Qualifier. To do this, comment @Primary. The idea of qualifier is to avoid error due to multiple candidate beans to retrieve data from
	@Bean 
	public Person Person5Qualifier(String name, int age, @Qualifier("address3Qualifier") Address address){
		return new Person(name, age, address);
	}
	
	@Bean(name = "address3")
	@Qualifier("address3Qualifier")
	public Address address3() {
		return new Address("18535 E B P", "Aurora, CO");
	}
}

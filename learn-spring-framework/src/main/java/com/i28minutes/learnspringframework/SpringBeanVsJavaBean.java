package com.i28minutes.learnspringframework;

import java.io.Serializable;

/*
 * POJO -> Plain Old Java Object
 * Java Bean
 * Spring Bean
 */

class POJO{
	private String text;
	private int number;
	
	public String toString() {
		return text + ":" + number;
	}
}

// Java bean -> EJB = Enterprise Java Bean
/*
 * 1. EJB has public no argument constructor by default
 * 2. should have getters and setters
 * 3. implements Serializable interface -> java.io.Serializable
 * If a class implements all these 3 concepts, then the instance of that class is Java Bean
 * It is not common now a days - important ones are POJOs and Spring Beans
 */
class JavaBean implements Serializable{
	//1 public no-arg constructor
	public JavaBean() {
		
	}
	// variables
	private String txt;
	private int num;
	
	//2. getters and setters
	public String getText() {
		return this.txt;
	}
	public void setText(String newText) {
		this.txt = newText;
	}
	
	public int getNum() {
		return this.num;
	}
	public void setNum(int newNum) {
		this.num = newNum;
	}
}


public class SpringBeanVsJavaBean {
	public static void main(String []args) {
		System.out.println("Spring Bean vs Java Bean .......................");
		
		// instantiate POJO class
		POJO pojo = new POJO();
		System.out.println(pojo); // returns null:0 b/c text default for text(String) is null
	}

}

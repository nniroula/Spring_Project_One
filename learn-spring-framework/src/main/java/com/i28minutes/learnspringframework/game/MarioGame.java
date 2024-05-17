package com.i28minutes.learnspringframework.game;

/*
 * call these methods in GameRunner class
 */

//public class MarioGame {
public class MarioGame implements GamingConsole{ // implements interface
	// implements the methods defined in the GamingConsole interface
	// up button
	public void up() {
		System.out.println("Jump - Mario");
	}
	
	// down button
	public void down() {
		System.out.println("Go into a hole - Mario");
	}
	
	// left button
	public void left() {
		System.out.println("Go back - Mario");
	}
	
	// right button
	public void right() {
		System.out.println("Accelerate - Mario");
	}
	
	
}

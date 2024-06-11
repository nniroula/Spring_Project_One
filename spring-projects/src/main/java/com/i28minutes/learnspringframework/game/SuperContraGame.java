package com.i28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//public class SuperContraGame {

// step 2 implement interface

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole{

	// same methods as in MarioGame class, but with different actions
	// up button
	public void up() {
		System.out.println("UP - SuperContra");
	}
	
	// down button
	public void down() {
		System.out.println("Sit Down - SuperContra");
	}
	
	// left button
	public void left() {
		System.out.println("Go back - SuperContra");
	}
	
	// right button
	public void right() {
		System.out.println("Shoot a bullet - SuperContra");
	}
	

}

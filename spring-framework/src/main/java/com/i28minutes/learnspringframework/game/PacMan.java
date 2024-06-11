package com.i28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class PacMan implements GamingConsole{
	
	public void up() {
		System.out.println("UUUUp - PacMan");
	}
	
	// down button
	public void down() {
		System.out.println("Dooooooown - PacMan");
	}
	
	// left button
	public void left() {
		System.out.println("Lefffffft - PacMan");
	}
	
	// right button
	public void right() {
		System.out.println("Rigggght - PacMan");
	}
}

package com.i28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * Here, you want to run Mario game. So, create MarioGame instance
 */

@Component
public class GameRunner {
//	MarioGame game;  // game is of MarioGame type
//	SuperContraGame game;  // game is of MarioGame type
	
	// Instead of above, make this class use Interface to implement loose coupling
	private GamingConsole game;  // GamingConsole is an Interface
	
	// constructor
//	public GameRunner(MarioGame game) {
//		this.game = game;
//	}
	
//	public GameRunner(SuperContraGame game) {
//		this.game = game;
//	}
	
//	public GameRunner(GamingConsole game) {
	public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game) {
		this.game = game;
	}
	

	public void run() {
		System.out.println("Running game: " + game); // later on, do logIn framework
		game.up();
		game.down();
		game.right();
		game.left();
		
	}

}

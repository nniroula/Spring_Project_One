package com.i28minutes.learnspringframework;

import com.i28minutes.learnspringframework.game.GameRunner;
import com.i28minutes.learnspringframework.game.MarioGame;
import com.i28minutes.learnspringframework.game.PacMan;
import com.i28minutes.learnspringframework.game.SuperContraGame;

/*
 * In this class, 
 * 		Tightly coupled java code
 * 			create a game runner class instance
 * 				Game classes: Mario, SuperContra, Pacman etc
 */

public class App01GamingBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var marioGame = new MarioGame();      // MarioGame instance
		var gameRunner = new GameRunner(marioGame);  // Game Runner to run MarioGame
		gameRunner.run();
		                                        
		var superContraGame = new SuperContraGame();
		var gameRunner2 = new GameRunner(superContraGame);  // Game Runner to run MarioGame
		gameRunner2.run();
		
		// PacMan game
//		PacMan pm = new PacMan();
		var pm = new PacMan();
		var gameRunner3 = new GameRunner(pm);
		gameRunner3.run();

	}

}

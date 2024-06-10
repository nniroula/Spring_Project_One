package com.i28minutes.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.i28minutes.learnspringframework.game.GameRunner;
import com.i28minutes.learnspringframework.game.GamingConsole;
import com.i28minutes.learnspringframework.game.MarioGame;
import com.i28minutes.learnspringframework.game.PacMan;
import com.i28minutes.learnspringframework.game.SuperContraGame;



public class App03GamingSpringBeans {

	public static void main(String[] args) {
		// create Spring Context
		try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class))
		{
			// retrieve the game bean
			System.out.println("From gaming console ....");
			context.getBean(GamingConsole.class).up();
			
			// game runner
			System.out.println();
			System.out.println("From GameRunner ......");
			context.getBean(GameRunner.class).run();
		}
		
		
	
		
		// TODO Auto-generated method stub
//		var marioGame = new MarioGame();      // MarioGame instance
//		var gameRunner = new GameRunner(marioGame);  // Game Runner to run MarioGame
//		gameRunner.run();
//		                                        
//		var superContraGame = new SuperContraGame();
//		var gameRunner2 = new GameRunner(superContraGame);  // Game Runner to run MarioGame
//		gameRunner2.run();
//		
//		// PacMan game
////		PacMan pm = new PacMan();
//		var pm = new PacMan();
//		var gameRunner3 = new GameRunner(pm);
//		gameRunner3.run();

	}

}

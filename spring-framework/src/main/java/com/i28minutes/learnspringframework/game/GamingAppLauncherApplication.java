package com.i28minutes.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// configuration file set up
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// configuration file containing Spring beans

//@Configuration
//class GamingConfiguration {
//	// define beans
//	
//	// return pacman game
//	@Bean
//	public GamingConsole game() {
//		var game = new PacMan();
//		return game;
//	}
//	
//	
//	// game runner class, pass above game as parameter - 2 ways - 1. call game(), 2. pass it as param
//	@Bean
//	public GameRunner gameRunner(GamingConsole game) {
////		var gameRunner = new GameRunner(game());
//		var gameRunner = new GameRunner(game);
//		return gameRunner;
//	}
//}


// main class

@Configuration
@ComponentScan("com.i28minutes.learnspringframework.game")
public class GamingAppLauncherApplication {
	// config beans
	// return pacman game
//	@Bean
//	public GamingConsole game() {
//		var game = new PacMan();
//		return game;
//	}
//	
	
	// game runner class, pass above game as parameter - 2 ways - 1. call game(), 2. pass it as param
//	@Bean
//	public GameRunner gameRunner(GamingConsole game) {
////		var gameRunner = new GameRunner(game());
//		System.out.println("Parameter: " + game);
//		var gameRunner = new GameRunner(game);
//		return gameRunner;
//	}

	public static void main(String[] args) {
		// create Spring Context
//		try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class))
		// context is now present in public class, i.e, App03GamingSpringBeans
		try(var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class))
		{
			// retrieve the game bean
			System.out.println("From gaming console ....");
			context.getBean(GamingConsole.class).up();
			
			// game runner
			System.out.println();
			System.out.println("From GameRunner ......");
			context.getBean(GameRunner.class).run();
		}
		

	}

}

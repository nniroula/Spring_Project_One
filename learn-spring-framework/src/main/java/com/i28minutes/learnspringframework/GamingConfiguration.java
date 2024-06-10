package com.i28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.i28minutes.learnspringframework.game.GameRunner;
import com.i28minutes.learnspringframework.game.GamingConsole;
import com.i28minutes.learnspringframework.game.PacMan;


// configuration file containing Spring beans

@Configuration
public class GamingConfiguration {
	// define beans
	
	// return pacman game
	@Bean
	public GamingConsole game() {
		var game = new PacMan();
		return game;
	}
	
	//NOTE: we are creating a PacMan game and passing it to GameRunner class
	
	// game runner class, pass above game as parameter - 2 ways - 1. call game(), 2. pass it as param
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
//		var gameRunner = new GameRunner(game());
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}
}

package com.Micah.springframeworkdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Micah.springframeworkdemo.game.GameRunner;
import com.Micah.springframeworkdemo.game.GamingConsole;
import com.Micah.springframeworkdemo.game.PacmanGame;


@Configuration
public class GamingAppConfig {
 
	@Bean
	public GamingConsole game() {
		//Spring must help us with object creation why are we still creating objects?
		var game = new PacmanGame();
		return game;
	}
	
	@Bean 
	public GameRunner gameRunner(GamingConsole game) {
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}
	
	
}

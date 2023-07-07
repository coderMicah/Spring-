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
		return new PacmanGame();
	}
	
	@Bean 
	public GameRunner gameRunner(GamingConsole game) {
		return new GameRunner(game);
	}
	
	
}

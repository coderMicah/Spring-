package com.Micah.springframeworkdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Micah.springframeworkdemo.game.GameRunner;
import com.Micah.springframeworkdemo.game.GamingConsole;

//import com.Micah.springframeworkdemo.game.*;

public class App01GamingBasicJava {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				GamingAppConfig.class)) {
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
		
//		WITHOUT USING SPRING

//		var game = new MarioGame();
//		var game = new SuperContraGame();

//		var game = new PacmanGame();
//		var gameRunner = new GameRunner(game);
//		gameRunner.run();
//		

	}

}

package com.Micah.springframeworkdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring{

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext(HelloWorldAppConfig.class);
		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("customAddress"));
		System.out.println("Parameterized bean : " + context.getBean("personParameters"));
		System.out.println("Method calling bean : "+ context.getBean("personMethodCall"));
		System.out.println(context.getBean("person"));
		


      
	}

}

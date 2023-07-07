package com.Micah.springframeworkdemo.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring{

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldAppConfig.class)) {
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean("customAddress"));
			System.out.println("Parameterized bean : " + context.getBean("personParameters"));
			System.out.println("Method calling bean : "+ context.getBean("personMethodCall"));
			System.out.println("Primary : "+ context.getBean("personPrimary"));
			System.out.println("Qualifier : "+ context.getBean("personQualifier"));
			System.out.println(context.getBean("person"));

			System.out.println(context.getBean(Person.class));
		}
		
//		TO LIST ALL BEANS MANAGED BY IOC CONTAINER
//		VAR beans = context.getBeanDefinitionNames();
//		for (String bean : beans)
//			System.out.println(bean);

	}

}

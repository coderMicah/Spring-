package com.Micah.springframeworkdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age, Address address) {
};

record Address(String firstline, String city) {
};

@Configuration
public class HelloWorldAppConfig {

	@Bean
	public String name() {
		return "John Doe";
	}

	@Bean
	public int age() {
		return 20;
	}

	@Bean
	public Person person() {
		return new Person("Jane Doe", 13, new Address("Silicon Valley", "Califonia"));
	}

	// We are creating new bean that depends on other beans(i.e age,address,name)
	// using method calling approach
	@Bean
	public Person personMethodCall() {
		return new Person(name(), age(), address());
	}

	// We are creating new bean that depends on other beans(i.e age,address,name)
	// passing beans as parameters i.e we must use the bean names e.g customAddress
	// not address
	@Bean
	public Person personParameters(String name, int age, Address customAddress) {
		return new Person(name, age, customAddress);
	}

	@Bean(name = "customAddress")
	public Address address() {
		return new Address("New York", "MA");
	}
}

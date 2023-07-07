package com.Micah.springframeworkdemo.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
	@Primary
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
	
	
	//WHEN WE HAVE MULTIPLE BEANS WE CAN SOLVE THE CHALLENGE BY HAVING PRIMARY BEAN
	//IF WE WANT TOAUTOWIRE THE BEANS WE NEED TO USE QUALIFIERS

	@Bean
	public Person personPrimary(String name, int age, Address address) {
		return new Person(name, age, address);
	}
	
	@Bean
	public Person personQualifier(String name, int age, @Qualifier("CAAddress")Address address) {
		return new Person(name, age, address);
	}

	@Bean(name = "customAddress")
	@Primary
	public Address address() {
		return new Address("New York", "MA");
	}

	@Bean(name = "address1")
	@Qualifier("CAAddress")
	public Address address1() {
		return new Address("California", "CA");
	}
}

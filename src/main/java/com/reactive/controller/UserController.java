package com.reactive.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class UserController {

	
	/*
	 * @GetMapping("/{name}") public Flux<Person> getPersons(@PathVariable("name")
	 * String name) {
	 * 
	 * Flux<Person> persons = service.getPersons(name); Flux<String> names =
	 * persons.map(x -> x.getName()); System.out.println("names "+names);
	 * 
	 * return persons; }
	 */
}

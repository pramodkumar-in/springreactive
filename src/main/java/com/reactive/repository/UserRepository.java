package com.reactive.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactive.entity.User;

import reactor.core.publisher.Mono;

/**
 * @author pramod
 * 
 * */
public interface UserRepository extends ReactiveMongoRepository<User, String>{
	
	public Mono<User> findByUsername(String username); 

}

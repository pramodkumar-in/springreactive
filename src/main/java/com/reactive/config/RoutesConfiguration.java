package com.reactive.config;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import com.reactive.handler.AuthenticationHandler;
import com.reactive.handler.UserHandler;
import com.reactive.repository.UserRepository;

/**
 * @author pramod
 * 
 * */


@Configuration
public class RoutesConfiguration {
	
	@Autowired
	private AuthenticationHandler authHandler;
	
	@Autowired
	private UserRepository userRepository;

	
	@Bean
    public RouterFunction<?> userRoute() { 
		UserHandler userHandler = new UserHandler(userRepository);
        return RouterFunctions
                .route(POST("/users").and(accept(APPLICATION_JSON)), userHandler::createUser)
                .andRoute(GET("/users").and(accept(APPLICATION_JSON)), userHandler::listUser)
                .andRoute(GET("/users/{userId}").and(accept(APPLICATION_JSON)), userHandler::getUserById)
                .andRoute(PUT("/users").and(accept(APPLICATION_JSON)), userHandler::createUser)
                .andRoute(DELETE("/users/{userId}").and(accept(APPLICATION_JSON)), userHandler::deleteUser);
    }
	
	
	@Bean
	public RouterFunction<?> authRoute() {
		return RouterFunctions
                .route(POST("/auth/login").and(accept(APPLICATION_JSON)), authHandler::login)
                .andRoute(POST("/auth/signup").and(accept(APPLICATION_JSON)), authHandler::signUp);
	}
	
	
}

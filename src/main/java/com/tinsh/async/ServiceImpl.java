package com.tinsh.async;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ServiceImpl implements Service{

	/*
	 * public String userURL ="https://reqres.in/api/users?page=2"; public String
	 * allUserURL ="https://reqres.in/api/users?page=2";
	 */
	
	public String userURL ="http://localhost:8081/user";
	public String allUserURL ="http://localhost:8081/users";
	
	
	public void getUser() {
	     
		System.out.println("inside getUser");
		
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(userURL, String.class);
	     
	    System.out.println(result);
	}

	@Override
	public void getAllUsers() {
		System.out.println("inside getAllUsers");
		
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(allUserURL, String.class);
	     
	    System.out.println(result);		
	}

	@Override
	@Async
	public CompletableFuture<String> getUserAsync() {
		System.out.println("inside getUserAsync");
		
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(userURL, String.class);
	     
	    System.out.println(result);	
	    return CompletableFuture.completedFuture(result);
	}

	@Override
	@Async
	public CompletableFuture<String> getAllUsersAsync() {
		System.out.println("inside getAllUsersAsync");
		
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(allUserURL, String.class);
	     
	    System.out.println(result);		
	    return CompletableFuture.completedFuture(result);
	}
	
	
}

package com.tinsh.async;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	Service service;
	
	@RequestMapping(value = "/base", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	public void myController() {
		
		System.out.println("inside base");
		long startTime = System.currentTimeMillis();
		
		service.getUser();
		service.getAllUsers();
		 service.getAllUsers();
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("sync call total time:"+totalTime);
		
		
	}
	
	@RequestMapping(value = "/base/async", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	public void myAsyncController() throws Throwable {
		 
		System.out.println("inside base");
		long startTime = System.currentTimeMillis();
		
		CompletableFuture<String> user=service.getUserAsync();
		CompletableFuture<String> users= service.getAllUsersAsync();
		 service.getAllUsers();
		
		
		  try { System.out.println("user :"+user.get());
		  System.out.println("users :"+users.get()); } catch (Throwable e) { throw
		  e.getCause(); }
		 
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Async call total time :"+totalTime);
		
		
	}
}

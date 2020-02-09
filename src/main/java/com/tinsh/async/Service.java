package com.tinsh.async;

import java.util.concurrent.CompletableFuture;

public interface Service {
	
	public void getUser();
	
	public void getAllUsers();
	
	public CompletableFuture<String> getUserAsync();
	
	public CompletableFuture<String> getAllUsersAsync();
	

}

package com.example.core.services;

import java.util.List;

import com.example.core.model.Post;

public interface PostService { 
	public List<Post> validacion(List<Post> posts) throws NullPointerException;
	public void addClass(Class clazz);
	
	
		

}

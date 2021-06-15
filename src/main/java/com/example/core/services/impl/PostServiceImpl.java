package com.example.core.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.example.core.model.Post;
import com.example.core.services.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Override
	public List<Post> validacion(List<Post> posts) {
		Log log = LogFactory.getLog(getClass());
		// TODO Auto-generated method stub
		log.info("desde el servicio 1");
		
		for(Post p : posts) {
			if(p.getTitulo()== null) {
				throw new NullPointerException("no tiene titulo");
			}
		}
		
		
		return posts;
	}

	@Override
	public void addClass(Class clazz) {
		System.out.print(clazz.getName());
		// TODO Auto-generated method stub
		
	}
	

}

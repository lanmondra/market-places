package com.example.core.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.core.model.Post;
import com.example.core.services.PostService;

@Service("serviceDecorado")
@Scope("singleton")
public class PostServiceDecoradoImp  implements PostService{
	Log log = LogFactory.getLog(getClass());
	
	
	@Autowired
	private PostServiceImpl postServiceImp;
	
	
	@Autowired
	private PostServiceDos postServiceImplDos;

	@Override
	public List<Post> validacion(List<Post> posts) {
		log.debug(posts);
		posts= postServiceImp.validacion(posts);
		posts = postServiceImplDos.validacion(posts);
		
		for(Post p : posts) {
			if(p.getDescripcion()== null) {
				throw new NullPointerException("no tiene descripcion");
			}
			if(p.getFecha()== null) {
				throw new NullPointerException("no tiene fecha");
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

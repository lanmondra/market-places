package com.example.core.components;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.core.model.Post;

@Component("com.example.core.components.postComponent")
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PostComponent {
	
		public List<Post> getPosts(){		
		ArrayList<Post> post= new ArrayList<>();
				
		post.add(new Post(1,"Desarrollo web es un término que define la creación de sitios web para Internet",
				"http://localhost:8080/img/post.jpg",new Date(),"desarrolo web con Html Y Css"));
		post.add(new Post(2,"Desarrollo web es un término que define la creación de sitios web para Internet",
				"http://localhost:8080/img/post.jpg",new Date(),"Multiplataforma java"));
		post.add(new Post(3,"Desarrollo web es un término que define la creación de sitios web para Internet",
				"http://localhost:8080/img/post.jpg",new Date(),"curso de mysql"));
		post.add(new Post(4,"Desarrollo web es un término que define la creación de sitios web para Internet",
				"http://localhost:8080/img/post.jpg",new Date(),"curso de jdk"));						
		return post;			
	}

}

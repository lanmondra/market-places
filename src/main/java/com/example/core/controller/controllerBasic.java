package com.example.core.controller;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.core.components.PostComponent;
import com.example.core.configuration.Pages;
import com.example.core.model.Post;


@Controller
@RequestMapping("/")
public class controllerBasic {
	
		
	@Autowired
	private PostComponent postComponent;

	
	
	@GetMapping(path= {"/posts","/"})	
	public String saludar(Model model) {
		model.addAttribute("posts", this.postComponent.getPosts());	    
	    return "index";
	   
	}
	@GetMapping(path= {"/public"})
	public ModelAndView post() {
		ModelAndView modelAndView = new ModelAndView(Pages.HOME);
		modelAndView.addObject("posts", this.postComponent.getPosts());
		return modelAndView;
		
	}
	
	@GetMapping(path= {"/post","/post/p/{post}"})
		public ModelAndView getPostIndividual(
			 @PathVariable(required = true,name="post") int id
				
				) {
			ModelAndView modelAndView = new ModelAndView(Pages.POST);
			
			List<Post> postFiltrado = this.postComponent.getPosts().stream().filter((p)->{
				return p.getId()==id;
			}).collect(Collectors.toList());
			modelAndView.addObject("post",postFiltrado.get(0));
			return modelAndView;
			
		}
	
	@GetMapping("/postNew")
	public ModelAndView getForm() {
	
		return new ModelAndView("form").addObject("post",new Post());
	}
	
	@PostMapping("/addNewPost")
	public String addNewPost(Post post,Model model) {
		List<Post> posts = this.postComponent.getPosts();
		posts.add(post);
		model.addAttribute("posts",posts);
		return "index";
			
		
	}
	
	}

	




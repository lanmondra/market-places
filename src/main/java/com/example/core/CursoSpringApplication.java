package com.example.core;



import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.core.components.PostComponent;
import com.example.core.model.Conexion;
import com.example.core.services.PostService;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("${cursoSpring.jdbc.import.ruta}")
	private String ruta;
	
	@Value("${cursoSpring.jdbc.import}")
	private String importar;
	
	/*
	@Autowired
	@Qualifier("beanConexion")
	private Conexion conexion;
	
	@Autowired
	@Qualifier("com.example.core.components.postComponent")
	public PostComponent postComponent;
	
	
	@Autowired
	@Qualifier("serviceDecorado")
	
	public PostService postService;
	
	

	public PostService getPostService() {
		return postService;
	}

	
	//forma 1
	
@Autowired
	@Qualifier("serviceDecorado")
	public void setPostService(PostService postService) {
		
		this.postService = postService;
		this.postService.addClass(CursoSpringApplication.class);
	}
	
	
	//constructor vaacio
	
	
	//forma 2
	@Autowired	
	public CursoSpringApplication (@Qualifier("serviceDecorado") PostService postService) {
		this.postService = postService;
		
	}
	
	*/
public CursoSpringApplication() {
		
	}
	

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		Log log= LogFactory.getLog(getClass());
		
		//Log log = LogFactory.getLog(getClass());
		
		// TODO Auto-generated method stub
		/*System.out.println("mysql");
		postComponent.getPosts().forEach(p-> {
			System.out.println(p.getDescripcion());
		});*/
		

			//jdbcTemplate.execute("insert into permiso (Nombre)values('ejemplo 1');");
		
		if(importar.equalsIgnoreCase("true")) {
			Path path =Paths.get(ruta);

			//Path path =Paths.get("src/main/resources/import.sql");
		
		
		
		
				try(BufferedReader b = Files.newBufferedReader(path, Charset.defaultCharset())) {
				
					String line;
					while((line = b.readLine()) !=null) {
						//jdbcTemplate.execute(line);
						jdbcTemplate.execute(line);
						log.info(line);
						
						
					}
					
				} catch (IOException ex) {
					// TODO: handle exception
				}
			
				
				
		}
		log.info("la cantidad que tenemos es :  "+ jdbcTemplate.queryForObject("select count(*) from permiso", Integer.class));
		
		
		}
	
	}
		
		
		
		/*try {
		postService.validacion(postComponent.getPosts())
		.forEach(post->{
			
			log.info(post.getTitulo());
			//System.out.println(post.getTitulo());
		});
		}catch(Exception e) {
			System.out.print(e.getMessage());
			
		}
		
	}

}
*/
		
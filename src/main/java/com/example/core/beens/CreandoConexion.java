package com.example.core.beens;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.example.core.model.Conexion;
import com.example.core.model.Usuario;
@Component
public class CreandoConexion {
	@Bean(name = "beanUsuario")

	public Usuario getUsuario() {
		return new Usuario();			
	}
	
	
	@Bean (name="beanConexion")
	public Conexion getConexion() {
		Conexion conexion = new Conexion();
		conexion.setBd("mysql");
		conexion.setUrl("localhost");		
		return conexion;
		
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource d = new DriverManagerDataSource() ;
		d.setDriverClassName("com.mysql.jdbc.Driver");
		//d.setDriverClassName("com.mysql.cj.jdbc.Driver");
		d.setUrl("jdbc:mysql://localhost:3306/log?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		d.setUsername("lanmondra");
		d.setPassword("smile");
			return d;
		
		}			
}

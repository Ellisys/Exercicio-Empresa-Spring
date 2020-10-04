package br.com.exercicio.empresa.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public PasswordEncoder passawordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		//return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select email, senha, empregado "+
		"from funcionario "+"where email = ?")
		.authoritiesByUsernameQuery("select email, autoridade "+
		"from autorizacao "+ "where email = ?");
		
		
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET,"/pedido").permitAll()
			.antMatchers("/cliente").hasAnyRole("FUNCIONARIO","GERENTE")
			.antMatchers("/pedido").hasAnyRole("FUNCIONARIO","GERENTE")
			.antMatchers("/funcionario").hasRole("GERENTE")
			.antMatchers("/").permitAll()
			.and().httpBasic(); 
			
			
	}
}
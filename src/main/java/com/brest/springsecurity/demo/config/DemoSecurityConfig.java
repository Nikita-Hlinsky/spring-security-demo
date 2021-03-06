package com.brest.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("Nikita").password("pikopiko").roles("ADMIN", "EMPLOYEE"))
		.withUser(users.username("Alina").password("pikopiko1").roles("EMPLOYEE"))
		.withUser(users.username("Vika").password("pikopiko2").roles("EMPLOYEE"));
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.anyRequest().authenticated() //any requests must be logged in
				.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authinticateTheUser")
				.permitAll()
			.and()
				.logout()
				.permitAll();
	}

	
	
}

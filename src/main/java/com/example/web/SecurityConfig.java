package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
		.authorizeHttpRequests((requests) -> requests
												.requestMatchers("/")
													.permitAll()
				
												.requestMatchers("/editContact/**", "/editNote/**", "/deleteContact/**", "/deleteNote/**")
													.hasAnyRole("USER", "ADMIN")
													
												.requestMatchers("/webjars/**", "/resources/**", "/static/**", "/css/**", "/js/**")
													.permitAll()
				
												.anyRequest().authenticated()
		)
		.formLogin((form) -> form
								.loginPage("/login")
								.defaultSuccessUrl("/", true)
								.permitAll()
		)
		.logout((logout) -> logout
								.permitAll()
		)
		.exceptionHandling(excHand -> excHand.accessDeniedPage("/errors/403"));
		
		return http.build();
		
	}

}

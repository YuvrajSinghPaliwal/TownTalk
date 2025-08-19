package com.TownTalk.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	  @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf().disable()  // Disable CSRF protection
	            .authorizeHttpRequests(auth -> auth
	                .anyRequest().authenticated()  // Require authentication for all requests
	            )
	            .formLogin(form -> form
	                .permitAll()                 // Allow everyone to see the login page
	            );
	        return http.build();
	    }
	
//	@Bean
//	public UserDetailsService userDetailsService() {
		
		
		 // this is hard-coded
//		UserDetails user=User.withDefaultPasswordEncoder().username("yuvi").password("yuvi@123").roles("Admin").build();
//		
//		UserDetails user1=User.withDefaultPasswordEncoder().username("nav").password("nav@123").roles("USER").build();
		
//		return new InMemoryUserDetailsManager(user,user1);
		
//	}
	
	@Bean 
	public AuthenticationProvider authProvider() {
		
		DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		
		return provider;
		
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		
		return config.getAuthenticationManager();
		
	}
	
	
}

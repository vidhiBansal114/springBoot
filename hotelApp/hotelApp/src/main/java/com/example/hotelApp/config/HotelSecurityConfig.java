package com.example.hotelApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class HotelSecurityConfig {
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests().//requestMatchers("hotel/create").hasRole("ADMIN").
		anyRequest().authenticated().and().httpBasic();//formLogin();
		return http.build();
		
	}
	@Bean
	public UserDetailsService users() {
		UserDetails user1=User.builder().username("tony").password(passwordEncoder().encode("password")).roles("ADMIN").build();
		UserDetails user2=User.builder().username("steve").password(passwordEncoder().encode("password")).roles("Normal").build();
		
		return new InMemoryUserDetailsManager(user1,user2);

	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

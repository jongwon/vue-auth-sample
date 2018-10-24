package com.sp.sample.authserver1;

import com.sp.sample.authserver1.model.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by jongwon on 2017. 4. 20..
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	private UserLoginService userLoginService;

	@Bean
	public PasswordEncoder passwordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}

	@Autowired
	public void configAuthBuilder(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userLoginService)
				.passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/", "/home", "/remoteLogin")
					.permitAll()
				.anyRequest()
					.authenticated()
					.and()
				.formLogin()
//					.loginPage("/login")
//					.failureUrl("/login?error=true")
//					.defaultSuccessUrl("/hello")
					.permitAll()
					.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/home")
					.permitAll();
	}

}
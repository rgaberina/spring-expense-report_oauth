/**
 * 
 */
package com.berina.expensereports.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author berina
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
    protected void configure(AuthenticationManagerBuilder auth) 
      throws Exception {
        auth.inMemoryAuthentication()
          .withUser("john").password("123").roles("USER");
    }
 
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() 
      throws Exception {
        return super.authenticationManagerBean();
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll();
    	/*http
        .authorizeRequests()
        .antMatchers("/login*").anonymous()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login.html")
        .defaultSuccessUrl("/homepage.html")
        .failureUrl("/login.html?error=true")
        .and()
        .logout().logoutSuccessUrl("/login.html");*/
    	/*http.authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .oauth2Login();*/
    }
}

package org.elevenfifty.java301;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
    	httpSecurity
    		//To make sure we have access to console
	        .authorizeRequests().antMatchers("/h2-console/**").permitAll()
	        .and()
	        .authorizeRequests().antMatchers("/console/**").permitAll()
	        .and()
	        //don't ever put the login page   VVV HERE VVV   or you will lock yourself out of the login
	        .authorizeRequests().antMatchers("/", "/user/**").authenticated().anyRequest().permitAll()
	        .and()
	        .formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
	        .and()
	        .logout().logoutSuccessUrl("/login?logout")
	        .and()
	        .csrf().disable()
	        .headers().frameOptions().disable();
   	
    }
    	
//        .and()
//        .csrf().disable()
//        .headers().frameOptions().disable();    
    	
    	@Autowired
    	private DataSource dataSource;
    	
    	@Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication()
                    .dataSource(dataSource)
                    .rolePrefix("")
                    .passwordEncoder(new PlaintextPasswordEncoder())
                    .usersByUsernameQuery("select email as username, password, active as enabled from java301.users where email = ?")
                    .authoritiesByUsernameQuery("select u.email as username, ur.role as authority from java301.users u inner join java301.user_roles ur on (u.id = ur.user_id) where u.email = ?");
        }
    	
    	
    	
    
    }
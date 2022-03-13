package ru.matveykenya.springdaohibernate;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.security.sasl.AuthenticationException;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("matvey2").password("{noop}0123").authorities("write", "read")
//                .and()
//                .withUser("fff").password("{noop}p0123").authorities("write");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/persons/by-city").permitAll()
                .and()
                .authorizeRequests().antMatchers("/hi").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}

package ru.matveykenya.springdaohibernate;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.security.sasl.AuthenticationException;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("andrey").password("{noop}0123").roles("WRITE")
                .and()
                .withUser("fedot").password("{noop}0123").roles("READ", "DELETE")
                .and()
                .withUser("ivan").password("{noop}0123").roles("DELETE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/hi").permitAll()
                .and()
                .authorizeRequests().antMatchers("/hi-registered-user").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}

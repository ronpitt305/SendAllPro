package com.ronone.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig
  extends WebSecurityConfigurerAdapter
{
  @Autowired
  public EUserDetailsService eUserDetailsService;
  
  public WebSecurityConfig() {}
  
  protected void configure(HttpSecurity http)
    throws Exception
  {
    ((HttpSecurity)((FormLoginConfigurer)((HttpSecurity)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)http.authorizeRequests().antMatchers(new String[] { "/", "/adde", "/savedEUser", "/registed", "/registedSendEmail", "/addContacts", "/emailSet" })).permitAll().anyRequest()).authenticated().and()).formLogin().loginPage("/login").permitAll()).and()).logout().permitAll();
  }
  
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
  {
    auth.userDetailsService(eUserDetailsService);
  }
}

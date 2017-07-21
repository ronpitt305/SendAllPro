package com.ronone.security;

import com.ronone.dao.EmailUserDao;
import com.ronone.entities.EmailUser;
import com.ronone.entities.UserProfile;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EUserDetailsService implements UserDetailsService {

  private EmailUserDao emailUserDao;

  @Autowired
  public void setEmailUserDao(EmailUserDao emailUserDao) {
    this.emailUserDao = emailUserDao;
  }

  
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
  {
    EmailUser emailUser = emailUserDao.findByUsername(s);
    if (emailUser == null) {
      System.out.println("User was not found");
      throw new UsernameNotFoundException("Username not found");
    }
    return new User(emailUser.getUsername(), emailUser.getPassword(), emailUser
      .getState().equals("ACTIVE"), true, true, true, getAuthorities(emailUser));
  }
  
  private List<GrantedAuthority> getAuthorities(EmailUser emailUser) {
    List<GrantedAuthority> authorities = new ArrayList();
    
    for (UserProfile userProfile : emailUser.getUserProfiles()) {
      System.out.println("UserProfile: " + userProfile);
      authorities.add(new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
    }
    System.out.println("authorities: " + authorities);
    return authorities;
  }
}

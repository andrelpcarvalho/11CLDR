package com.example.demo.configuration;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {

  private final UserRepository userRepository;

  public UserAuthService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User inDB = userRepository.findByUsername(username);
    if (inDB == null) {
      throw new UsernameNotFoundException("User not found");
    }
    return new AppUser(inDB);
  }

}
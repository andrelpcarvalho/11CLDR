package com.example.demo.user;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  UserRepository userRepository;

  PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public UserDto save(UserDto userDto) {
    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setDisplayName(userDto.getDisplayName());
    user.setEmail(userDto.getEmail());
    user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
    user.setLastUpdated(LocalDateTime.now(ZoneOffset.UTC));

    User saved = this.userRepository.save(user);
    return toDto(saved);
  }

  public UserDto updateUser(long id, UserDto userDto) {
    User inDB = userRepository.getOne(id);
    inDB.setDisplayName(userDto.getDisplayName());
    inDB.setLastUpdated(LocalDateTime.now(ZoneOffset.UTC));

    User saved = userRepository.save(inDB);
    return toDto(saved);
  }

  private UserDto toDto(User user) {
    UserDto dto = new UserDto();
    dto.setId(user.getId());
    dto.setUsername(user.getUsername());
    dto.setDisplayName(user.getDisplayName());
    dto.setEmail(user.getEmail());
    // password propositalmente NÃO copiado — nunca sai na resposta
    return dto;
  }

}
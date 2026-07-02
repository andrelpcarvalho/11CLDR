package com.example.demo.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/api/1.0/users")
  public UserDto createUser(@RequestBody UserDto userDto){
    return this.userService.save(userDto);
  }

  @PutMapping("/api/1.0/users/{id}")
  @PreAuthorize("@userAuthorizationService.canUpdate(principal.user.id, #id) or hasRole('ROLE_admin')")
  public UserDto updateUser(@PathVariable long id, @RequestBody UserDto userDto){
    return this.userService.updateUser(id, userDto);
  }

}
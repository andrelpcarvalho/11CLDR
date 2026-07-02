package com.example.demo.user;

import lombok.Data;

@Data
public class UserDto {

  private long id;
  private String username;
  private String displayName;
  private String email;
  private String password; // usado só na entrada (create); nunca deve vir preenchido na resposta

}
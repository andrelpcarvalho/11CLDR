package com.example.demo;

import java.sql.*;

public class ExemploVulnerabilidade {
    public static void main(String[] args) {
        String userInput = args[0];

        String url = System.getenv("DB_URL");       // ex: jdbc:mysql://localhost:3306/banco
        String user = System.getenv("DB_USER");
        String pass = System.getenv("DB_PASSWORD");

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement statement = connection.prepareStatement("SELECT nome, email FROM usuarios WHERE nome = ?")) {

            statement.setString(1, userInput);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    String email = resultSet.getString("email");
                    System.out.println("Nome: " + nome + ", Email: " + email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
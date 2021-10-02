package com.example.demo.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class DatabaseConnection {
  private static DatabaseConnection instance;
  private Connection connection;

  private String url;
  private String user;
  private String password;

  private DatabaseConnection() {
    try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {
      Properties properties = new Properties();
      properties.load(input);
      url = properties.getProperty("url");
      user = properties.getProperty("user");
      password = properties.getProperty("password");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    try {
      assert url != null;
      this.connection = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static DatabaseConnection getInstance() {
    if (instance == null) {
      instance = new DatabaseConnection();
    } else {
      try {
        if (instance.getConnection().isClosed()) {
          instance = new DatabaseConnection();
        }
      } catch (SQLException e) {
        System.out.println(e.getMessage());
      }
    }

    return instance;
  }

  public Connection getConnection() {
    return connection;
  }
}

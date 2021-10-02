package com.example.demo.repository;

import com.example.demo.model.Movie;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieRepository {
  public List<Movie> getFirstMovies(int amount) {
    return getMovies("SELECT * FROM movies LIMIT " + amount);
  }

  public List<Movie> getRandomMovies(int amount) {
    return getMovies("SELECT * FROM movies ORDER BY RAND() LIMIT " + amount);
  }

  public List<Movie> getTopMovies(int amount) {
    return getMovies("SELECT * FROM movies ORDER BY popularity DESC LIMIT " + amount);
  }

  public int getWonAwardMovies() {
    return getSqlResultAsInt("SELECT COUNT(*) FROM movies WHERE awards = \"yes\"");
  }

  public List<Movie> getComedyAwardsMovies() {
    return getMovies("SELECT * FROM movies WHERE subject = \"comedy\" AND awards = \"yes\"");
  }

  public List<Movie> getMovies(String sql) {
    List<Movie> result = new ArrayList<>();

    Connection connection = DatabaseConnection.getInstance().getConnection();

    PreparedStatement preparedStatement;
    ResultSet resultSet;

    try {
      preparedStatement = connection.prepareStatement(sql);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        result.add(
            new Movie(
                resultSet.getInt("id"),
                resultSet.getString("title"),
                resultSet.getInt("year"),
                resultSet.getInt("length"),
                resultSet.getString("subject"),
                resultSet.getInt("popularity"),
                resultSet.getString("awards")));
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return result;
  }

  private int getSqlResultAsInt(String sql) {
    int result = -1;
    Connection connection = DatabaseConnection.getInstance().getConnection();
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    try {
      preparedStatement = connection.prepareStatement(sql);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        result = resultSet.getInt(1);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return result;
  }
}

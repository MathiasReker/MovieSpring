package com.example.demo.controller;

import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class MovieController {

  private final MovieService MOVIE_SERVICE;

  @Autowired
  public MovieController(MovieService movie_service) {
    MOVIE_SERVICE = movie_service;
  }

  @GetMapping("/")
  @ResponseBody
  public String checkConnection() {
    return "Welcome to the movie app!";
  }

  @GetMapping("/getFirst")
  @ResponseBody
  public String getFirstMovie() {
    return render("First movie", MOVIE_SERVICE.getFirstMovies(1));
  }

  @GetMapping("/getRandom")
  @ResponseBody
  public String getRandom() {
    return render("Get a random movie", MOVIE_SERVICE.getRandomMovies(1));
  }

  @GetMapping("/getTenSortByPopularity")
  @ResponseBody
  public String getTopTen() {
    int amount = 10;

    return render("Top " + amount + " movies by popularity", MOVIE_SERVICE.getTopMovies(amount));
  }

  @GetMapping("/howManyWonAnAward")
  @ResponseBody
  public String getAwardsCount() {
    return render("How many won an award", String.valueOf(MOVIE_SERVICE.getWonAwardMovies()));
  }

  @GetMapping("/comedy")
  @ResponseBody
  public String getListComedyAwards() {
    return render("Comedy", MOVIE_SERVICE.getComedyAwardsMovies());
  }

  private String render(String heading, String body) {
    return "<h1>" + heading + "</h1>" + body;
  }
}

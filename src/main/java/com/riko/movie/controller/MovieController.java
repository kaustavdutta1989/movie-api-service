package com.riko.movie.controller;

import com.riko.movie.model.Movie;
import com.riko.movie.model.dto.MovieMinDTO;
import com.riko.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody MovieMinDTO movieMinDTO) {
        return ResponseEntity.ok(movieService.createMovie(movieMinDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovieByLanguageGenre(@RequestParam(required = false) String keyword,
                                                               @RequestParam(required = false) Long genreId,
                                                           @RequestParam(required = false) Long languageId) {
        return ResponseEntity.ok(movieService.searchMovieByLanguageGenre(
                keyword,
                genreId,
                languageId));
    }
}

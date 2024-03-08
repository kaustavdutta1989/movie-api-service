package com.riko.movie.controller;

import com.riko.movie.model.Genre;
import com.riko.movie.model.dto.GenreMinDTO;
import com.riko.movie.repo.GenreRepository;
import com.riko.movie.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/genre")
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    public ResponseEntity<List<Genre>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());
    }

    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody GenreMinDTO genreMinDTO) {
        return ResponseEntity.ok(genreService.createGenre(genreMinDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Long id) {
        return ResponseEntity.ok(genreService.getGenreById(id));
    }
}

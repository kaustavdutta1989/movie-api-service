package com.riko.movie.controller;

import com.riko.movie.model.Language;
import com.riko.movie.model.dto.LanguageMinDTO;
import com.riko.movie.repo.LanguageRepository;
import com.riko.movie.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/language")
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping
    public ResponseEntity<List<Language>> getAllLanguages() {
        return ResponseEntity.ok(languageService.getAllLanguages());
    }

    @PostMapping
    public ResponseEntity<Language> createLanguage(@RequestBody LanguageMinDTO languageMinDTO) {
        return ResponseEntity.ok(languageService.createLanguage(languageMinDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable Long id) {
        return ResponseEntity.ok(languageService.getLanguageById(id));
    }
}

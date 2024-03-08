package com.riko.movie.service;

import com.riko.movie.model.Language;
import com.riko.movie.model.dto.LanguageMinDTO;

import java.util.List;

public interface LanguageService {
    List<Language> getAllLanguages();
    Language createLanguage(LanguageMinDTO languageMinDTO);
    Language getLanguageById(Long id);
}

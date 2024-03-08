package com.riko.movie.service.implementation;

import com.riko.movie.model.Language;
import com.riko.movie.model.dto.LanguageMinDTO;
import com.riko.movie.repo.LanguageRepository;
import com.riko.movie.service.LanguageService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Override
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    @Override
    public Language createLanguage(LanguageMinDTO languageMinDTO) {
        return languageRepository.save(Language.builder()
                .name(languageMinDTO.getName())
                .build());
    }

    @Override
    public Language getLanguageById(Long id) {
        return languageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("language not found with id: " + id));
    }
}

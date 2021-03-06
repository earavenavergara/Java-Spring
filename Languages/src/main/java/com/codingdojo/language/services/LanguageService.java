package com.codingdojo.language.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.codingdojo.language.models.Language;
import com.codingdojo.language.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}

	public Language createLanguage(Language language) {
		return languageRepository.save(language);
	}

	public Language findLanguage(long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}

	public Language updateLanguage(@Valid Language language) {
		return updateLanguage(language.getId(), language.getName(), language.getCreator(),
				language.getCurrentVersion());
	}

	private Language updateLanguage(Long id, String name, String creator, String currentVersion) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			optionalLanguage.get().setName(name);
			optionalLanguage.get().setCreator(creator);
			optionalLanguage.get().setCurrentVersion(currentVersion);
			languageRepository.save(optionalLanguage.get());
			return optionalLanguage.get();
		}
		return null;
	}

	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}

}

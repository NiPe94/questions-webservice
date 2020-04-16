package io.swagger.service;

import io.swagger.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAll();
    Question findById(Long id);
    List<Question> findByTags(List<String> tags);
    boolean deleteById(Long id);
}

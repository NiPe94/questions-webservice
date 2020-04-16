package io.swagger.service;

import io.swagger.model.Question;
import io.swagger.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> findAll() {
        List<Question> questions = new ArrayList<>();
        questionRepository.findAll().forEach(questions::add);
        return questions;
    }

    @Override
    public Question findById(Long id) {
        return questionRepository.findOne(id);
    }

    @Override
    public List<Question> findByTags(List<String> tags) {
        List<Question> questions = new ArrayList<>();
        questionRepository.findByTagsIn(tags).forEach(questions::add);
        return questions;
    }

    @Override
    public boolean deleteById(Long id) {
        if(questionRepository.exists(id)){
            questionRepository.delete(id);
            return true;
        }
        return false;
    }
}

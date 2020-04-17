package io.swagger.controller;

import io.swagger.model.Question;
import io.swagger.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class QuestionsApiControllerTest {

    @InjectMocks
    QuestionsApiController controller;

    @Mock
    QuestionService service;

    @Mock
    HttpServletRequest request;

    @Test
    public void deleteQuestionByID() {
        when(service.deleteById(1L)).thenReturn(true);
        when(request.getHeader("Accept")).thenReturn("application/json");

        ResponseEntity<Void> result = controller.deleteQuestionByID(1L);
        assertEquals(result.getStatusCode(), HttpStatus.OK);
        verify(service,times(1)).deleteById(any());
    }

    @Test
    public void deleteNotFoundQuestionByID(){
        when(service.deleteById(1L)).thenReturn(false);
        when(request.getHeader("Accept")).thenReturn("application/json");

        ResponseEntity<Void> result = controller.deleteQuestionByID(1L);
        assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
        verify(service,times(1)).deleteById(any());
    }

    @Test
    public void findQuestionById() {
        Question q = new Question();
        q.setId(1L);

        when(service.findById(1L)).thenReturn(q);
        when(request.getHeader("Accept")).thenReturn("application/json");

        ResponseEntity<Question> result = controller.findQuestionById(1L);

        assertEquals(result.getStatusCode(), HttpStatus.OK);
        verify(service,times(1)).findById(any());
    }

    @Test
    public void findNoQuestionById(){
        when(service.findById(1L)).thenReturn(null);
        when(request.getHeader("Accept")).thenReturn("application/json");

        ResponseEntity<Question> result = controller.findQuestionById(1L);

        assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
        verify(service,Mockito.times(1)).findById(any());
    }

    @Test
    public void findQuestions() {
        List<Question> questions = new ArrayList<>();
        Question question = new Question();
        question.setId(1L);
        questions.add(question);

        when(service.findAll()).thenReturn(questions);
        when(request.getHeader("Accept")).thenReturn("application/json");

        ResponseEntity<List<Question>> result = controller.findQuestions(null);

        assertEquals(result.getStatusCode(), HttpStatus.OK);
        verify(service,times(1)).findAll();
    }
}
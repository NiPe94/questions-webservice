package io.swagger.service;

import io.swagger.model.Question;
import io.swagger.repository.QuestionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceImplTest {

    @InjectMocks
    QuestionServiceImpl questionService;

    @Mock
    QuestionRepository repository;

    List<Question> testList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        Question question1 = new Question();
        question1.setId(1L);
        List<String> tags1 = new ArrayList<>();
        tags1.add("Spring");
        tags1.add("Java");
        question1.setTags(tags1);

        Question question2 = new Question();
        question2.setId(2L);
        List<String> tags2 = new ArrayList<>();
        tags2.add("Spring");
        tags2.add("Kotlin");
        question2.setTags(tags2);

        testList.add(question1);
        testList.add(question2);
    }

    @Test
    public void findAll() {
        // when
        when(repository.findAll()).thenReturn(testList);

        // then
        List<Question> result = questionService.findAll();
        assertEquals(result.size(),2);
        verify(repository,times(1)).findAll();
    }

    @Test
    public void findById() {
        when(repository.findOne(1L)).thenReturn(testList.get(0));

        Question firstQ = questionService.findById(1L);
        assertEquals(firstQ.getId().longValue(),1L);
        verify(repository,times(1)).findOne(1L);
    }

    @Test
    public void findByTags() {

        List<String> tags = new ArrayList<>();
        tags.add("Kotlin");
        tags.add("Java");

        when(repository.findByTagsIn(Arrays.asList(tags.get(0)))).thenReturn(testList.subList(1,2));
        when(repository.findByTagsIn(Arrays.asList(tags.get(1)))).thenReturn(testList.subList(0,1));

        List<Question> result = questionService.findByTags(tags);
        assertEquals(result.size(),2);
        verify(repository,times(2)).findByTagsIn(any());
    }

    @Test
    public void deleteById() {
        when(repository.exists(1L)).thenReturn(true);

        questionService.deleteById(1L);

        verify(repository,times(1)).delete(1L);
    }
}
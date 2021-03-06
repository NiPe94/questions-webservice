package io.swagger.model;

import org.junit.Before;
import org.junit.Test;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionTest {

    Question question;

    @Before
    public void setUp() {
        question = new Question();
    }

    @Test
    public void getId() {
        Long idValue = 1L;
        question.setId(idValue);
        assertEquals(question.getId(), idValue);
    }

    @Test
    public void getTags() {
        List<String> tags = new ArrayList<>();
        tags.add("python");
        question.setTags(tags);
        assertEquals(question.getTags().get(0), tags.get(0));
    }

    @Test
    public void isIsAnswered() {
        Boolean answered = true;
        question.setIsAnswered(answered);
        assertEquals(question.isIsAnswered(), answered);
    }

    @Test
    public void getViewCount() {
        Long count = 100L;
        question.setViewCount(count);
        assertEquals(question.getViewCount(), count);
    }

    @Test
    public void getAnswerCount() {
        Long count = 100L;
        question.setAnswerCount(count);
        assertEquals(question.getAnswerCount(), count);
    }

    @Test
    public void getCreationDate() {
        OffsetDateTime time = OffsetDateTime.now();
        question.setCreationDate(time);
        assertEquals(question.getCreationDate(), time);
    }

    @Test
    public void getUserId() {
        Long id = 1L;
        question.setUserId(id);
        assertEquals(question.getUserId(), id);
    }

    @Test
    public void equalQuestions(){
        Long qId = 1L;
        Long uId = 2L;
        OffsetDateTime time = OffsetDateTime.now();
        Long aCount = 10L;
        Long vCount = 100L;
        Boolean answered = true;
        List<String> tags = new ArrayList<>();
        tags.add("python");

        question.setUserId(uId);
        question.setCreationDate(time);
        question.setAnswerCount(aCount);
        question.setViewCount(vCount);
        question.setIsAnswered(answered);
        question.setTags(tags);
        question.setId(qId);

        Question other = new Question();
        other.setUserId(uId);
        other.setCreationDate(time);
        other.setAnswerCount(aCount);
        other.setViewCount(vCount);
        other.setIsAnswered(answered);
        other.setTags(tags);
        other.setId(qId);

        assertTrue(question.equals(other));
        assertTrue(question.toString().equals(other.toString()));

    }
}
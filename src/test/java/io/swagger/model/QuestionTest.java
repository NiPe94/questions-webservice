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
}
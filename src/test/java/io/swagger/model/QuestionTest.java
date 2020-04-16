package io.swagger.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    Question question;

    @BeforeEach
    void setUp() {
        question = new Question();
    }

    @Test
    void getId() {
        Long idValue = 1L;
        question.setId(idValue);
        assertEquals(question.getId(), idValue);
    }

    @Test
    void getTags() {
        List<String> tags = new ArrayList<>();
        tags.add("python");
        question.setTags(tags);
        assertEquals(question.getTags().get(0), tags.get(0));
    }

    @Test
    void isIsAnswered() {
        Boolean answered = true;
        question.setIsAnswered(answered);
        assertEquals(question.isIsAnswered(), answered);
    }

    @Test
    void getViewCount() {
        Long count = 100L;
        question.setViewCount(count);
        assertEquals(question.getViewCount(), count);
    }

    @Test
    void getAnswerCount() {
        Long count = 100L;
        question.setAnswerCount(count);
        assertEquals(question.getAnswerCount(), count);
    }

    @Test
    void getCreationDate() {
        OffsetDateTime time = OffsetDateTime.now();
        question.setCreationDate(time);
        assertEquals(question.getCreationDate(), time);
    }

    @Test
    void getUserId() {
        Long id = 1L;
        question.setUserId(id);
        assertEquals(question.getUserId(), id);
    }
}
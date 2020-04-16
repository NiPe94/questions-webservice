package io.swagger.controller;

import io.swagger.api.QuestionsApi;
import io.swagger.model.Question;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-16T09:21:50.059Z[GMT]")
@Controller
public class QuestionsApiController implements QuestionsApi {

    private static final Logger log = LoggerFactory.getLogger(QuestionsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public QuestionsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> deleteQuestionByID(@ApiParam(value = "ID of question to delete",required=true) @PathVariable("id") Long id
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Question> findQuestionById(@ApiParam(value = "ID of question to fetch",required=true) @PathVariable("id") Long id
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Question>(objectMapper.readValue("{\n  \"user_id\" : 5,\n  \"id\" : 0,\n  \"is_answered\" : false,\n  \"creation_date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"answer_count\" : 1,\n  \"view_count\" : 6,\n  \"tags\" : [ \"tags\", \"tags\" ]\n}", Question.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Question>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Question>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Question>> findQuestions(@ApiParam(value = "tags to filter by") @Valid @RequestParam(value = "tags", required = false) List<String> tags
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Question>>(objectMapper.readValue("[ {\n  \"user_id\" : 5,\n  \"id\" : 0,\n  \"is_answered\" : false,\n  \"creation_date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"answer_count\" : 1,\n  \"view_count\" : 6,\n  \"tags\" : [ \"tags\", \"tags\" ]\n}, {\n  \"user_id\" : 5,\n  \"id\" : 0,\n  \"is_answered\" : false,\n  \"creation_date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"answer_count\" : 1,\n  \"view_count\" : 6,\n  \"tags\" : [ \"tags\", \"tags\" ]\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Question>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Question>>(HttpStatus.NOT_IMPLEMENTED);
    }

}

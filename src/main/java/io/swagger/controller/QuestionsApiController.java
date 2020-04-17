package io.swagger.controller;

import io.swagger.api.QuestionsApi;
import io.swagger.model.Question;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.service.QuestionService;
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
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-01T09:02:01.928Z[GMT]")
@Controller
public class QuestionsApiController implements QuestionsApi {

    private static final Logger log = LoggerFactory.getLogger(QuestionsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final QuestionService questionService;

    @org.springframework.beans.factory.annotation.Autowired
    public QuestionsApiController(ObjectMapper objectMapper, HttpServletRequest request, QuestionService questionService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.questionService = questionService;
    }

    public ResponseEntity<Void> deleteQuestionByID(@ApiParam(value = "ID of question to delete",required=true) @PathVariable("id") Long id
    ) {
        if(questionService.deleteById(id)){
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<Question> findQuestionById(@ApiParam(value = "ID of question to fetch",required=true) @PathVariable("id") Long id
    ) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {

            Question question = questionService.findById(id);

            if(question == null){
                return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Question>(question, HttpStatus.OK);
            //return new ResponseEntity<Question>(objectMapper.readValue("{\n  \"user_id\" : 5,\n  \"id\" : 0,\n  \"is_answered\" : false,\n  \"creation_date\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"answer_count\" : 1,\n  \"view_count\" : 6,\n  \"tags\" : [ \"tags\", \"tags\" ]\n}", Question.class), HttpStatus.NOT_IMPLEMENTED);

        }

        return new ResponseEntity<Question>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Question>> findQuestions(@ApiParam(value = "tags to filter by") @Valid @RequestParam(value = "tags", required = false) List<String> tags
    ) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Question> questions = new ArrayList<>();
            if(tags==null || tags.isEmpty()){
                questions = questionService.findAll();
            }else{
                questions = questionService.findByTags(tags);
            }
            return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
        }

        return new ResponseEntity<List<Question>>(HttpStatus.NOT_IMPLEMENTED);
    }

}

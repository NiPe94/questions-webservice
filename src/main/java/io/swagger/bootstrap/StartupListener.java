package io.swagger.bootstrap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.Question;
import io.swagger.repository.QuestionRepository;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.threeten.bp.Instant;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;
import java.util.List;

@Component
@Transactional
public class StartupListener implements CommandLineRunner {

    private final QuestionRepository questionRepository;

    private static final String url = "https://api.stackexchange.com/2.2/questions/featured?pagesize=20&order=desc&sort=creation&site=stackoverflow&filter=!FcbKgRCyQ35oXbtvZuF)K0e_au";

    @Autowired
    public StartupListener(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
                HttpClientBuilder.create().build());
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);

        String jsonString = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode arrNode = mapper.readTree(jsonString).get("items");
        if (arrNode.isArray()) {
            for (final JsonNode objNode : arrNode) {
                Question question = new Question();
                question.setId(objNode.get("question_id").asLong());
                question.setAnswerCount(objNode.get("answer_count").asLong());
                question.setIsAnswered(objNode.get("is_answered").asBoolean());
                question.setUserId(objNode.get("owner").get("user_id").asLong());
                question.setViewCount(objNode.get("view_count").asLong());

                List<String> tags = mapper.readerFor(new TypeReference<List<String>>() {}).readValue(objNode.get("tags"));
                question.setTags(tags);

                Long datetimeString = objNode.get("creation_date").asLong();
                OffsetDateTime dateTime = OffsetDateTime.ofInstant(Instant.ofEpochSecond(datetimeString), ZoneId.systemDefault());
                question.setCreationDate(dateTime);
                questionRepository.save(question);
            }
        }
    }
}


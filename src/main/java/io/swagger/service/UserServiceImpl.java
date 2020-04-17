package io.swagger.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.User;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.threeten.bp.Instant;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findById(Long id) {

        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
                HttpClientBuilder.create().build());
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);

        String url = "https://api.stackexchange.com/2.2/users/"+id.toString()+"?order=desc&sort=reputation&site=stackoverflow&filter=!)RwcIFaJOsXOskDB-aDz8upi";

        String jsonString = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode userNode = null;
        try {
            JsonNode root = mapper.readTree(jsonString).get("items");
            if(root.size()==0){
                return null;
            }
            userNode = root.get(0);
        } catch (IOException e) {
            return null;
        }

        User user = new User();
        user.setUserId(userNode.get("user_id").asLong());
        user.setDisplayName(userNode.get("display_name").toString());

        Long datetimeString = userNode.get("creation_date").asLong();
        OffsetDateTime dateTime = OffsetDateTime.ofInstant(Instant.ofEpochSecond(datetimeString), ZoneId.systemDefault());
        user.setCreationDate(dateTime);
        return user;
    }
}

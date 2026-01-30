package org.hj77.crmbusinesshub.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class HubService {

    private final RestTemplate restTemplate;
    @Value("${service.dm-url}")
    private String DM_URL;

    public HubService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getClient(String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", id);

        HttpEntity<Object> emptyEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(DM_URL, emptyEntity, String.class);

        return response.getBody();
    }

    public String findClient(){
        return "";
    }

    public String level(){
        return "";
    }

    public String lastOperations() {
        return "";
    }

    public String saveClient() {
        return "";
    }

    public String loanPayment() {
        return "";
    }
}
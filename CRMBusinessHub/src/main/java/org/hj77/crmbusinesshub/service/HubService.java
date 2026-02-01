package org.hj77.crmbusinesshub.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Service
public class HubService {

    private final RestTemplate restTemplate;
    private final KafkaSenderService kafkaSenderService;

    @Value("${service.dm-url}")
    private String DM_URL;

    public HubService(RestTemplate restTemplate, KafkaSenderService kafkaSenderService) {
        this.restTemplate = restTemplate;
        this.kafkaSenderService = kafkaSenderService;
    }

    public String getClient(String id){
        log.info("Start getClient. id = {}", id);
        kafkaSenderService.send("data-guardian", "test");
        return "";
    }

    public String findClient(){
        log.info("Start findClient.");
        /*HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", id);

        HttpEntity<Object> emptyEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(DM_URL, emptyEntity, String.class);

        return response.getBody();*/
        return "";
    }

    public String level(){
        log.info("Start level().");
        return "";
    }

    public String lastOperations() {
        log.info("Start lastOperations().");
        return "";
    }

    public String saveClient() {
        log.info("Start saveClient().");
        return "";
    }

    public String loanPayment() {
        log.info("Start loanPayment().");
        return "";
    }
}
package org.hj77.crmbusinesshub.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class HubService {

    private final RestTemplate restTemplate;

    public HubService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getClient(){
        throw new HttpClientErrorException(HttpStatusCode.valueOf(401),"какая-то ошибка");
        //return "";
    }

    public String findClient(){
        return "";
    }

    public String level(){
        return "";
    }

}
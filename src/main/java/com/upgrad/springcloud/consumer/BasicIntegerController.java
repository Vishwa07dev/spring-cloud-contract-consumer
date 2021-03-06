package com.upgrad.springcloud.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class BasicIntegerController {


  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/identify")
  public String checkInteger(@RequestParam("number") String number) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Content-Type", "application/json");

    ResponseEntity<String> responseEntity = restTemplate.exchange(
        "http://localhost:8090/validate/integer?number=" + number,
        HttpMethod.GET,
        new HttpEntity<>(httpHeaders),
        String.class);

    return responseEntity.getBody();
  }
}

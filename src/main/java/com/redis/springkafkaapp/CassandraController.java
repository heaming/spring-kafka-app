package com.redis.springkafkaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CassandraController {

    @Autowired
    CassandraService cassandraService;

    @GetMapping("/cas-test")
    public void cassandraTest() {
        cassandraService.casTest();
    }
}

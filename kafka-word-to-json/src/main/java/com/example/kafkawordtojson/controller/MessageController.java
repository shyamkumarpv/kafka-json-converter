package com.example.kafkawordtojson.controller;

import com.example.kafkawordtojson.service.ProducerKafkaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1")
public class MessageController {
    private ProducerKafkaService producerKafkaService;

    public MessageController(ProducerKafkaService producerKafkaService) {
        this.producerKafkaService = producerKafkaService;
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        producerKafkaService.upload(file);
        return "File upload successfully";
    }
}

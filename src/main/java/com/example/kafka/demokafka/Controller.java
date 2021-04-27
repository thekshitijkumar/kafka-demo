package com.example.kafka.demokafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Logger logger = LoggerFactory.getLogger(Controller.class);
    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;//kfaka template key to value
    @Value("${application.topic}")
    String topic;

    @PostMapping("/produce")
    public void produceMessage(@RequestParam("msg") String msg)
    {
    kafkaTemplate.send(topic,msg);    //overloaded function String ->topic and message or Topic msg and key(partition)
    logger.info("produced msg {} on topic {}", msg, topic);

    }


    @KafkaListener(topics = {"test_topic"})
    public void consumeMessage(String msg)
    {
        logger.info("consumed message {}",msg);
    }

}

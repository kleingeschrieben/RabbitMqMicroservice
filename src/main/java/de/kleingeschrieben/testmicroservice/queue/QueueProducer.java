package de.kleingeschrieben.testmicroservice.queue;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QueueProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.queue.response}")
    private String responseQueue;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(responseQueue, message);
    }
}

package de.kleingeschrieben.testmicroservice.queue;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class QueueListener implements MessageListener {
    @Override
    public void onMessage(Message message) {

    }
}

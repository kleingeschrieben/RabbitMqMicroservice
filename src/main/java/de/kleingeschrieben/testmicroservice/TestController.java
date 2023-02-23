package de.kleingeschrieben.testmicroservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.kleingeschrieben.testmicroservice.entitys.PingPlayer;
import de.kleingeschrieben.testmicroservice.entitys.Response;
import de.kleingeschrieben.testmicroservice.queue.QueueProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class TestController {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private QueueProducer queueProducer;

    @Autowired
    private MessageSerializer messageSerializer;

    @RequestMapping(value="/ping/{uuid}")
    public @ResponseBody Response pingPlayer(@PathVariable(value="uuid") String uuid) {
        // TODO SOME LOGIK!
        try {
            PingPlayer pingPlayer = new PingPlayer();
            pingPlayer.setPlayerUuid(uuid);
            pingPlayer.setIndicator("PING_PLAYER");
            pingPlayer.setMessage("Pong!");
            queueProducer.sendMessage(messageSerializer.serializeObject(pingPlayer));
            return new Response(true, "");
        } catch (IOException e) {
            return new Response(false, e.getMessage());
        }
    }
}

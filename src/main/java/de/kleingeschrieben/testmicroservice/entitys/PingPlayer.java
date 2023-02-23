package de.kleingeschrieben.testmicroservice.entitys;

import lombok.Data;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;

@Data
public class PingPlayer extends PluginMessage implements Serializable {
    @Serial
    private static final long serialVersionUID = 8582433437601788991L;
    private String message;
}

package de.kleingeschrieben.testmicroservice.entitys;

import lombok.Data;

import java.io.Serializable;

@Data
public class PluginMessage implements Serializable {
    private String playerUuid;
    private String indicator;
}

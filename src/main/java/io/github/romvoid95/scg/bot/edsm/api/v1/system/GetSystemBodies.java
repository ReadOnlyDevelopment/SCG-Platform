package io.github.romvoid95.scg.bot.edsm.api.v1.system;

import java.util.List;

import io.github.romvoid95.scg.bot.edsm.api.v1.system.modal.Body;
import lombok.Getter;

@Getter
public class GetSystemBodies
{
    private int id;
    private long id64;
    private String url;
    private int bodyCount;
    private List<Body<?>> bodies;
}

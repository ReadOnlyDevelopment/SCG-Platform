package io.github.romvoid95.scg.server;

import static spark.Spark.get;
import static spark.Spark.init;
import static spark.Spark.port;
import static spark.Spark.post;

import io.github.romvoid95.scg.server.modal.CarrierJumpRequest;
import io.github.romvoid95.scg.util.GsonUtil;
import lombok.AllArgsConstructor;

public class EventServer
{
    public EventServer()
    {
        port(9050);
        init();
        
        post("/tick", (request, response) -> {
            System.out.println(request.host());
            System.out.println(GsonUtil.TO_STRING.toJson(request.body()));
            response.status(200);
            return GsonUtil.API_GSON.toJsonTree(new Response("successful"));
        });

        post("/carrier", (request, response) -> {
            EventHandler.post(new CarrierJumpRequest(request.body()));
            response.status(200);
            return GsonUtil.API_GSON.toJsonTree(new Response("successful"));
        });
        
        get("/callback", (request, response) -> {
            System.out.println(request.queryString());
            return null;
        });
    }
    
    @AllArgsConstructor
    class Response {
        public String response;
    }
}

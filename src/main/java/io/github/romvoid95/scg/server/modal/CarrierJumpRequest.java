package io.github.romvoid95.scg.server.modal;



import io.github.romvoid95.scg.util.GsonUtil;

public class CarrierJumpRequest
{
    private final JumpRequest request;
    
    public CarrierJumpRequest(String body)
    {
        this.request = GsonUtil.API_GSON.fromJson(body, JumpRequest.class);
    }

    public String getCarrierCallsign()
    {
        return request.station;
    }
    
    public long getCarrierId()
    {
        return request.data.carrierID;
    }
    
    public String getDepartureSystem()
    {
        return request.system;
    }

    public String getTarget()
    {
        return request.data.body;
    }

    public String getDepartureTime()
    {
        return request.data.departureTime;
    }
}

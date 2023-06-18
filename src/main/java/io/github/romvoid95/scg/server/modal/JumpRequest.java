package io.github.romvoid95.scg.server.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JumpRequest
{
    public String cmdr;
    public String system;
    public String station;
    public Data data;

    public class Data {

        @SerializedName("timestamp")
        @Expose
        public String timestamp;
        @SerializedName("event")
        @Expose
        public String event;
        @SerializedName("CarrierID")
        @Expose
        public long carrierID;
        @SerializedName("SystemName")
        @Expose
        public String systemName;
        @SerializedName("Body")
        @Expose
        public String body;
        @SerializedName("SystemAddress")
        @Expose
        public long systemAddress;
        @SerializedName("BodyID")
        @Expose
        public long bodyID;
        @SerializedName("DepartureTime")
        @Expose
        public String departureTime;
    }
}

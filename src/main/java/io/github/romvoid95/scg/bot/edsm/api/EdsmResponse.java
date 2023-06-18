package io.github.romvoid95.scg.bot.edsm.api;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EdsmResponse
{
    @SerializedName("msgnum")
    public int messageNumber;
    
    @SerializedName("msg")
    public String message;
}

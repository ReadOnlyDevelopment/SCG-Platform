package io.github.romvoid95.scg.util;

import java.io.IOException;
import java.time.Duration;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

public class OkHttpUtil
{
    private static final long     DEFAULT_TIMEOUT_MILLIS = 2000L;
    private static final Duration DEFAULT_TIMEOUT        = Duration.ofMillis(DEFAULT_TIMEOUT_MILLIS);

    private static OkHttpClient client = new OkHttpClient.Builder().connectTimeout(DEFAULT_TIMEOUT).readTimeout(DEFAULT_TIMEOUT).writeTimeout(DEFAULT_TIMEOUT).build();

    public static OkHttpClient getClient() {
        return client;
    }
    
    public static String read(HttpUrl url)
    {
        final Request request = new Request.Builder().url(url).build();
        try (ResponseBody responseBody = client.newCall(request).execute().body())
        {
            if (responseBody == null)
            {
                return "";
            }
            return responseBody.string();
        } catch (IOException e)
        {
            return "";
        }
    }
}

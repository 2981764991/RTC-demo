package com.hj.rtc;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private static final OkHttpClient client = new OkHttpClient();

    @Test
    public void addition_isCorrect() throws IOException {
        Request request = new Request.Builder()
                .url("http://8.146.211.151:8080/rtcToken?channelName="+"julys")
                .build();

        Response response = client.newCall(request).execute();


//        System.out.println(response.body().string());
        ResponseBody body = response.body();
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Object>>() {
        }.getType();
        Map<String,Object> map = gson.fromJson(body.charStream(), type);
        String key = (String) map.get("key");
        System.out.println(key);
    }
}
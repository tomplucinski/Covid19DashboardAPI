package com.project.covid19dashboard.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class HttpHelper {

    private final OkHttpClient httpClient = new OkHttpClient();

    public Response get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .build();

        return httpClient.newCall(request).execute();
    }
}

package com.project.covid19dashboard.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import okhttp3.Response;

@RestController
@RequestMapping("/api")
public class CovidController {

    private HttpHelper httpHelper = new HttpHelper();

    @GetMapping
    public String getAllCountryData() throws IOException {
        Response response = httpHelper.get("http://corona-api.com/countries");

        return response.body().string();
    }
}

package com.project.covid19dashboard.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import okhttp3.Response;

@RestController
@RequestMapping("/api")
public class ApiController {

    private HttpHelper httpHelper = new HttpHelper();
    private String baseURL = "http://corona-api.com/";

    @GetMapping("/countries")
    public ResponseEntity getAllCountryData() throws IOException {
        Response response = httpHelper.get(this.baseURL + "countries");

        return ResponseEntity.ok(response.body().string());
    }

    @GetMapping("/countries/{country}")
    public ResponseEntity getCountryData(@PathVariable String country) throws IOException {
        Response response = httpHelper.get(String.format("%s%s", this.baseURL + "countries/", country));

        return ResponseEntity.ok(response.body().string());
    }
}

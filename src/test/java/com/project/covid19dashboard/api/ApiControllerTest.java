package com.project.covid19dashboard.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllCountryDataTest() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(
                get("/api/countries")
        )
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void getCountryDataTest() throws Exception {
        String country = "us";

        MvcResult mvcResult = this.mockMvc.perform(
                get(String.format("%s%s", "/api/countries/", country))
        )
                .andExpect(status().isOk())
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(response);
        String countryName = jsonNode.findValuesAsText("name").get(0);

        assertEquals(200, mvcResult.getResponse().getStatus());
        assertEquals("USA", countryName);
    }

}

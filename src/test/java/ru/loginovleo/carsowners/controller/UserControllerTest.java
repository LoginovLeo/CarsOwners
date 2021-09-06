package ru.loginovleo.carsowners.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.loginovleo.carsowners.json.JsonUtil;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.loginovleo.carsowners.TestData.USER;


public class UserControllerTest extends AbstractControllerTest {

    private final String REST_URL = "/users/";

    @Test
    public void get() throws Exception {
        perform(MockMvcRequestBuilders
                .get(REST_URL + USER.getId()))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(JsonUtil.writeIgnoreProps(USER, "registered", "garages")));
    }

    @Test
    public void getAll() throws Exception {
        perform(MockMvcRequestBuilders
                .get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getWithGarage() throws Exception {
        perform(MockMvcRequestBuilders
                .get(REST_URL + USER.getId() + "/garage"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(JsonUtil.writeIgnoreProps(USER, "registered")));

    }

    @Test
    public void delete() throws Exception {
        perform(MockMvcRequestBuilders
                .delete(REST_URL + USER.getId()))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
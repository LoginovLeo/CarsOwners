package ru.loginovleo.carsowners.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.loginovleo.carsowners.json.JsonUtil;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.loginovleo.carsowners.TestData.*;

class GarageControllerTest extends AbstractControllerTest {
    private final String REST_URL = "/garage/";

    @Test
    void getById() throws Exception {
        perform(MockMvcRequestBuilders
                .get(REST_URL + GARAGEWITHOUTCARS1.getId()))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(JsonUtil.writeIgnoreProps(GARAGEWITHOUTCARS1, "cars", "user_id")));
    }

    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders
                .get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void delete() throws Exception {
        perform(MockMvcRequestBuilders
                .delete(REST_URL + GARAGEWITHOUTCARS1.getId()))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    void getWithAutomobile() throws Exception {
        perform(MockMvcRequestBuilders
                .get(REST_URL + GARAGEWITHOUTCARS1.getId() + "/automobile"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(JsonUtil.writeIgnoreProps(GARAGEWITHOUTCARS1, "user_id")));
    }
}
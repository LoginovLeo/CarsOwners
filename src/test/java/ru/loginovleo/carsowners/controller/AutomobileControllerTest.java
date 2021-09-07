package ru.loginovleo.carsowners.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.loginovleo.carsowners.json.JsonUtil;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.loginovleo.carsowners.TestData.AUTOMOBILE1;

class AutomobileControllerTest extends AbstractControllerTest {
    private final String REST_URL = "/automobile/";

    @Test
    void getById() throws Exception {
        perform(MockMvcRequestBuilders
                .get(REST_URL + AUTOMOBILE1.getId()))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(JsonUtil.writeValue(AUTOMOBILE1)));
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
    void deleteById() throws Exception {
        perform(MockMvcRequestBuilders
                .delete(REST_URL + AUTOMOBILE1.getId()))
                .andDo(print())
                .andExpect(status().isNoContent());

    }
}
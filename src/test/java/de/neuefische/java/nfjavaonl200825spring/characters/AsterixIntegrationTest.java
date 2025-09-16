package de.neuefische.java.nfjavaonl200825spring.characters;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AsterixIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    AsterixRepository asterixRepository;

    @Test
    void getAllCharacter() throws Exception {
        //GIVEN
        asterixRepository.save(new AsterixCharacter("1", "test-name", 5, "test-profession"));

        //WHEN
        mockMvc.perform(get("/api/asterix/characters"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                          {
                            "id": "1",
                            "name": "test-name",
                            "age": 5,
                            "profession": "test-profession"
                          }
                        ]
                        """));
//                .andExpect(jsonPath("$.id").isString());
//                .andExpect(jsonPath("$.length()").value(3));

        //THEN

    }
}

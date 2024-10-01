package com.example.translate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TranslateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testTranslateToSpanish() throws Exception {
        mockMvc.perform(get("/translate")
                        .param("texto", "Hello")
                        .param("idioma", "es"))
                .andExpect(status().isOk())
                .andExpect(content().string("Traducción al español: Hello"));
    }

    @Test
    public void testTranslateToEnglish() throws Exception {
        mockMvc.perform(get("/translate")
                        .param("texto", "Hola")
                        .param("idioma", "en"))
                .andExpect(status().isOk())
                .andExpect(content().string("Translation to English: Hola"));
    }

    @Test
    public void testUnsupportedLanguage() throws Exception {
        mockMvc.perform(get("/translate")
                        .param("texto", "Bonjour")
                        .param("idioma", "fr"))
                .andExpect(status().isOk())
                .andExpect(content().string("Idioma no soportado."));
    }
}

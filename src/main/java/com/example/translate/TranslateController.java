package com.example.translate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslateController {

    @GetMapping("/translate")
    public String traducirTexto(@RequestParam String texto, @RequestParam String idioma) {
        if ("es".equals(idioma)) {
            return "Traducción al español: " + texto;
        } else if ("en".equals(idioma)) {
            return "Translation to English: " + texto;
        } else {
            return "Idioma no soportado.";
        }
    }
}

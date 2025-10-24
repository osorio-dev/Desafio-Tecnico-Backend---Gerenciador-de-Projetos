package br.com.osorio.dev.Gerenciador.de.Projetos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TestController {

    @GetMapping("/123")
    public String test() {
        return "testando o security";
    }
}

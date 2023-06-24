package tads.aranoua.testes.springboottestes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tads.aranoua.testes.springboottestes.model.SituacaoDeSaude;

@RestController
@RequestMapping("/api/situacoesDeSaude")
public class SituacaoDeSaudeController {
    @GetMapping
    public String getSituacaoDeSaude(@RequestParam(required = false) SituacaoDeSaude situacaoDeSaude){
        return situacaoDeSaude.name();
    }
}

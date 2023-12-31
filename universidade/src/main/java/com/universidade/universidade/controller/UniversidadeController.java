package com.universidade.universidade.controller;

import com.universidade.universidade.model.Universidade;
import com.universidade.universidade.model.UniversidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/universidades")
public class UniversidadeController {

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/teste")
    public String testeGet(){
        String url = "http://localhost:8080/universidades/all";
        return restTemplate.getForObject(url, String.class);
    }




    @Autowired
    UniversidadeRepository universidadeRepository;

    @GetMapping("/all")
    public List<Universidade> getAllUniversidade(){
        List<Universidade> universidade = universidadeRepository.findAll();
        return universidade;
    }

    @GetMapping("/{nome}")
    public Universidade getUniversidade(@PathVariable String nome){
        Universidade universidade = new Universidade();
        return universidadeRepository.findByNome(nome);
    }

    @PostMapping("/add")
    public void addUniversidade(@RequestBody Universidade universidade){
        universidadeRepository.save(universidade);
    /*
        {
                "nome":"USP",
                "cnpj":"34572869413563",
                "area":"Medicina",
                "cep": 17595365,
                "site":"https://www5.usp.br"
        }
    */
    }


}

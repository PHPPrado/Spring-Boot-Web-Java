package com.np3.exame.controller;

import com.np3.exame.infra.AlunoRepository;
import com.np3.exame.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/listaAlunos")
    public ModelAndView listarAlunos(@ModelAttribute Aluno aluno){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("lista", alunoRepository.findAll());
        return modelAndView;
    }


}

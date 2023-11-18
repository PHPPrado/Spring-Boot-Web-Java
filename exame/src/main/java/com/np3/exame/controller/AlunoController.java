package com.np3.exame.controller;

import com.np3.exame.infra.AlunoRepository;
import com.np3.exame.infra.CursoRepository;
import com.np3.exame.model.Aluno;
import com.np3.exame.model.Curso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/listaAlunos")
    public ModelAndView listarAlunos(@ModelAttribute Aluno aluno){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("lista", alunoRepository.findAll());
        return modelAndView;
    }

//    @GetMapping("/listaCursos")
//    public ModelAndView listarCursos(@ModelAttribute Curso curso){
//        ModelAndView modelAndView2 = new ModelAndView("index");
//        modelAndView2.addObject("listaCursos", cursoRepository.findAll());
//        return modelAndView2;
//    }

    @PostMapping("/add")
    public String addAluno(@ModelAttribute Aluno aluno){
        alunoRepository.save(aluno);
        return "redirect:/listaAlunos";
    }


}

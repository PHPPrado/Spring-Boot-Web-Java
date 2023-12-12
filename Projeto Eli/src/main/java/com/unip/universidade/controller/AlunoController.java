package com.unip.universidade.controller;

import com.unip.universidade.model.AlunoValidator;
import com.unip.universidade.model.bd.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

//import com.unip.universidade.lixo.AlunoService;
import com.unip.universidade.model.Aluno;
import com.unip.universidade.model.bd.AlunoDAO;

@Controller
@SessionAttributes("listaDeAlunos")
public class AlunoController {
    //private AlunoService alunoService;
    @Autowired
    private AlunoDAO alunoDAO;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    AlunoValidator alunoValidator;

    @RequestMapping("/listaAlunos")
    public ModelAndView listarAlunos(@ModelAttribute("aluno") Aluno aluno) {
        ModelAndView modelAndView = new ModelAndView("alunos");
        modelAndView.addObject("listaDeAlunos", alunoRepository.findAll());
//        testeGetAlunos();
        return modelAndView;
    }

    @RequestMapping("/selecionaAluno")
    public ModelAndView selecionarAlunos(@RequestParam("id") int matricula) {
        System.out.println("buscando o aluno: " + matricula);
        Aluno aluno = alunoRepository.findById(Integer.valueOf(matricula)).get();
        ModelAndView modelAndView = new ModelAndView("alunos");
        modelAndView.addObject("listaDeAlunos", alunoRepository.findAll());
        modelAndView.addObject("aluno", aluno);
        return modelAndView;
    }

    @PostMapping("/salvaAluno")
    public String salvarAluno(@Valid @ModelAttribute("aluno") Aluno aluno, Errors errors) {
        alunoValidator.validate(aluno, errors);

        if(errors.hasErrors())
            return "alunos";

        alunoRepository.save(aluno);
        return "redirect:/listaAlunos";
    }

    @RequestMapping("/removeAluno")
    public String removerAluno(@RequestParam("id") int matricula) {
        alunoRepository.deleteById(Integer.valueOf(matricula));
        return "redirect:/listaAlunos";
    }

    private RestTemplate restTemplate = new RestTemplate();
    public void testeGetAlunos(){
        String url = "http://localhost:8080/listaAlunos";
        System.out.println(restTemplate.getForObject(url, String.class));
    }


}

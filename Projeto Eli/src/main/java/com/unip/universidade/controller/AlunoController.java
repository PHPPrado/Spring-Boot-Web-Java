package com.unip.universidade.controller;

import com.unip.universidade.model.bd.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import com.unip.universidade.lixo.AlunoService;
import com.unip.universidade.model.Aluno;
import com.unip.universidade.model.bd.AlunoDAO;

@Controller
public class AlunoController {
    //private AlunoService alunoService;
    @Autowired
    private AlunoDAO alunoDAO;

    @Autowired
    private AlunoRepository alunoRepository;

    @RequestMapping("/listaAlunos")
    public ModelAndView listarAlunos(@ModelAttribute("aluno") Aluno aluno) {
        ModelAndView modelAndView = new ModelAndView("alunos");
        modelAndView.addObject("listaDeAlunos", alunoRepository.findAll());
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
    public String salvarAluno(@ModelAttribute("aluno") Aluno aluno) {
        alunoRepository.save(aluno);
        return "redirect:/listaAlunos";
    }

    @RequestMapping("/removeAluno")
    public String removerAluno(@RequestParam("id") int matricula) {
        alunoRepository.deleteById(Integer.valueOf(matricula));
        return "redirect:/listaAlunos";
    }

}

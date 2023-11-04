package com.unip.universidade.controller;

import com.unip.universidade.model.Aluno;
import com.unip.universidade.model.Tcc;
import com.unip.universidade.model.bd.AlunoRepository;
import com.unip.universidade.model.bd.TccRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes({"listaAlunos", "listaTcc"})
public class TccController {

    @Autowired
    private TccRepository tccRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/tcc")
    public ModelAndView listaTcc() {
        ModelAndView modelAndView = new ModelAndView("tcc");
        modelAndView.addObject("tcc", new Tcc());
        modelAndView.addObject("listaTcc", tccRepository.findAll());
        modelAndView.addObject("listaAlunos", alunoRepository.findAll());
        return modelAndView;
    }

    @PostMapping("/cadastroTcc")
    @Transactional
    public String cadastro(@Valid @ModelAttribute("tcc") Tcc tcc1, Errors errors){
        if (errors.hasErrors())
            return "tcc";

        Tcc tcc = new Tcc(tcc1.getTitulo(), tcc1.getAno(), tcc1.getSemestre(), tcc1.getAlunosGrupo());

        for (Aluno aluno : tcc.getAlunosGrupo()){
            aluno.setTcc(tcc);
            alunoRepository.save(aluno);
        }
        tccRepository.save(tcc);

        return "redirect:/tcc";
    }

}

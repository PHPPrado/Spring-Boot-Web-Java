package com.unip.universidade.controller;

import com.unip.universidade.model.Tcc;
import com.unip.universidade.model.bd.TccRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TccController {

    @Autowired
    private TccRepository tccRepository;

    @GetMapping("/tcc")
    public ModelAndView listaTcc() {
        ModelAndView modelAndView = new ModelAndView("tcc");
        modelAndView.addObject("tcc", new Tcc());
        modelAndView.addObject("listaTcc", tccRepository.findAll());
        return modelAndView;
    }
}

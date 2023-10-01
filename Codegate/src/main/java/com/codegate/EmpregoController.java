package com.codegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
public class EmpregoController {

	
	@Autowired
	EmpregoRepository empregoRepository;
	
	@RequestMapping("/")
	public String listaEmpregos(Model model) {
		model.addAttribute("empregos", empregoRepository.findAll());
		return "lista";
	}
	
	@GetMapping("/add")
	public String empregoForm(Model model){
		model.addAttribute("emprego", new Emprego());
		return "empregoForm";
	}
	
	@PostMapping("/process")
	//Valid valida os campos de acordo com os atributos da classe, binding result apenas verifica se a erros internos
	public String processForm(@Valid Emprego emprego, BindingResult result){
		if(result.hasErrors()){
			return "empregoForm";
		}
		empregoRepository.save(emprego);
		return "redirect:/";
	}
}


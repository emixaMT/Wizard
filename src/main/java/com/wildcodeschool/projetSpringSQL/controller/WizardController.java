package com.wildcodeschool.projetSpringSQL.controller;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestParam;


import entity.Wizard;
import repository.WizardRepository;

@Controller
public class WizardController {

    private WizardRepository repository = new WizardRepository();

    @GetMapping("/wizards")
    public String getAll(Model model) {
        
    	model.addAttribute("findWizard", new String());
        
        model.addAttribute("wizards", repository.findAll());
        return "wizard_get_all";
    }
    
    @GetMapping("/wizards/search")
    public String getWizardByName(Model model, @RequestParam String query) {
    	
    	List<Wizard> list = repository.findBy("last_name",query);
    	list.addAll(repository.findBy("first_name",query));
    	list.addAll(repository.findBy("id", query));
    	List<Wizard> a = list.stream().distinct().collect(Collectors.toList());
    	model.addAttribute("wizards", a);
    	return "wizard_get_all";
    }

}
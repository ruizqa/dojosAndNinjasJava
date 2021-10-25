package dojosAndNinjas.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dojosAndNinjas.mvc.models.Dojo;
import dojosAndNinjas.mvc.models.Ninja;
import dojosAndNinjas.mvc.services.DojoService;



@Controller
public class DojosController {
	private final DojoService serv;
	 
	 public DojosController(DojoService serv) {
	     this.serv = serv;
	     }

	 
	 @RequestMapping("/dojos/new")
	 public String index(@ModelAttribute("dojo") Dojo dojo,Model model) {
	     List<Dojo> dojos = serv.allDojos();
	     model.addAttribute("dojos", dojos);
	     return "/dojos/new.jsp";

	 }
	 
	 
	 @RequestMapping("/dojos/{id}")
	 public String index(@PathVariable("id") Long id, Model model) {
	     Dojo dojo = serv.findDojo(id);
	     model.addAttribute("dojo", dojo);
	     return "/dojos/show.jsp";

	 }
	 
	 @RequestMapping(value="/dojos", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/dojos/new.jsp";
	     } else {
	         serv.createDojo(dojo);
	         return "redirect:/dojos/new";
	     }
	 }
	 
	 
	 
}

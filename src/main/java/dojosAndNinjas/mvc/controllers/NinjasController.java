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
import dojosAndNinjas.mvc.services.NinjaService;


@Controller
public class NinjasController {
	private final NinjaService serv;
	private final DojoService dojoserv;
	 
	 public NinjasController(NinjaService serv, DojoService dojoserv) {
	     this.serv = serv;
	     this.dojoserv=dojoserv;
	     }

	 
	 @RequestMapping("/ninjas/new")
	 public String index(@ModelAttribute("ninja") Ninja ninja,Model model) {
		 List<Dojo> dojos = dojoserv.allDojos();
		 model.addAttribute("dojos",dojos);
	     return "/ninjas/new.jsp";

	 }
	 
	 @RequestMapping(value="/ninjas", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
	     if (result.hasErrors()) {
	         return "redirect:/ninjas/new";
	     } else {
	    	 Dojo dojo = dojoserv.findDojo(ninja.getDojo_id());
	    	 ninja.setDojo(dojo);
	         serv.createNinja(ninja);
	         return "redirect:/dojos/new";
	     }
	 }
	 
	 
	 
	 
}

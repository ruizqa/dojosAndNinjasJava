package dojosAndNinjas.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dojosAndNinjas.mvc.models.Dojo;
import dojosAndNinjas.mvc.models.Ninja;
import dojosAndNinjas.mvc.repositories.DojoRepository;



@Service
public class DojoService {
    private final DojoRepository repo;
    
    public DojoService(DojoRepository repo) {
        this.repo = repo;
    }
 
    public List<Dojo> allDojos() {
        return repo.findAll();
    }
    
    public Dojo createDojo(Dojo d) {
        return repo.save(d);
    }
    
    public Dojo findDojo(Long id) {
        Optional<Dojo> opDojo = repo.findById(id);
        if(opDojo.isPresent()) {
            return opDojo.get();
        } else {
            return null;
        }
    }
    
    public Dojo updateDojo(Long id, String name, List<Ninja> ninjas) {    	
    	Dojo d = new Dojo (id, name, ninjas);
        return repo.save(d);
    }
    
 
       
    public Dojo addNinja(Dojo d, Ninja n) {
    	List<Ninja> ninjas = d.getNinjas();
    	ninjas.add(n);
    	d.setNinjas(ninjas);
        return repo.save(d);
    }
    
    public Dojo updateDojo(Dojo d) {
        return repo.save(d);
    }
    
    
 
    public void deleteDojo(Long id) {
        Optional<Dojo> optionalDojo = repo.findById(id);
        if(optionalDojo.isPresent()) {
            repo.deleteById(id);
        } 
    }
    
    
    
}
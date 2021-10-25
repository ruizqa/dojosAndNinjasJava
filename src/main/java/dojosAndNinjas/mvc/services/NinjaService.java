package dojosAndNinjas.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dojosAndNinjas.mvc.models.Dojo;
import dojosAndNinjas.mvc.models.Ninja;
import dojosAndNinjas.mvc.repositories.NinjaRepository;

@Service
public class NinjaService {
    private final NinjaRepository repo;
    
    public NinjaService(NinjaRepository repo) {
        this.repo = repo;
    }
 
    public List<Ninja> allPeople() {
        return repo.findAll();
    }
    
    public Ninja createNinja(Ninja n) {
        return repo.save(n);
    }
    
    public Ninja findNinja(Long id) {
        Optional<Ninja> opNinja = repo.findById(id);
        if(opNinja.isPresent()) {
            return opNinja.get();
        } else {
            return null;
        }
    }
    
    public Ninja updateNinja(Long id, String firstName, String lastName, int age, Dojo d) {    	
    	Ninja n = new Ninja (id, firstName, lastName, age, d);
        return repo.save(n);
    }
    
 
    public Ninja updateNinja(Ninja n) {
        return repo.save(n);
    }
    
 
    public void deleteNinja(Long id) {
        Optional<Ninja> optionalNinja = repo.findById(id);
        if(optionalNinja.isPresent()) {
            repo.deleteById(id);
        } 
    }
    
	
	
}

package org.sid.compteservice.web;

import org.sid.compteservice.entities.Compte;
import org.sid.compteservice.repositories.CompteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompteRestController {
    private CompteRepository compteRepository;
    public CompteRestController(CompteRepository compteRepository){
        this.compteRepository= compteRepository;
    }
    @GetMapping(path = "/comptes")
    public List<Compte> listComptes(){
        return compteRepository.findAll();

    }
    @GetMapping(path = "/comptes/{id}")
    public Compte getCompte(@PathVariable(name = "id") long code){
        return compteRepository.findById(code).get();
    }
    @PostMapping(path = "/comptes/{code}")
    public Compte save(@RequestBody long code, @RequestBody Compte compte){
        compte.setCode(code);
        return compteRepository.save(compte);
    }
    @DeleteMapping(path = "/comptes/{code}")
    public void delete(@RequestBody long code, @RequestBody Compte compte){
         compteRepository.deleteById(code );
    }
}

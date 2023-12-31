package com.example.project.Controller;

import com.example.project.Entity.Universite;
import com.example.project.Service.IUniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/universite")
public class UniversiteController {
    IUniversiteService universiteService; //injecter le service dans le controller par l'interface du service

    @GetMapping("/retrieve-all-universite")
    public List<Universite> getUniversites() {
        List<Universite> listUniversites = universiteService.retrieveAlluniversites();
        return listUniversites;
    }

    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long idUniversite) {
        return universiteService.retrieveUniversite(idUniversite);
    }
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite u) {
        Universite universite = universiteService.addUniversite(u);
        return universite;
    }

    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long idUniversite) {
       universiteService.removeUniversite(idUniversite);
    }
    @PutMapping("/update-universite")
    public Universite updateUniversite(@RequestBody Universite u) {
        Universite universite= universiteService.updateUniversite(u);
        return universite;
    }
    @PutMapping("/universite_foyer/{nomUniversite}/{idFoyer}")
    @ResponseBody
    public Universite affecterFoyerAUniversite(@PathVariable("nomUniversite") String nomUniversite,@PathVariable("idFoyer") Long idFoyer) {
        Universite universite= universiteService.affecterFoyerAUniversite(idFoyer,nomUniversite);
        return universite;
    }

    @PutMapping("/desaffecter/{idFoyer}")
    @ResponseBody
    public Universite desaffecterFoyerAUniversite(@PathVariable("idFoyer") Long idFoyer){
        Universite universite =universiteService.desaffecterFoyerAUniversite(idFoyer);
        return universite;
    }

}

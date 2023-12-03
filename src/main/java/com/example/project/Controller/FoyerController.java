package com.example.project.Controller;

import com.example.project.Entity.Foyer;
import com.example.project.Service.IFoyerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/foyer")
public class FoyerController {
    IFoyerService foyerService;

    @GetMapping("/retrieve-all-foyer")
    public List<Foyer> getFoyers() {
        List<Foyer> listFoyers = foyerService.retrieveAllFoyer();
        return listFoyers;
    }

    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long idFoyer) {
        return foyerService.retrieveFoyer(idFoyer);
    }

    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer f) {
        Foyer foyer = foyerService.addFoyer(f);
        return foyer;
    }

    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long idFoyer) {
        foyerService.removeFoyer(idFoyer);
    }

    @PutMapping("/update-foyer")
    public Foyer updateFoyer(@RequestBody Foyer f) {
        Foyer foyer= foyerService.updateFoyer(f);
        return foyer;
    }
    @PostMapping("/ajouter_foyer_bloc")
    public Foyer addFoyerWithBloc(@RequestBody Foyer foyer){
        return foyerService.addFoyerWithBloc(foyer);
    }





}

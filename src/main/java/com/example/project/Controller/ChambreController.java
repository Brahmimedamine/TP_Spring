package com.example.project.Controller;


import com.example.project.Entity.Chambre;
import com.example.project.Service.IChambreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ChambreController {
    IChambreService chambreService;

    @GetMapping("/retrieve-all-chambre")
    public List<Chambre> getlistChambres() {
        List<Chambre> listChambres = chambreService.retrieveAllchambres();
        return listChambres;
    }

    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long idChambre) {
        return chambreService.retrieveChambre(idChambre) ;
    }
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre ch) {
        Chambre chambre = chambreService.addChambre(ch);
        return chambre;
    }

    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chmabre-id") Long idChambre) {
        chambreService.removeChambre(idChambre);
    }
    @PutMapping("/update-chambre")
    public Chambre updateChambre(@RequestBody Chambre ch) {
        Chambre chambre= chambreService.updateChambre(ch);
        return chambre;
    }

}

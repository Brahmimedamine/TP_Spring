package com.example.project.Controller;

import com.example.project.Entity.Bloc;
import com.example.project.Entity.Etudiant;
import com.example.project.Service.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/etudiant")

public class EtudiantController {
    IEtudiantService etudiantService;

    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEtudiants = etudiantService.retrieveAllEtudiants();
        return listEtudiants;
    }

    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        return etudiantService.retrieveEtudiant(etudiantId);
    }
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.addEtudiant(e);
        return etudiant;
    }

    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        etudiantService.removeEtudiant(etudiantId);
    }
    @PutMapping("/update-etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant= etudiantService.updateEtudiant(e);
        return etudiant;
    }


    @PutMapping("/etudiant_reservation/{nomEt}/{prenomEt}/{idReservation}")
    @ResponseBody
    public Etudiant affecterEtudiantAReservation(@PathVariable String nomEt, @PathVariable("prenomEt") String prenomEt,@PathVariable("idReservation") Long idReservation) {
        Etudiant etudiant=etudiantService.affecterEtudiantAReservation(nomEt,prenomEt,idReservation);
        return etudiant;

    }
}

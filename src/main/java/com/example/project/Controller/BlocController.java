package com.example.project.Controller;

import com.example.project.Entity.Bloc;
import com.example.project.Service.IBlocService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/bloc")
public class BlocController {
    IBlocService blocService;

    @GetMapping("/retrieve-all-bloc")
    public List<Bloc> getBlocs() {
        List<Bloc> listBlocs = blocService.retrieveAllblocs();
        return listBlocs;
    }

    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long idBloLc) {
        return blocService.retrieveBloc(idBloLc);
    }
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.addBloc(b);
        return bloc;
    }

    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long idBloLc) {
        blocService.retrieveBloc(idBloLc);
    }
    @PutMapping("/update-bloc")
    public Bloc updateBloc(@RequestBody Bloc b) {
        Bloc bloc= blocService.updateBloc(b);
        return bloc;
    }


    @PutMapping("/chambre_bloc/{nomBloc}")
    @ResponseBody
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambre, @PathVariable("nomBloc") String nomBloc) {
        Bloc bloc = blocService.affecterChambresABloc(numChambre, nomBloc);
        return bloc;

    }

    }

package com.example.project.Service;

import com.example.project.Entity.Bloc;
import com.example.project.Entity.Chambre;
import com.example.project.Entity.TypeChambre;
import com.example.project.Repository.BlocRepository;
import com.example.project.Repository.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ChambreService implements IChambreService{
    ChambreRepository chambreRepository;
    BlocRepository blocRepository;
    IChambreService iChambreService;
    @Override
    public List<Chambre> retrieveAllchambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre ch) {
        return chambreRepository.save(ch);
    }

    @Override
    public Chambre updateChambre(Chambre ch) {
        return chambreRepository.save(ch);
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);


    }


    @Override
    @Scheduled(fixedDelay = 20000)
    public void listeChambresParBloc() {
        blocRepository.findAll().forEach(
                bloc -> {
                    log.info("nombloc" + bloc.getNomBloc() + "capciter : " + bloc.getCapaciteBloc());
                    log.info("Liste des chambre de  :" + bloc.getNomBloc());

                    bloc.getChambres().forEach(chamber -> {
                        log.info("Numero chambre:" + chamber.getNumeroChambre() + "de type:" + chamber.getTypeC());
                    });
                }
        );
    }
        @Scheduled(cron = "0 */5 * * * *")
        public void pourcentageChambreParTypeChambre() {
            log.info("Calcul du pourcentage des chambres ");

            List<Chambre> chambres = chambreRepository.findAll();
            int nbTotalChambres = chambres.size();

            log.info("- tn.esprit.foyer.services.ChambreServiceImpl - nbTotalsChambres : {}", nbTotalChambres);

            for (TypeChambre typeChambre : TypeChambre.values()) {
                long countByType = chambres.stream()
                        .filter(chambre -> chambre.getTypeC() == typeChambre)
                        .count();

                double pourcentage = (countByType * 100.0) / nbTotalChambres;

                log.info("- tn.esprit.foyer.services.ChambreServiceImpl - Le pourcentage pour le type {} est  {}", typeChambre, pourcentage);
            }

            log.info("Fin du calcul du pourcentage");
        }
    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        Bloc bloc =blocRepository.findByNomBloc(nomBloc);
        return new ArrayList<>(bloc.getChambres());
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        return blocRepository.countChambresByTypeAndBlocId(type,idBloc);    }
}

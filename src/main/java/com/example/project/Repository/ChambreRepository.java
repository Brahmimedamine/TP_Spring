package com.example.project.Repository;

import com.example.project.Entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {
   Chambre findByNumeroChambre(Long numeroChambre);


}

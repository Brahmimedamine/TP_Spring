package com.example.project.Repository;

import com.example.project.Entity.Bloc;
import com.example.project.Entity.Chambre;
import com.example.project.Entity.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BlocRepository extends JpaRepository<Bloc,Long> {
 Bloc findByNomBloc(String nomBloc);

 @Query("SELECT COUNT(ch) FROM Bloc b JOIN b.chambres ch WHERE b.idBloc = :idBloc AND ch.TypeC = :type")
 long countChambresByTypeAndBlocId(@Param("type") TypeChambre type, @Param("idBloc") long idBloc);


}

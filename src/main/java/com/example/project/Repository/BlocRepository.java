package com.example.project.Repository;

import com.example.project.Entity.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlocRepository extends JpaRepository<Bloc,Long > {
 Bloc findByNomBloc(String nomBloc);

}

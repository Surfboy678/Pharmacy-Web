package com.brodacki.janusz.pharmacy.medicament.repository;

import com.brodacki.janusz.pharmacy.medicament.model.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicamentRepository extends JpaRepository<Medicament, Integer> {

    Medicament findByName(String name);


}

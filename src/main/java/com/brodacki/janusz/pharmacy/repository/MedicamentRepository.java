package com.brodacki.janusz.pharmacy.repository;

import com.brodacki.janusz.pharmacy.model.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicamentRepository extends JpaRepository<Medicament, Integer> {

}

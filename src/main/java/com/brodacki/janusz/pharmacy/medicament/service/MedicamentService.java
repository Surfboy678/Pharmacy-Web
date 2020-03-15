package com.brodacki.janusz.pharmacy.medicament.service;

import com.brodacki.janusz.pharmacy.medicament.model.Medicament;

import java.util.List;
import java.util.Optional;

public interface MedicamentService {


    List<Medicament> findAllMedicament();

    Optional<Medicament> findMedicamentById(Integer idMedicament);

    Medicament addMedicament(Medicament medicament);

    void deleteMedicament(Integer idMedicament);

    boolean isMedicamentExist(Medicament medicament);
}

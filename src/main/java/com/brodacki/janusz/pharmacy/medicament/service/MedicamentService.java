package com.brodacki.janusz.pharmacy.medicament.service;

import com.brodacki.janusz.pharmacy.medicament.model.Medicament;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface MedicamentService {


    Page<Medicament> findAllMedicament();

    Optional<Medicament> findMedicamentById(Integer idMedicament);

    Medicament addMedicament(Medicament medicament);

    void deleteMedicament(Integer idMedicament);

    boolean isMedicamentExist(Medicament medicament);

    List<Medicament> findSortedListMedicamentByPriceGrowing();

    List<Medicament> findSortedListMedicamentByPriceDecline();
}

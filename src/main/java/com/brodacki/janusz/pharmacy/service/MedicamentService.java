package com.brodacki.janusz.pharmacy.service;

import com.brodacki.janusz.pharmacy.model.Medicament;
import com.brodacki.janusz.pharmacy.repository.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicamentService {

   private MedicamentRepository medicamentRepository;

    @Autowired
    public MedicamentService(MedicamentRepository medicamentRepository) {
        this.medicamentRepository = medicamentRepository;
    }

    public Iterable<Medicament> findAllMedicament(){
        return medicamentRepository.findAll();
    }
    public Optional<Medicament> findMedicamentById(Integer idMedicament){
        return medicamentRepository.findById(idMedicament);
    }
    public Medicament addMedicament(Medicament medicament){
        medicamentRepository.save(medicament);
        return medicament;
    }
}

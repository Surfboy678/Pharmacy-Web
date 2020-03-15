package com.brodacki.janusz.pharmacy.medicament.service.medicamentServiceImpl;

import com.brodacki.janusz.pharmacy.medicament.model.Medicament;
import com.brodacki.janusz.pharmacy.medicament.repository.MedicamentRepository;
import com.brodacki.janusz.pharmacy.medicament.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentServiceImpl implements MedicamentService {

    private MedicamentRepository medicamentRepository;

    @Autowired
    public MedicamentServiceImpl(MedicamentRepository medicamentRepository) {
        this.medicamentRepository = medicamentRepository;
    }

    public List<Medicament> findAllMedicament() {
        return medicamentRepository.findAll();
    }

    @Override
    public Optional<Medicament> findMedicamentById(Integer idMedicament) {
        return medicamentRepository.findById(idMedicament);
    }


    public Medicament addMedicament(Medicament medicament) {
       return medicamentRepository.save(medicament);

    }

    public boolean isMedicamentExist(Medicament medicament) {
        return medicamentRepository.findByName(medicament.getName()) != null;
    }


    public void deleteMedicament(Integer idMedicament) {
        medicamentRepository.deleteById(idMedicament);
    }

}


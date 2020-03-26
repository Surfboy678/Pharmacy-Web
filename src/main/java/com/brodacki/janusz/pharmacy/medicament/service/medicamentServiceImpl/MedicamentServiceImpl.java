package com.brodacki.janusz.pharmacy.medicament.service.medicamentServiceImpl;

import com.brodacki.janusz.pharmacy.medicament.model.Medicament;
import com.brodacki.janusz.pharmacy.medicament.repository.MedicamentRepository;
import com.brodacki.janusz.pharmacy.medicament.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public Page<Medicament> findAllMedicament() {
        return medicamentRepository.findAll(PageRequest.of(1, 5));
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

    public List<Medicament> findSortedListMedicamentByPriceGrowing() {
        return medicamentRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
    }

    public List<Medicament> findSortedListMedicamentByPriceDecline() {
        return medicamentRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
    }

}


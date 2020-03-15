package com.brodacki.janusz.pharmacy.medicament.controller;

import com.brodacki.janusz.pharmacy.medicament.model.Medicament;
import com.brodacki.janusz.pharmacy.medicament.service.medicamentServiceImpl.MedicamentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/medicament")
public class MedicamentController {

    private MedicamentServiceImpl medicamentServiceImpl;


    @Autowired
    public MedicamentController(MedicamentServiceImpl medicamentServiceImpl) {
        this.medicamentServiceImpl = medicamentServiceImpl;
    }


    @RequestMapping(method = RequestMethod.GET, value = "listMedicament")
    public @ResponseBody
    ResponseEntity<List<Medicament>> listMedicament() {
        List<Medicament> allMedicament = medicamentServiceImpl.findAllMedicament();

        if (allMedicament.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(allMedicament, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "medicamentById/{idMedicament}")
    public @ResponseBody
    ResponseEntity getMedicamentById(@PathVariable Integer idMedicament) {
        Optional<Medicament> medicament = medicamentServiceImpl.findMedicamentById(idMedicament);

        if (medicament != null) {
            return ResponseEntity.ok(medicament);
        }
        return ResponseEntity.ok("error" + HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST, value = "addMedicament")
    public @ResponseBody
    ResponseEntity addMedicament(@RequestBody Medicament medicament) {

        if (medicamentServiceImpl.isMedicamentExist(medicament)) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        medicamentServiceImpl.addMedicament(medicament);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete/{idMedicament}")
    public @ResponseBody
    ResponseEntity deleteMedicamentById(@PathVariable Integer idMedicament) {
        Optional<Medicament> medicament = medicamentServiceImpl.findMedicamentById(idMedicament);

        if (medicament == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        medicamentServiceImpl.deleteMedicament(idMedicament);
        return new ResponseEntity<Medicament>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "update/{idMedicament}")
    public @ResponseBody ResponseEntity<Medicament> updateMedicament(@PathVariable Integer idMedicament, @Valid @RequestBody Medicament medicament) {

        if (!medicamentServiceImpl.findMedicamentById(idMedicament).isPresent()) {
           return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(medicamentServiceImpl.addMedicament(medicament));
    }


    @RequestMapping("/hello")
    public String home() {
        return "Hello World!";
    }
}


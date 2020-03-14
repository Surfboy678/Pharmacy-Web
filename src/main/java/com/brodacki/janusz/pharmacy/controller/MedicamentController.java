package com.brodacki.janusz.pharmacy.controller;

import com.brodacki.janusz.pharmacy.model.Medicament;
import com.brodacki.janusz.pharmacy.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/medicament")
public class MedicamentController {

    private MedicamentService medicamentService;

   @Autowired
    public MedicamentController(MedicamentService medicamentService) {
        this.medicamentService = medicamentService;
    }


    @RequestMapping(method = RequestMethod.GET, value = "listMedicament")
    public @ResponseBody
    ResponseEntity getAllMedicament(){
       try {
           Iterable<Medicament> allMedicament = medicamentService.findAllMedicament();
           return ResponseEntity.ok(allMedicament);

       }catch (Exception e){

           return ResponseEntity.ok(e);
       }
    }

    @RequestMapping(method = RequestMethod.GET, value = "medicamentById/{idMedicament}")
    public @ResponseBody
    ResponseEntity getMedicamentById(@PathVariable Integer idMedicament){

       Optional<Medicament> medicament = medicamentService.findMedicamentById(idMedicament);
       return ResponseEntity.ok(medicament);
    }

    @RequestMapping(method = RequestMethod.POST, value = "addMedicament")
    public @ResponseBody
    ResponseEntity addMedicament(@RequestBody Medicament newMedicament){
       try {
           Medicament medicament = medicamentService.addMedicament(newMedicament);
           return ResponseEntity.ok(medicament);

       }catch (Exception e){

           return ResponseEntity.ok(e);
       }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete/{idMedicament}")
    public void deleteMedicamentById(@PathVariable Integer idMedicament){
       medicamentService.deleteMedicament(idMedicament);

    }

    @RequestMapping("/hello")
    public String home(){
        return "Hello World!";
    }
}


package org.nigeria.development.foundation.controller;

import org.nigeria.development.foundation.model.Profession;
import org.nigeria.development.foundation.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/employee_biodata/profession")
@CrossOrigin
public class ProfessionController {

    @Autowired
    ProfessionService professionService;

    @GetMapping(value = "/allProfessions")
    public List<Profession> getAllProfessions() {
        return professionService.getAllProfessions();
    }

    @GetMapping(value = "/single_profession/{id}")
    public Optional<Profession> getProfessionById(@PathVariable(value = "id") Long id) {
        return professionService.getProfessionById(id);
    }

    @PostMapping(value = "/addProfession")
    public Profession addNewProfession(@RequestBody Profession profession) {
        return professionService.addNewProfession(profession);
    }

    @PutMapping(value = "/editProfession/{id}")
    public Profession updateProfession(@PathVariable(value = "id") Long id, @RequestBody Profession profession) {
        Optional<Profession> professionDb = professionService.getProfessionById(id);

        if (professionDb.isPresent()) {
            professionDb.get().setProfessionType(professionDb.get().getProfessionType());
        }
        Profession updatedProfession = professionService.addNewProfession(profession);
        return updatedProfession;
    }

    @DeleteMapping(value = "/deleteProfession/{id}")
    public void removeProfession(@PathVariable(value = "id") Long id) {
        professionService.removeProfession(id);
    }
}
package org.nigeria.development.foundation.service;

import org.nigeria.development.foundation.model.Profession;
import org.nigeria.development.foundation.model.Salary;
import org.nigeria.development.foundation.repository.ProfessionRepository;
import org.nigeria.development.foundation.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionService {

    @Autowired
    ProfessionRepository professionRepository;

    public List<Profession> getAllProfessions() {
        return (List<Profession>) professionRepository.findAll();
    }

    public Optional<Profession> getProfessionById(Long id) {
        return professionRepository.findById(id);
    }

    public Profession addNewProfession(Profession profession){
        return professionRepository.save(profession);
    }

    public void updateSalary(Profession profession) {
        professionRepository.save(profession);
    }

    public void removeProfession(Long id) {
        professionRepository.deleteById(id);
    }
}
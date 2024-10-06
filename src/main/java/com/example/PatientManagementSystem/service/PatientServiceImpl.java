package com.example.PatientManagementSystem.service;

import com.example.PatientManagementSystem.entity.Patient;
import com.example.PatientManagementSystem.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void addPatient(Patient p) {
        patientRepository.save(p);
    }

    @Override
    public Patient getPatientById(int id) {
        return patientRepository.getReferenceById(id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public boolean updatePatient(Patient p) {
        patientRepository.save(p);
        return true;
    }

    @Override
    public boolean deletePatient(int id) {
        Patient p = patientRepository.getReferenceById(id);
        patientRepository.delete(p);
        return true;
    }

    @Override
    public List<Patient> getPatientByName(String name) {
        return patientRepository.getPatientsByName(name);
    }

    @Override
    public List<Patient> getPatientInOrder() {
        return patientRepository.getAllPatientsSortedByNameAndAge();
    }

}

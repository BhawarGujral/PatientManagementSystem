package com.example.PatientManagementSystem.service;

import com.example.PatientManagementSystem.entity.Patient;

import java.util.List;

public interface PatientService {

    public void addPatient(Patient p);

    public Patient getPatientById(int id);

    public List<Patient> getAllPatients();

    public boolean updatePatient(Patient p);

    public boolean deletePatient(int id);

    public List<Patient> getPatientByName(String name);

}

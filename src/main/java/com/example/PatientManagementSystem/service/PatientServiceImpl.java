package com.example.PatientManagementSystem.service;

import com.example.PatientManagementSystem.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientServiceImpl implements PatientService{

    Map<Integer,Patient> patientMap = new HashMap<>();

    PatientServiceImpl(){
        patientMap.put(1,new Patient(1, "John Doe", 25, "Male", "john.doe@example.com", "New York", "1998-02-15"));
        patientMap.put(2, new Patient(2, "Jane Smith", 30, "Female", "jane.smith@example.com", "Los Angeles", "1993-05-22"));
        patientMap.put(3, new Patient(3, "Alice Johnson", 40, "Female", "alice.johnson@example.com", "Chicago", "1984-11-10"));
    }

    @Override
    public void addPatient(Patient p) {
        patientMap.put(p.getId(),p);
    }

    @Override
    public Patient getPatientById(int id) {
        return patientMap.get(id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientMap.values().stream().toList();
    }

    @Override
    public boolean updatePatient(Patient p) {
        if(patientMap.get(p.getId()) != null){
            patientMap.put(p.getId(),p);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePatient(int id) {
        return patientMap.remove(id) != null;
    }
}

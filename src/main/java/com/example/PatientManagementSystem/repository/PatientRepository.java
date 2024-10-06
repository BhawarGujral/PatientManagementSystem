package com.example.PatientManagementSystem.repository;

import com.example.PatientManagementSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

    @Query(value = "SELECT * FROM patient WHERE LOWER(name) LIKE LOWER(CONCAT(:name, '%'))", nativeQuery = true)
    List<Patient> getPatientsByName(String name);

    @Query(value = "SELECT * FROM patient WHERE age > 18 ORDER BY name ASC", nativeQuery = true)
    List<Patient> getAllPatientsSortedByNameAndAge();

}

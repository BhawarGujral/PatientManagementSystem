package com.example.PatientManagementSystem.controller;

import com.example.PatientManagementSystem.entity.Patient;
import com.example.PatientManagementSystem.service.PatientServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PatientController {

    PatientServiceImpl patientService;

    PatientController(PatientServiceImpl patientService){
        this.patientService = patientService;
    }

    @GetMapping("/")
    public String getAllPatients(Model model){
        model.addAttribute("patientList",patientService.getAllPatients());
        return "index";
    }

    @GetMapping("/addPatientForm")
    public String showAddPatient(Model model){
        model.addAttribute("patient",new Patient());
        return "addPatient";
    }

    @PostMapping("/addPatient")
    public String addPatient(@ModelAttribute Patient patient){
        patientService.addPatient(patient);
        return "redirect:/";
    }

    @GetMapping("/deletePatient/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        if(patientService.deletePatient(id))
            return "redirect:/";
        System.out.println("Error in deleting patient");
        return "redirect:/";
    }

    @GetMapping("/updatePatientForm/{id}")
    public String updateEmployeeForm(@PathVariable("id") int id,Model model){
        Patient p = patientService.getPatientById(id);
        model.addAttribute("patient",p);
        return "updatePatient";
    }

    @PostMapping("/updatePatient")
    public String updateEmployee(@ModelAttribute Patient p){
        patientService.updatePatient(p);
        return "redirect:/";
    }
}

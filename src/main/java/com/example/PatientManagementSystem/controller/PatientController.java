package com.example.PatientManagementSystem.controller;

import com.example.PatientManagementSystem.entity.Patient;
import com.example.PatientManagementSystem.service.PatientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String addPatient(@ModelAttribute("patient") @Valid Patient patient, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "addPatient";
        }
        patientService.addPatient(patient);
        return "redirect:/";
    }

    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable("id") int id){
        if(patientService.deletePatient(id))
            return "redirect:/";
        System.out.println("Error in deleting patient");
        return "redirect:/";
    }

    @GetMapping("/updatePatientForm/{id}")
    public String updatePatientForm(@PathVariable("id") int id,Model model){
        Patient p = patientService.getPatientById(id);
        model.addAttribute("patient",p);
        return "updatePatient";
    }

    @PostMapping("/updatePatient")
    public String updatePatient(@ModelAttribute("patient") @Valid Patient p, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "updatePatient";
        }
        patientService.updatePatient(p);
        return "redirect:/";
    }

    @GetMapping("/searchPatientByName")
    public String searchPatientByName(@RequestParam String patientName, Model model){
        List<Patient> p = patientService.getPatientByName(patientName);
        model.addAttribute("patientList",p);
        return "index";
    }
}

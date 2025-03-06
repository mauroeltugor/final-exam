package com.example.finalproyect1.controller;

import com.example.finalproyect1.models.Patient;
import com.example.finalproyect1.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController 
@RequestMapping("/api/patients") 
public class PatientController {

    @Autowired 
    private PatientService patientService;

    @GetMapping
    public List<Patient> getPatients() {
        // Retrieves a list of all patients from the service layer.
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        // Retrieves a patient by their ID, returning an Optional to handle null cases.
        return patientService.getPatientById(id);
    }

    @PostMapping("/new")
    public Patient newPatient(@RequestBody Patient patient) {
        // Creates and saves a new patient entity, mapping the request body to a Patient object.
        return patientService.savePatient(patient);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable Long id) {
        // Deletes a patient by their ID.
        patientService.deletePatient(id);
    }
}

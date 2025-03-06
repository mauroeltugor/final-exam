package com.example.finalproyect1.controller;

import com.example.finalproyect1.models.Doctor;
import com.example.finalproyect1.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController 
@RequestMapping("/api/doctors") 
public class DoctorController {

    @Autowired 
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getDoctors() {
        // Retrieves a list of all doctors from the service layer.
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable Long id) {
        // Retrieves a doctor by their ID, returning an Optional to handle null cases.
        return doctorService.getDoctorById(id);
    }

    @PostMapping("/new")
    public Doctor newDoctor(@RequestBody Doctor doctor) {
        // Creates and saves a new doctor entity, mapping the request body to a Doctor object.
        return doctorService.saveDoctor(doctor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        // Deletes a doctor by their ID.
        doctorService.deleteDoctor(id);
    }
}

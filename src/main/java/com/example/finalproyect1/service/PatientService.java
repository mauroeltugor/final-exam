package com.example.finalproyect1.service;

import com.example.finalproyect1.models.Patient;
import com.example.finalproyect1.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        try {
            return patientRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving patients: " + e.getMessage());
        }
    }

    public Optional<Patient> getPatientById(Long id) {
        try {
            return patientRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving patient with ID: " + id + ". " + e.getMessage());
        }
    }

    @Transactional
    public Patient savePatient(Patient patient) {
        try {
            return patientRepository.save(patient);
        } catch (Exception e) {
            throw new RuntimeException("Error saving patient: " + e.getMessage());
        }
    }

    @Transactional
    public void deletePatient(Long id) {
        try {
            if (patientRepository.existsById(id)) {
                patientRepository.deleteById(id);
            } else {
                throw new RuntimeException("Patient with ID: " + id + " not found.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting patient with ID: " + id + ". " + e.getMessage());
        }
    }
}

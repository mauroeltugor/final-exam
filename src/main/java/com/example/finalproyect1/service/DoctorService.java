package com.example.finalproyect1.service;

import com.example.finalproyect1.models.Doctor;
import com.example.finalproyect1.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        try {
            return doctorRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving doctors: " + e.getMessage());
        }
    }

    public Optional<Doctor> getDoctorById(Long id) {
        try {
            return doctorRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving doctor with ID: " + id + ". " + e.getMessage());
        }
    }

    @Transactional
    public Doctor saveDoctor(Doctor doctor) {
        try {
            return doctorRepository.save(doctor);
        } catch (Exception e) {
            throw new RuntimeException("Error saving doctor: " + e.getMessage());
        }
    }

    @Transactional
    public void deleteDoctor(Long id) {
        try {
            if (doctorRepository.existsById(id)) {
                doctorRepository.deleteById(id);
            } else {
                throw new RuntimeException("Doctor with ID: " + id + " not found.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting doctor with ID: " + id + ". " + e.getMessage());
        }
    }
}

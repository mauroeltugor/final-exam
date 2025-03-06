package com.example.finalproyect1.service;

import com.example.finalproyect1.models.Sede;
import com.example.finalproyect1.repository.SedeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    public List<Sede> getAll() {
        try {
            return sedeRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error obtaining sedes: " + e.getMessage());
            throw new RuntimeException("Error obtaining sedes", e);
        }
    }

    public Optional<Sede> getById(Long id) {
        return sedeRepository.findById(id);
    }

    @Transactional
    public Sede save(Sede sede) {
        try {
            return sedeRepository.save(sede);
        } catch (Exception e) {
            System.out.println("Error saving sede: " + e.getMessage());
            throw new RuntimeException("Error saving sede", e);
        }
    }

    @Transactional
    public void delete(Long id) {
        try {
            sedeRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error deleting sede: " + e.getMessage());
            throw new RuntimeException("Error deleting sede", e);
        }
    }
}


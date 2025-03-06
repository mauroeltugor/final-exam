package com.example.finalproyect1.service;

import com.example.finalproyect1.models.Area;
import com.example.finalproyect1.repository.AreaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {

    @Autowired
    private AreaRepository areaRepository;

    public List<Area> getAllAreas() {
        try {
            return areaRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving areas: " + e.getMessage());
        }
    }

    public Optional<Area> getAreaById(Long id) {
        try {
            return areaRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving area with ID: " + id + ". " + e.getMessage());
        }
    }

    @Transactional
    public Area saveArea(Area area) {
        try {
            return areaRepository.save(area);
        } catch (Exception e) {
            throw new RuntimeException("Error saving area: " + e.getMessage());
        }
    }

    @Transactional
    public void deleteArea(Long id) {
        try {
            if (areaRepository.existsById(id)) {
                areaRepository.deleteById(id);
            } else {
                throw new RuntimeException("Area with ID: " + id + " not found.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting area with ID: " + id + ". " + e.getMessage());
        }
    }
}

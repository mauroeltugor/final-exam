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
        return areaRepository.findAll();
    }

    public Optional<Area> getAreaById(Long id) {
        return areaRepository.findById(id);
    }

    @Transactional
    public Area saveArea(Area area) {
        return areaRepository.save(area);
    }

    @Transactional
    public void deleteArea(Long id) {
        areaRepository.deleteById(id);
    }
}

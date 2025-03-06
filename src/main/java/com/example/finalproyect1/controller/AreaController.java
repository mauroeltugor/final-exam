package com.example.finalproyect1.controller;

import com.example.finalproyect1.models.Area;
import com.example.finalproyect1.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController 
@RequestMapping("/api/areas") 
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping
    public List<Area> getAreas() {
        // Retrieves a list of all areas from the service layer.
        return areaService.getAllAreas();
    }

    @GetMapping("/{id}")
    public Optional<Area> getAreaById(@PathVariable Long id) {
        // Retrieves an area by its ID, wrapped in an Optional to handle null cases.
        return areaService.getAreaById(id);
    }

    @PostMapping("/new")
    public Area newArea(@RequestBody Area area) {
        // Saves a new area entity, mapping the request body to an Area object.
        return areaService.saveArea(area);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArea(@PathVariable Long id) {
        // Deletes an area by its ID.
        areaService.deleteArea(id);
    }
}

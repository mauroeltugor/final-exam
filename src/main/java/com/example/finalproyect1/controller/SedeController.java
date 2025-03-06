package com.example.finalproyect1.controller;

import com.example.finalproyect1.models.Sede;
import com.example.finalproyect1.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/sedes")
@RestController 
public class SedeController {

    @Autowired 
    private SedeService sedeService;

    @GetMapping
    public List<Sede> getSedes() {
        // Retrieves a list of all 'Sede' entities from the service layer.
        return sedeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Sede> getSedeById(@PathVariable Long id) {
        // Retrieves a 'Sede' entity by its ID, returning an Optional to handle null cases.
        return sedeService.getById(id);
    }

    @PostMapping("/new")
    public Sede newSede(@RequestBody Sede sede) {
        // Creates and saves a new 'Sede' entity, mapping the request body to a Sede object.
        return sedeService.save(sede);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSede(@PathVariable Long id) {
        // Deletes a 'Sede' entity by its ID.
        sedeService.delete(id);
    }
}

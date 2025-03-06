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
        return sedeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Sede> getSedeById(@PathVariable Long id) {
        return sedeService.getById(id);
    }

    @PostMapping("/new")
    public Sede newSede(@RequestBody Sede sede) {
        return sedeService.save(sede);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSede(@PathVariable Long id) {
        sedeService.delete(id);
    }
}

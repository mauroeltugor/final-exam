package com.example.finalproyect1.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "room") // Defines the table name in the database.
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments the ID value.
    private Long id;

    @Column(nullable = false) // Ensures 'number' is required.
    private int number;

    @Column(nullable = false, length = 50) // Ensures 'type' is required and limited to 50 characters.
    private String type; 

    @ManyToOne // Many Rooms belong to one Sede.
    @JoinColumn(name = "sede_id", nullable = false) // Foreign key referencing Sede.
    private Sede sede;

    @OneToMany(mappedBy = "room") // One Room can have multiple Patients.
    private List<Patient> patients;

    // Getters and setters for entity fields.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}

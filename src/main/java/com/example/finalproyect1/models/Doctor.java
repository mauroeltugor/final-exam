package com.example.finalproyect1.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "doctors") // Defines the table name in the database.
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments the ID value.
    private Long id;

    @Column(nullable = false, length = 100) // Ensures 'name' is required and limited to 100 characters.
    private String name;

    @Column(nullable = false, length = 100) // Ensures 'specialty' is required and limited to 100 characters.
    private String specialty;

    @ManyToOne // Many Doctors belong to one Sede.
    @JoinColumn(name = "sede_id", nullable = false) // Foreign key referencing Sede.
    private Sede sede;

    @ManyToMany(mappedBy = "doctors") // Bidirectional relationship with Area.
    @JsonIgnore // Prevents infinite recursion in JSON serialization.
    private List<Area> areas;

    @ManyToMany // Many Doctors can have many Patients.
    @JoinTable(
        name = "doctor_patients", // Defines the join table name.
        joinColumns = @JoinColumn(name = "doctor_id"), // Foreign key for Doctor.
        inverseJoinColumns = @JoinColumn(name = "patient_id") // Foreign key for Patient.
    )
    @JsonIgnore // Prevents infinite recursion in JSON serialization.
    private List<Patient> patients;

    // Getters and setters for entity fields.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}

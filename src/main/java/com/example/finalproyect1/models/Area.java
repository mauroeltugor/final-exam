package com.example.finalproyect1.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "areas") // Defines the table name in the database.
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments the ID value.
    private Long id;

    @Column(nullable = false, length = 100) // Ensures 'name' is required and limited to 100 characters.
    private String name;

    @ManyToOne // Many Areas belong to one Sede.
    @JoinColumn(name = "sede_id", nullable = false) // Foreign key referencing Sede.
    private Sede sede;

    @ManyToMany // Many Areas can have many Doctors.
    @JoinTable(
        name = "areas_doctors", // Defines the join table name.
        joinColumns = @JoinColumn(name = "area_id"), // Foreign key for Area.
        inverseJoinColumns = @JoinColumn(name = "doctor_id") // Foreign key for Doctor.
    )
    @JsonIgnore // Prevents infinite recursion in JSON serialization.
    private List<Doctor> doctors;

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

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}

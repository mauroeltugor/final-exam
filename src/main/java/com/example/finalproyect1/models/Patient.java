package com.example.finalproyect1.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "patient") // Defines the table name in the database.
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments the ID value.
    private Long id;

    @Column(nullable = false, length = 100) // Ensures 'name' is required and limited to 100 characters.
    private String name;

    @Column(nullable = false) // Ensures 'age' is required.
    private int age;

    @Column(nullable = false, length = 200) // Ensures 'disease' is required and limited to 200 characters.
    private String disease;

    @ManyToOne // Many Patients belong to one Sede.
    @JoinColumn(name = "sede_id", nullable = false) // Foreign key referencing Sede.
    private Sede sede;

    @ManyToOne // Many Patients can be assigned to one Room.
    @JoinColumn(name = "room_id") // Foreign key referencing Room.
    private Room room;

    @ManyToMany // Many Patients can be treated by many Doctors.
    @JoinTable(
        name = "patient_doctor", // Defines the join table name.
        joinColumns = @JoinColumn(name = "patient_id"), // Foreign key for Patient.
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}

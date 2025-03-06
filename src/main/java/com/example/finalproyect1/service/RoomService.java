package com.example.finalproyect1.service;

import com.example.finalproyect1.models.Room;
import com.example.finalproyect1.repository.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        try {
            return roomRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving rooms: " + e.getMessage());
        }
    }

    public Optional<Room> getRoomById(Long id) {
        try {
            return roomRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving room with ID: " + id + ". " + e.getMessage());
        }
    }

    @Transactional
    public Room saveRoom(Room room) {
        try {
            return roomRepository.save(room);
        } catch (Exception e) {
            throw new RuntimeException("Error saving room: " + e.getMessage());
        }
    }

    @Transactional
    public void deleteRoom(Long id) {
        try {
            if (roomRepository.existsById(id)) {
                roomRepository.deleteById(id);
            } else {
                throw new RuntimeException("Room with ID: " + id + " not found.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting room with ID: " + id + ". " + e.getMessage());
        }
    }
}

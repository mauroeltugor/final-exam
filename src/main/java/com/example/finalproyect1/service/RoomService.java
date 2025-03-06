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
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    @Transactional
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @Transactional
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}

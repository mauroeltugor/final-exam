package com.example.finalproyect1.controller;

import com.example.finalproyect1.models.Room;
import com.example.finalproyect1.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Optional<Room> getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    @PostMapping("/new")
    public Room newRoom(@RequestBody Room room) {
        return roomService.saveRoom(room);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }
}

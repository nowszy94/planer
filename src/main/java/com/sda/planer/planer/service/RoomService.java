package com.sda.planer.planer.service;

import com.sda.planer.planer.model.Room;
import com.sda.planer.planer.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAll() {
        return (List<Room>) roomRepository.findAll();
    }

    public void addRoom(Room room) {
        roomRepository.save(room);
    }
}

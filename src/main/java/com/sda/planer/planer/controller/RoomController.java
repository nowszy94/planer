package com.sda.planer.planer.controller;

import com.sda.planer.planer.model.Room;
import com.sda.planer.planer.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ModelAndView allRooms() {
        ModelAndView modelAndView = new ModelAndView("allRooms");
        modelAndView.addObject("rooms", roomService.getAll());
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView getRoom(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("room");
        modelAndView.addObject("room", roomService.getOne(id));
        return modelAndView;
    }

    @PostMapping
    public String addRoom(@ModelAttribute Room room) {
        roomService.addRoom(room);
        return "redirect:/rooms";
    }

}

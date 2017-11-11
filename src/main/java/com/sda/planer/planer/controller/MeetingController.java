package com.sda.planer.planer.controller;

import com.sda.planer.planer.model.Meeting;
import com.sda.planer.planer.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/meetings")
public class MeetingController {

    private MeetingService meetingService;

    @Autowired
    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("allMeetings");
        modelAndView.addObject("meetings", meetingService.getAll());
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView getOne(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("meeting");
        Meeting meeting = meetingService.getOne(id);
        modelAndView.addObject("meeting", meeting);
        return modelAndView;
    }

    @PostMapping
    public String addOne(@ModelAttribute Meeting meeting) {
        meetingService.addOne(meeting);
        return "redirect:/meetings";
    }

    @PostMapping("{id}")
    public String addAttendee(@PathVariable("id") long id,  @RequestParam long attendee) {
        meetingService.addAttendee(id, attendee);
        return "redirect:/meetings/" + id;
    }
}

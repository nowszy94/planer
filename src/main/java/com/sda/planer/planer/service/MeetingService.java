package com.sda.planer.planer.service;

import com.sda.planer.planer.model.Meeting;
import com.sda.planer.planer.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {
    private MeetingRepository meetingRepository;

    @Autowired
    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public List<Meeting> getAll() {
        return (List<Meeting>) meetingRepository.findAll();
    }
}

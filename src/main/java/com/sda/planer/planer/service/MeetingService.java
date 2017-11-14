package com.sda.planer.planer.service;

import com.sda.planer.planer.model.Employee;
import com.sda.planer.planer.model.Meeting;
import com.sda.planer.planer.repository.EmployeeRepository;
import com.sda.planer.planer.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {
    private MeetingRepository meetingRepository;

    private EmployeeRepository employeeRepository;

    @Autowired
    public MeetingService(MeetingRepository meetingRepository, EmployeeRepository employeeRepository) {
        this.meetingRepository = meetingRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Meeting> getAll() {
        return (List<Meeting>) meetingRepository.findAll();
    }

    public void addOne(Meeting meeting) {
        meetingRepository.save(meeting);
    }

    public Meeting getOne(long id) {
        return meetingRepository.findOne(id);
    }

    public void addAttendee(long meetingId, long attendeeId) {
        Employee employee = employeeRepository.findOne(attendeeId);
        Meeting meeting = meetingRepository.findOne(meetingId);
        meeting.getAttendees().add(employee);
//        employee.getMeetings().add(meeting);
        meetingRepository.save(meeting);
    }


}

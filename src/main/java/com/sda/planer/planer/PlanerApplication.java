package com.sda.planer.planer;

import com.sda.planer.planer.model.Employee;
import com.sda.planer.planer.model.EmployeeEnum;
import com.sda.planer.planer.model.Meeting;
import com.sda.planer.planer.model.Room;
import com.sda.planer.planer.repository.EmployeeRepository;
import com.sda.planer.planer.repository.MeetingRepository;
import com.sda.planer.planer.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.jws.Oneway;
import java.time.LocalDate;

@SpringBootApplication
public class PlanerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanerApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private MeetingRepository meetingRepository;
}

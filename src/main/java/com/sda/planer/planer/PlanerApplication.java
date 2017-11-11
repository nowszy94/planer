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
public class PlanerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PlanerApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private MeetingRepository meetingRepository;

	@Override
	public void run(String... strings) throws Exception {
		Employee employee = employeeRepository.save(new Employee("Szymon", "Nowak", "785419047", "nowszy94@gmail.com",null, EmployeeEnum.BACKEND));
		Employee employee2 = employeeRepository.save(new Employee("Jan", "Kowalski", "823472938", "jan.kowalski@gmail.com", null, EmployeeEnum.BACKEND));
		Employee employee3 = employeeRepository.save(new Employee("John", "Doe", "275783920", "john.doe@foo.bar", null, EmployeeEnum.BACKEND));

		Room room = roomRepository.save(new Room("Winkiel", 12));
		Room room2 = roomRepository.save(new Room("Pyra", 12));

		meetingRepository.save(new Meeting("Blabla", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima, sunt?", room, employee, null, LocalDate.of(2016, 5, 22)));
		meetingRepository.save(new Meeting("Popijawa", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab adipisci dicta earum obcaecati quisquam quo rerum suscipit ut vitae voluptatum.", room2, employee3, null, LocalDate.of(2017, 10, 1)));
		meetingRepository.save(new Meeting("Meeting", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Excepturi ipsum placeat quae quisquam sint voluptate.", room, employee2, null, LocalDate.now()));
	}
}


//Employee:
//id, firstName, lastName, phoneNumber, email, department(enum - BACKEND, FRONTEND, HR)

//Employee Controller (htmle):
//allEmployees(lista pracownikow oraz formularz), employee

//EmployeeService:
//getAll, get(id), add(employee)

//EmployeeRepository:
//

//Room
//id, name, capacity
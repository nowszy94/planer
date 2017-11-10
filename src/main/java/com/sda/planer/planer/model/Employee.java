package com.sda.planer.planer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "attendees")
    private List<Meeting> meetings;

    @Enumerated(EnumType.STRING)
    private EmployeeEnum department;

    public String getFormattedDepartment() {
        String lowerCased = StringUtils.lowerCase(department.toString());
        return StringUtils.capitalize(lowerCased);
    }
}

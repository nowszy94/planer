package com.sda.planer.planer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String description;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Employee owner;

    @ManyToMany
    private List<Employee> attendees;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    public int getAttendeesCount() {
        return (attendees == null ? 0 : attendees.size()) + 1;
    }

    public String getShortenedDescription() {
        return StringUtils.abbreviate(description, 20);
    }

}

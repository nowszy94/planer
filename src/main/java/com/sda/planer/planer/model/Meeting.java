package com.sda.planer.planer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employee owner;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Employee> attendees;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private LocalDate date;

    public int getAttendeesCount() {
        return (attendees == null ? 0 : attendees.size()) + 1;
    }

    public String getShortenedDescription() {
        return StringUtils.abbreviate(description, 20);
    }

    public Meeting(String title, String description, Room room, Employee owner, List<Employee> attendees/*, LocalDate date*/) {
        this.title = title;
        this.description = description;
        this.room = room;
        this.owner = owner;
        this.attendees = attendees;
//        this.date = date;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", room=" + room +
                ", owner=" + owner +
                ", attendees=" + attendees +
                '}';
    }
}

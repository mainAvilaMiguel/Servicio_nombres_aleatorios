package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Person {
    private LocalDateTime date;
    private String hostName;
    private String name;
    private String lastName;

    public Person(LocalDateTime date, String hostName, String name, String lastName) {
        this.date = date;
        this.hostName = hostName;
        this.name = name;
        this.lastName = lastName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

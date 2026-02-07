package com.svalero.komorebiandroid.domain;

import java.time.LocalDate;

import java.io.Serializable;

public class SchoolDTO implements Serializable {

    private String name;
    private String city;
    private int students;
    private boolean publicSchool;
    private String registerDate;

    public SchoolDTO(School school) {
        this.name = school.getName();
        this.city = school.getCity();
        this.students = school.getStudents();
        this.publicSchool = school.isPublicSchool();
        this.registerDate = school.getRegisterDate() != null ? school.getRegisterDate().toString() : "";
    }



    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getStudents() {
        return students;
    }

    public boolean getPublicSchool() {
        return publicSchool;
    }

    public String getRegisterDate() {
        return registerDate;
    }
}

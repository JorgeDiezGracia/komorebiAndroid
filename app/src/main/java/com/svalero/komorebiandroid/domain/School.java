package com.svalero.komorebiandroid.domain;


import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class School {
    private Long id;
    private String name;
    private String city;
    private int students;
    private boolean publicSchool;
    private String registerDate;
}

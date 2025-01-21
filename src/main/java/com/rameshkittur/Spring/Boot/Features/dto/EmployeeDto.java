package com.rameshkittur.Spring.Boot.Features.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Builder
public class EmployeeDto {

    private Long id;

    private String name;

    private String email;

    private Integer age;

    private LocalDate dateOfJoining;

    private boolean isActive;

    private String role;
}

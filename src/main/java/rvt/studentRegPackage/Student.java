package rvt.studentRegPackage;

import java.time.LocalDateTime;
import java.time.Instant;

public class Student {
    private String name;
    private String surname;
    private String email;
    private String code;
    private Instant regTime;

    public Student(String name, String surname, String email, String code, Instant regTime) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.code = code;
        this.regTime = regTime;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getCode() {
        return code;
    }

    public Instant getRegTime() {
        return regTime;
    }
}
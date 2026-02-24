package rvt.studentRegPackage;

import java.time.LocalDateTime;

public class Student {
    private String name;
    private String surname;
    private String email;
    private String code;
    private LocalDateTime regTime;

    public Student(String code, String name, String surname, String email, LocalDateTime regTime) {
        this.code = code;
        this.name = name;
        this.surname = surname;
        this.email = email;
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

    public LocalDateTime getRegTime() {
        return regTime;
    }



    public void setName(String newName) {
        this.name = newName;
    }

    public void setSurname(String newSurname) {
        this.surname = newSurname;
    }

    public void setEmail(String newEmail) {
        this.name = newEmail;
    }

    @Override

    public String toString() {
        return code + "," + name + "," + surname + "," + email + "," + regTime;
    }
}
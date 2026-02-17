package rvt.studentRegPackage;

import java.time.Instant;

public class StudentBuilder {
    private String name;
    private String surname;
    private String email;
    private String code;
    private Instant regTime;

    public StudentBuilder name(String name){
        this.name = name;
        return this;
    }

    public StudentBuilder surname(String surname){
        this.surname = surname;
        return this;
    }

    public StudentBuilder email(String email){
        this.email = email;
        return this;
    }

    public StudentBuilder code(String code){
        this.code = code;
        return this;
    }

    public StudentBuilder regTime(Instant regTime){
        this.regTime = regTime;
        return this;
    }

    public Student build() {
        return new Student(name, surname, email, code, regTime);
    }
}

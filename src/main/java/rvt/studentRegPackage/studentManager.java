package rvt.studentRegPackage;

//import java.io.*;
import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;
    FileHandler fileHandler = new FileHandler();
    CLITableRenderer renderer = new CLITableRenderer();

    public StudentManager() {
        this.students = new ArrayList<>();
        fileHandler.loadFromFile(students);
    }

    public void register(Student student) {
        students.add(student);
        fileHandler.addToFile(student);
    }

    public void show() {
        renderer.renderTable(students);
    }

    public void remove(String code) {
        for(int i = 0; i < getLastId(); i++) {
            String checkCode = students.get(i).getCode();
            if (checkCode == code) {
                students.remove(i);
            }
        }

        fileHandler.updateFile(students);
    }

    public void edit(String code, String field, String newValue) {
        Student student = getStudentByCode(code);
    
        if (student == null) {
            System.out.println("Student not found");
            return;
        }

        System.out.printf("Tiek redigets lietotajs: %s %s%n",
        student.getName(), student.getSurname());

        switch (field.toLowerCase()) {
            case "name" -> student.setName(newValue);
            case "surname" -> student.setSurname(newValue);
            case "email" -> student.setEmail(newValue);
            default -> System.out.println("Nezinams redigesanas laukums.");
        }
    }

    public void help() {
        System.out.println("list of commands:\n|register - registre lietotaju\n|show - parada visus lietotajus\n|remove - nonem lietotaju\n|edit - redige lietotaju\n||name - nomainit vardu\n||surname - nomainit uzvardu\n|\n|email - nomainit epastu\n|exit - apret programmu");
    }
    
    public int getLastId() {
        return students.size() - 1;
    }

    public Student getStudentByCode(String code) {
        for (Student s : students) {
            if(s.getCode().equals(code)) {
                return s;
            }
        }
        return null;
    }

    public boolean checkExistenceOf(String input){
        for (Student s : students) {
            if(s.getCode().equals(input) || s.getEmail().equals(input)) {
                return true;
            }
        }
        return false;
    }
}
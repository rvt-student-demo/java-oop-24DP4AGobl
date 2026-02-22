package rvt.studentRegPackage;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class FileHandler {
    private final String filePath = "data/studentData.csv";
    private StudentManager manager;

    public void loadFromFile(ArrayList<Student> students) {
        try(Scanner reader = new Scanner(new File(filePath))){
            reader.nextLine();
            while(reader.hasNextLine()) {
                String row = reader.nextLine();
                String[] parts = row.split(",");
                String code = parts[0];
                String name = parts[1];
                String surname = parts[2];
                String email = parts[3];
                LocalDateTime regTime = LocalDateTime.parse(parts[4]);
                StudentBuilder sb = new StudentBuilder();

                students.add(
                    sb
                    .code(code)
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .regTime(regTime)
                    .build()
                );
            
            }
        }catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String[] getCSVTitle(){
        try(Scanner reader = new Scanner(new File(filePath))){
            reader.nextLine();

            while(reader.hasNextLine()) {
                String row = reader.nextLine();
                String[] parts = row.split(",");
                return parts;
            }
        }catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public void updateFile(ArrayList<Student> students) {
        try (PrintWriter pWriter = new PrintWriter(new FileWriter(filePath))) {
            pWriter.println("personCode,name,surname,email,regDateTime");
            
            for (int i = 0; i < manager.getLastId(); i++) {
               pWriter.println(students.get(i).toString());
            }
        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void addToFile(Student student) {
        try (PrintWriter pWriter = new PrintWriter(new FileWriter(filePath, true))) {
                pWriter.println(student.toString());
        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
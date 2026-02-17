package rvt.studentRegPackage;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.time.Instant;
import java.time.format.DateTimeParseException;

public class fileHandler {
    private final String filePath = "data/studentData.csv";

    public void loadFromFile(ArrayList<Student> students) {
        try(Scanner reader = new Scanner(new File(filePath))){
            reader.nextLine();
            while(reader.hasNextLine()) {
                String row = reader.nextLine();
                String[] parts = row.split(",");
                String name = parts[1];
                String surname = parts[2];
                String email = parts[3];
                String code = parts[4];
                Instant regTime = Instant.parse(parts[5]);
                StudentBuilder sb = new StudentBuilder();

                students.add(
                    sb
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .code(code)
                    .regTime(regTime)
                    .build()
                );
            
            }
        }catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addToFile(ArrayList<Student> students) {
        try (PrintWriter pWriter = new PrintWriter(new FileWriter(filePath, true))) {
            for (int i = 0; i < students.size() - 1; i++) {
                pWriter.println(i + "," + students.get(i));
            }
        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
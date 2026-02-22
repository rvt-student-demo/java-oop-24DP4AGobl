package rvt.studentRegPackage;

import java.util.ArrayList;

public class CLITableRenderer {
    FileHandler fileHandler = new FileHandler();

    public void renderTable(ArrayList<Student> students) {
        String[] titleParts = fileHandler.getCSVTitle();
        printLine("-", 10, titleParts.length);
        System.out.printf("| %-21s | %-21s | %-21s | %-21s | %-21s%n",
        titleParts[0], titleParts[1], titleParts[2], titleParts[3], titleParts[4]);
        printLine("-", 10, titleParts.length);

        for (int i = 1; i < students.size(); i++){
            String[] data = students.get(i).toString().split(",");
            System.out.printf("| %-21s | %-21s | %-21s | %-21s | %-21s%n",
            data[0], data[1], data[2], data[3], data[4]);
        }

        printLine("-", 10, titleParts.length);
    }

    public void printLine(String character, int times, int collumns) {
        for (int i = 0; i < collumns; i++){
            System.out.println("+");
            System.out.print(character.repeat(times));
        }
        System.out.println("+");
    }
}
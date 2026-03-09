package rvt.studentRegPackage;

import java.util.ArrayList;

public class CLITableRenderer {
    FileHandler fileHandler = new FileHandler();

    public void renderTable(ArrayList<Student> students) {
        String[] titleParts = fileHandler.getCSVTitle();
        Integer padding = 2;
        String format = makeFormat(getMaxCollonWidth(students), padding);

        printLine("-", getMaxCollonWidth(students), padding);
        System.out.printf(format,
        titleParts[0], titleParts[1], titleParts[2], titleParts[3], titleParts[4]);
        printLine("-", getMaxCollonWidth(students), padding);

        for (int i = 0; i < students.size(); i++){
            String[] data = students.get(i).toString().split(",");
            System.out.printf(format,
            data[0], data[1], data[2], data[3], data[4]);
        }

        printLine("-", getMaxCollonWidth(students), padding);
    }

    public void printLine(String character, Integer[] widths, Integer padding) {
        for (int width: widths) {
            System.out.print("+" + character.repeat(width + padding + 2));
        }
        System.out.print("+");
        System.out.println();
    }

    public String makeFormat(Integer[] widths, Integer padding) {
        StringBuilder sb = new StringBuilder("|");
        for (int width : widths) {
            sb.append(" %-").append(width + padding).append("s |");
        }
        sb.append("%n");
        return sb.toString();
    }

    public Integer[] getMaxCollonWidth(ArrayList<Student> students){
        Integer[] maxCodeWidth = new Integer[students.size()];
        Integer[] maxNameWidth = new Integer[students.size()];
        Integer[] maxSurnameWidth = new Integer[students.size()];
        Integer[] maxEmailWidth = new Integer[students.size()];
        Integer[] maxRegDateTimeWidth = new Integer[students.size()];
        int index = 0;
        
        for (Student s : students) {
            maxCodeWidth[index] = s.getCodeLength();
            maxNameWidth[index] = s.getNameLength();
            maxSurnameWidth[index] = s.getSurnameLength();
            maxEmailWidth[index] = s.getEmailLength();
            maxRegDateTimeWidth[index] = s.getRegTimeLength();
            index++;
        }

        Integer[] widthOfEachColon = new Integer[]{
            determineMaxNumber(maxCodeWidth),
            determineMaxNumber(maxNameWidth),
            determineMaxNumber(maxSurnameWidth),
            determineMaxNumber(maxEmailWidth),
            determineMaxNumber(maxRegDateTimeWidth)};

        return widthOfEachColon;
    }

    public int determineMaxNumber(Integer[] values){
        int max = values[0];
        for (int v : values) {
            if (v > max){
                max = v;
            }
        }
        return max;
    }
}
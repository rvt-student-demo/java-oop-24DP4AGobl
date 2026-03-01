package rvt;
import java.util.Scanner;
import rvt.studentRegPackage.*;

public class App {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator(manager);

        UserInterface userInterface = new UserInterface(manager, scanner, validator);
        userInterface.start();
    }
}
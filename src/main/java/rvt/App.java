package rvt;
import java.util.Scanner;
import rvt.studentRegPackage.*;

public class App {
    public static void main(String[] args) {
        //FileHandler handler = new FileHandler();
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        Validator validator = new Validator(manager);

        UserInterface userInterface = new UserInterface(manager, scanner, validator);
        userInterface.start();
    }
}
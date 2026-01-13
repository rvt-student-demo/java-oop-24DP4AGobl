package rvt;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        toDoList list = new toDoList();
        Scanner scanner = new Scanner(System.in);

        userInterface userInterface = new userInterface(list, scanner);
        userInterface.start();
    }
}

package rvt;

import rvt.interface_in_a_box.*;

public class App {
    public static void main(String[] args) {
        Box box = new Box();
        Box smallerBox = new Box();
        BookBuilder bBuilder = new BookBuilder();
        CDBuilder cDBuilder = new CDBuilder();

        box.add(bBuilder.
                author("Fyodor Dostoevsky").
                title("Crime and Punishment").
                weight(2).
                build()
        );
        box.add(bBuilder.
                author("Robert Martin").
                title("Clean Code").
                weight(1).
                build()
        );
        box.add(bBuilder.
                author("Kent Beck").
                title("Test Driven Development").
                weight(0.5).
                build()
        );

        box.add(cDBuilder.
                    author("Pink Floyd").
                    title("Dark Side of the Moon").
                    year(1973).
                    build()
        );
        box.add(cDBuilder.
                    author("Wigwam").
                    title("Nuclear Nightclub").
                    year(1975).
                    build()
        );
        box.add(cDBuilder.
                    author("Rendezvous Park").
                    title("Closer to Being Here").
                    year(2012).
                    build()
        );
        box.add(smallerBox);

        System.out.println(box);
    }
}
package rvt.interface_in_a_box;

public class CD implements Packable {
    private String author;
    private String title;
    private int year;

    public CD(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    @Override

    public double weight() {
        return 0.1;
    }

    @Override

    public String toString(){
        return author + ": " + title + " (" + year + ")";
    }
}

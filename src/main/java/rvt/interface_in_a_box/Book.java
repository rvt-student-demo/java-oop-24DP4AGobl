package rvt.interface_in_a_box;

public class Book implements Packable {
    private String author;
    private String title;
    private double weight;

    public Book(String author, String title, double weight) {
        this.author = author;
        this.title = title;
        this.weight = weight;
    }

    @Override

    public double weight() {
        return weight;
    }

    @Override

    public String toString(){
        return author + ": " + title;
    }
}

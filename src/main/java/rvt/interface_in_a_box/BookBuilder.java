package rvt.interface_in_a_box;

public class BookBuilder {
    private String author;
    private String title;
    private double weight;

    public BookBuilder author(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder title(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder weight(double weight) {
        this.weight = weight;
        return this;
    }

    public Book build(){
        return new Book(author, title, weight);
    }   
}

package org.techtown.BookReviewApp;

public class Book {
    String title;
    String author;
    String inside;

    public Book(String title, String author, String inside) {
        this.title = title;
        this.author = author;
        this.inside = inside;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInside() {
        return inside;
    }

    public void setInside(String inside) {
        this.inside = inside;
    }
}

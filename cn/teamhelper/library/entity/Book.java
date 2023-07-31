package cn.teamhelper.library.entity;

import java.io.Serializable;
import java.util.Comparator;

public class Book  implements Serializable{
    private int id;
    private String title;
    private String author;
    private Boolean status;

    public Book(int id, String title, String author, Boolean status){
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public Boolean getStatus() {
        return status;
    }

    public static Comparator<Book> IdComparator = new Comparator<Book>() {
        @Override
        public int compare(Book b1, Book b2) {
            return b1.getId() - b2.getId();   //ascending order
            //return b2.getId() - b1.getId(); //descending order
        }
    };

    public static Comparator<Book> TitleComparator = new Comparator<Book>() {
        @Override
        public int compare(Book b1, Book b2) {
            return b1.getTitle().compareTo(b2.getTitle());   //ascending order
            //return b2.getTitle().compareTo(b1.getTitle()); //descending order
        }
    };

    public static Comparator<Book> AuthorComparator = new Comparator<Book>() {
        @Override
        public int compare(Book b1, Book b2) {
            return b1.getAuthor().compareTo(b2.getAuthor());   //ascending order
            //return b2.getAuthor().compareTo(b1.getAuthor()); //descending order
        }
    };

    public static Comparator<Book> StatusComparator = new Comparator<Book>() {
        @Override
        public int compare(Book b1, Book b2) {
            return b1.getStatus().compareTo(b2.getStatus());   //ascending order
            //return b2.getStatus().compareTo(b1.getStatus()); //descending order
        }
    };
}
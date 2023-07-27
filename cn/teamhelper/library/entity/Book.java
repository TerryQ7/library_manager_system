package cn.teamhelper.library.entity;

import java.io.Serializable;

public class Book  implements Serializable{
    private String id;
    private String title;
    private String author;
    private Boolean status;

    public Book(String id, String title, String author, Boolean status){
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = status;
    }

    public void setId(String id) {
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

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public Boolean getStatus() {
        return status;
    }

    // getters and setters ...
}

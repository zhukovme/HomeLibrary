package me.zhukov.homelibrary.hibernate.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Michael Zhukov
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {
    private static final long serialVersionUID = -6537518032807298454L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private Date date;

    @Column(name = "author")
    private String author;

    @Column(name = "isbn", unique = true, updatable = false)
    private long isbn;

    public Book() {
    }

    public Book(long id, String title, Date date, String author, long isbn) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.author = author;
        this.isbn = isbn;
    }

    public Book(String title, Date date, String author, long isbn) {
        this.title = title;
        this.date = date;
        this.author = author;
        this.isbn = isbn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", author='" + author + '\'' +
                ", isbn=" + isbn +
                '}';
    }
}

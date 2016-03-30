package me.zhukov.homelibrary.main;

import me.zhukov.homelibrary.hibernate.data.Book;
import me.zhukov.homelibrary.hibernate.services.BookService;

import java.util.Date;

/**
 * @author Michael Zhukov
 */
public class Main {

    public static void main(String[] args) {
        BookService bookService = new BookService();

        Book book1 = new Book("Книга_1", new Date(), "Michael", 123456789);

        long bookId = bookService.addBook(book1);
        System.out.println("Added book id:" + bookId);

        Book book = bookService.getBook(bookId);
        System.out.println("Book from db by id = " + bookId);
        System.out.println(book);
    }
}

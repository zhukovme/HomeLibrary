package me.zhukov.homelibrary.servlets;

import me.zhukov.homelibrary.hibernate.data.Book;
import me.zhukov.homelibrary.hibernate.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Michael Zhukov.
 */
public class NewBookServlet extends HttpServlet {

    public static final String CHARSET = "charset=utf-8";

    public static final String TITLE_ATTRIBUTE = "title";
    public static final String AUTHOR_ATTRIBUTE = "author";
    public static final String DATE_ATTRIBUTE = "date";
    public static final String ISBN_ATTRIBUTE = "isbn";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding(CHARSET);

        BookService bookService = new BookService();

        String title = req.getParameter(TITLE_ATTRIBUTE);
        String author = req.getParameter(AUTHOR_ATTRIBUTE);
        String dateStr = req.getParameter(DATE_ATTRIBUTE);
        String isbn = req.getParameter(ISBN_ATTRIBUTE);

        System.out.println(title);
        System.out.println(author);
        System.out.println(dateStr);
        System.out.println(isbn);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Book book = new Book(title, date, author, Long.parseLong(isbn));

        long id = bookService.addBook(book);

        resp.setStatus(HttpServletResponse.SC_OK);
    }
}

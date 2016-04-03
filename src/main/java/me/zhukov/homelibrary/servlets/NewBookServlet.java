package me.zhukov.homelibrary.servlets;

import me.zhukov.homelibrary.Utils.DateHelper;
import me.zhukov.homelibrary.hibernate.data.Book;
import me.zhukov.homelibrary.hibernate.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Michael Zhukov.
 */
public class NewBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        BookService bookService = new BookService();

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String dateStr = req.getParameter("date");
        String isbn = req.getParameter("isbn");

        Date date = DateHelper.INSTANCE.stringToDate(dateStr);

        Book book = new Book(title, date, author, Long.parseLong(isbn));
        bookService.addBook(book);

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.sendRedirect("/");
    }
}

package me.zhukov.homelibrary.servlets;

import me.zhukov.homelibrary.hibernate.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Michael Zhukov
 */
public class DeleteAllBooksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookService();
        bookService.deleteAllBooks();

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.sendRedirect("/");
    }
}

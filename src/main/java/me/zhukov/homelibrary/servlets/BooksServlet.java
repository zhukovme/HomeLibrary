package me.zhukov.homelibrary.servlets;

import com.google.gson.Gson;
import me.zhukov.homelibrary.hibernate.data.Book;
import me.zhukov.homelibrary.hibernate.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Michael Zhukov
 */
public class BooksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookService bookService = new BookService();
        List<Book> allBooks = bookService.getAllBooks();

        if (allBooks == null || allBooks.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            return;
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        String json = gson.toJson(allBooks);

        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();

        resp.setStatus(HttpServletResponse.SC_OK);
    }
}

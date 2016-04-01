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
import java.util.Date;
import java.util.List;

/**
 * @author Michael Zhukov
 */
public class BooksServlet extends HttpServlet {

    public static final String CONTENT_TYPE = "application/json";
    public static final String CHARSET = "charset=utf-8";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(CONTENT_TYPE);
        resp.setCharacterEncoding(CHARSET);

        BookService bookService = new BookService();
        List<Book> allBooks = bookService.getAllBooks();

        if (allBooks == null) {
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            return;
        }
        Gson gson = new Gson();
        String json = gson.toJson(allBooks);

        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();

        resp.setStatus(HttpServletResponse.SC_OK);
    }
}

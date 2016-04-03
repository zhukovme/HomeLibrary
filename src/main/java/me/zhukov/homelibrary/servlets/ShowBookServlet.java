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

/**
 * @author Michael Zhukov
 */
public class ShowBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookService();

        String idStr = req.getPathInfo();

        if (idStr == null || idStr.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            return;
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        long id = Long.parseLong(idStr.replace("/", ""));
        Book book = bookService.getBook(id);

        Gson gson = new Gson();
        String bookJson = gson.toJson(book);

        PrintWriter out = resp.getWriter();
        out.print(bookJson);
        out.flush();

        resp.setStatus(HttpServletResponse.SC_OK);
    }
}

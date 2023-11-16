package com.kitri.jspbasic.book;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(value = {"/book", "/book/update/*", "/book/updated/*", "/book/remove/*"} ,loadOnStartup = 1)
public class BookServlet extends HttpServlet {
    static ServletContext sc = null;
    static BookDao bookDao = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookDao = BookDao.getInstance();
        sc = config.getServletContext();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        LocalDate publishedDate = LocalDate.parse(req.getParameter("publishedDate"));

        bookDao.add(new Book(name, author, publishedDate));
        sc.setAttribute("books", bookDao.getAll());

        RequestDispatcher rd = req.getRequestDispatcher("/book/booklist.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] split = req.getRequestURI().split("/");
        if (split.length > 3) {
            if (split[2].equals("update")) {
                doUpdate(Long.parseLong(split[3]), req, resp);
            } else if (split[2].equals("remove")) {
                doRemove(Long.parseLong(split[3]));
            } else if (split[2].equals("updated")) {
                req.setCharacterEncoding("UTF-8");
                String name = req.getParameter("name");
                String author = req.getParameter("author");
                LocalDate publishedDate = LocalDate.parse(req.getParameter("publishedDate"));

                bookDao.update(Long.parseLong(split[3]), new Book(name, author, publishedDate));
                sc.setAttribute("books", bookDao.getAll());
            }
        }

        RequestDispatcher rd = req.getRequestDispatcher("/book/booklist.jsp");
        rd.forward(req, resp);
    }

    private void doRemove(Long id) {
        bookDao.removeById(id);
        sc.setAttribute("books", bookDao.getAll());
    }

    private void doUpdate(Long id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = bookDao.getById(id);
        req.setAttribute("book", book);
        RequestDispatcher rd = req.getRequestDispatcher("/book/book-update.jsp");
        rd.forward(req, resp);
    }
}

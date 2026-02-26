package DTO.model.controller;

import DTO.model.Category;
import DTO.model.dao.CategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {

    private CategoryDao categoryDao;

    @Override
    public void init() throws ServletException {
        try {
            categoryDao = new CategoryDao(getServletContext());
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listCategories(request, response);
                break;

            case "add":
                showAddForm(request, response);
                break;

            case "delete":
                deleteCategory(request, response);
                break;

            default:
                listCategories(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("insert".equals(action)) {
            insertCategory(request, response);
        } else if ("update".equals(action)) {
            updateCategory(request, response);
        } else {
            response.sendRedirect("category");
        }
    }

    private void listCategories(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Category> list = categoryDao.listAll();
        request.setAttribute("categories", list);
        request.getRequestDispatcher("categoryList.jsp").forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("categoryForm.jsp").forward(request, response);
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Category c = new Category();
        c.setTypeID(id);
        categoryDao.deleteRec(c);
        response.sendRedirect("category");
    }

    private void insertCategory(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Category c = new Category();
        c.setCategoryName(request.getParameter("categoryName"));
        c.setMemo(request.getParameter("memo"));
        categoryDao.insertRec(c);
        response.sendRedirect("category");
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Category c = new Category();
        c.setTypeID(Integer.parseInt(request.getParameter("typeID")));
        c.setCategoryName(request.getParameter("categoryName"));
        c.setMemo(request.getParameter("memo"));
        categoryDao.updateRec(c);
        response.sendRedirect("category");
    }
}
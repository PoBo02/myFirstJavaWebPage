package DTO.model.controller;

import DTO.model.Product;
import DTO.model.Category;
import DTO.model.Account;
import DTO.model.dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        try {
            productDAO = new ProductDAO(getServletContext());
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
                listProducts(request, response);
                break;

            case "detail":
                productDetail(request, response);
                break;

            case "add":
                showAddForm(request, response);
                break;

            case "delete":
                deleteProduct(request, response);
                break;

            default:
                listProducts(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("insert".equals(action)) {
            insertProduct(request, response);
        } else if ("update".equals(action)) {
            updateProduct(request, response);
        } else {
            response.sendRedirect("product");
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Product> list = productDAO.listAll();
        request.setAttribute("products", list);
        request.getRequestDispatcher("productList.jsp").forward(request, response);
    }

    private void productDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        Product product = productDAO.getObjectById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("productDetail.jsp").forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("productForm.jsp").forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String id = request.getParameter("id");
        Product p = new Product();
        p.setProductID(id);
        productDAO.deleteRec(p);
        response.sendRedirect("product");
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Product p = getProductFromRequest(request);
        productDAO.insertRec(p);
        response.sendRedirect("product");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Product p = getProductFromRequest(request);
        productDAO.updateRec(p);
        response.sendRedirect("product");
    }

    private Product getProductFromRequest(HttpServletRequest request) {

        Product p = new Product();
        p.setProductID(request.getParameter("productId"));
        p.setProductName(request.getParameter("productName"));
        p.setProductImage(request.getParameter("productImage"));
        p.setBrief(request.getParameter("brief"));
        p.setUnit(request.getParameter("unit"));
        p.setPrice(Integer.parseInt(request.getParameter("price")));
        p.setDiscount(Integer.parseInt(request.getParameter("discount")));

        Category c = new Category();
        c.setTypeID(Integer.parseInt(request.getParameter("typeId")));
        p.setType(c);

        HttpSession session = request.getSession(false);
        Account acc = (Account) session.getAttribute("user");
        p.setAccount(acc);

        return p;
    }
}
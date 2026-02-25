package DTO.model.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.model.Account;
import DTO.model.dao.AccountDAO;

public class AccountServlet extends HttpServlet {
    private AccountDAO accountDAO;

    public void init() throws ServletException {
        try {
            accountDAO = new AccountDAO(getServletContext());

        } catch (Exception e) {
            throw new ServletException(e);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String account = request.getParameter("account");
        String pass = request.getParameter("pass");

        Account currentUser = accountDAO.loginSuccess(account, pass);

        if (currentUser != null) {

            HttpSession session = request.getSession();
            session.setAttribute("user", currentUser);

            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }

    }

}

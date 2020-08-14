/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quoctm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import quoctm.userAccount.ErrorUpdate;
import quoctm.userAccount.UserDAO;

/**
 *
 * @author SE130297
 */
@WebServlet(name = "UpdateAccountServlet", urlPatterns = {"/UpdateAccountServlet"})
public class UpdateAccountServlet extends HttpServlet {

//    private final String ERROR_PAGE = "error.html";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String lastname = request.getParameter("txtLastname");
        String isAdmin = request.getParameter("chkAdmin");
//        String url = ERROR_PAGE;

        String searchValue = request.getParameter("lastSearchValue");
        String urlRewritting = "search_servlet?"
                + "txtSearchLastName=" + searchValue;
        boolean role = false;
        if (isAdmin != null) {
            role = true;
        }
        ErrorUpdate errors = new ErrorUpdate();
        boolean foundErr = false;
        try {
            if (password.trim().length() < 6 || password.trim().length() > 20) {
                foundErr = true;
                errors.setPasswordLengthErr("Password is required typing from 6 > 20 char");
            }
            if (foundErr) {
                request.setAttribute("ERROR_UPDATE", errors);
            } else {
                UserDAO dao = new UserDAO();
                boolean check = dao.UpdateAccount(password, lastname, role, username);
                if (check) {
                   urlRewritting = "search_servlet?"
                            + "txtSearchLastName=" + searchValue;
                }
            }
        } catch (SQLException ex) {
            log("UpdateAccountServlet_SQL" + ex.getMessage());
        } catch (NamingException ex) {
            log("UpdateAccountServlet_Naming" + ex.getMessage());
        } finally {
//            RequestDispatcher rd = request.getRequestDispatcher(urlRewritting);
//            rd.forward(request, response);
            response.sendRedirect(urlRewritting);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

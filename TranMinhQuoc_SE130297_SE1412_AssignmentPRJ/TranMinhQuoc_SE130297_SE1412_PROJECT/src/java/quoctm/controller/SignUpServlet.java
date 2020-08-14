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
import quoctm.userAccount.SignUpError;
import quoctm.userAccount.UserDAO;
import quoctm.userAccount.UserDTO;

/**
 *
 * @author SE130297
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {

    private final String SUCCESS = "try";
    private final String FAIL = "create_new_account2";

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
        String confirmPassword = request.getParameter("txtConfirmPassword");
        String fullName = request.getParameter("txtLastname");
        String url = FAIL;
        SignUpError error = new SignUpError();
        boolean foundErr = false;
        try {
            if (username.trim().length() < 6 || username.trim().length() > 20) {
                foundErr = true;
                error.setUsernameLengthErr("Usernname is required typing from 6 > 20 char");
            }
            if (password.trim().length() < 6 || password.trim().length() > 20) {
                foundErr = true;
                error.setPasswordLengthErr("Password is required typing from 6 > 20 char");
            } else if (!confirmPassword.trim().equals(password.trim())) {
                foundErr = true;
                error.setConfirmPasswordNoMatch("Confirm error");
            }
            if (fullName.trim().length() < 6 || fullName.trim().length() > 20) {
                foundErr = true;
                error.setLastnameLengthErr("Lastname is required typing from 6 > 20 char");
            }
            if (foundErr) {
                request.setAttribute("CREATE_ERROR", error);
            } else {
                UserDAO dao = new UserDAO();
                boolean result = dao.SignUpAccount(username, password, fullName, false);
                if(result){
                    url = SUCCESS;
                }
            }
        } catch (SQLException ex) {
           String msg = ex.getMessage();
           log("SignUpServlet_SQL" + msg);
           if(msg.contains("duplicate")){
               error.setUsernameIsExisted(username + " is Existed");
               request.setAttribute("CREATE_ERROR", error);
           }
        } catch (NamingException ex) {
            log("SignUpServlet_Naming" + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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

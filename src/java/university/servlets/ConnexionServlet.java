/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package university.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import university.beans.*;
import university.dao.DAOException;
import university.dao.DAOFactory;
import university.dao.UserDao;
import university.beans.Student;

/**
 *
 * @author olga
 */
public class ConnexionServlet extends HttpServlet {

    public static final String ATTR_LOGIN = "login";
    public static final String ATTR_PASWWORD = "password";
    public static final String ATT_SESSION_USER = "sessionUser";

    //Connexion to the database
    public static final String CONF_DAO = "daofactory";
    private UserDao userDao;

    @Override
    public void init() {
        this.userDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO)).getUserDao();
    }

    private String nextPage;

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
//
        User userCheck;

        String userLogin = request.getParameter(ATTR_LOGIN).trim();
        String userPswd = request.getParameter(ATTR_PASWWORD).trim();
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        session.setAttribute("login", userLogin);
        userCheck = userDao.loginUniversity(userLogin, userPswd);
        System.out.println("userCheck" + userCheck);
        if (userCheck.isStudent() == true) {
            nextPage = "/accueilEtud.jsp";
            this.getServletContext().getRequestDispatcher(nextPage).forward(request, response);
            System.out.println("User type : " + userCheck);
        } else if (userCheck.isStudent() == false) {
            nextPage = "/accueilTuteur.jsp";
            this.getServletContext().getRequestDispatcher(nextPage).forward(request, response);
            System.out.println("User type : " + userCheck);
        } else {
            nextPage = "/PortailUniv?error=1";
            this.getServletContext().getRequestDispatcher(nextPage).forward(request, response);
            System.err.println("Erreur de login, veuillez rentrer un login correct svp");
        }
    }

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
@Override
        public String getServletInfo() {
        return "In ConnexionServlet : Servlet en charge de rédiriger vers la bonne page selon que tu es étudiant ou tuteur ";
    }

}

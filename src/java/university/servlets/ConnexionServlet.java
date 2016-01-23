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
import university.dao.UserDao;
//import university.dao.UserDaoImpl;

/**
 *
 * @author olga
 */
public class ConnexionServlet extends HttpServlet {
    public static final String ATTR_LOGIN = "login";
    public static final String ATTR_PASWWORD = "password";
    public static final String ATT_SESSION_USER = "sessionUser";



    //connexion with database
   // a revoir
    //User userType = this.loginUniversity(ATTR_LOGIN, ATTR_PASWWORD);
    Student checkStudent = new Student();
    Tutor checkTutor = new Tutor();
    private String nextPage;
    int id = 0;


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (checkStudent.isStudent() == true){
            nextPage = "/accueilEtud.jsp";
            this.getServletContext().getRequestDispatcher(nextPage).forward(request, response);
            //System.out.println("User type : "+userType);
        }
        else if (checkTutor.isStudent() == false ){
            nextPage = "/accueilTuteur.jsp";
            this.getServletContext().getRequestDispatcher(nextPage).forward(request, response);
           // System.out.println("User type : "+userType);
        }
        else {
            nextPage = "/portailUniv.jsp";
            this.getServletContext().getRequestDispatcher(nextPage).forward(request, response);
            System.err.println("Erreur de login, veuillez rentrer un login correct svp");
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

//        String result;
//        String login = request.getParameter(ATTR_LOGIN).trim();
//        String password = request.getParameter(ATTR_PASWWORD).trim();
//        HttpSession session = request.getSession();
//        session.setAttribute("login", login);
//        session.setAttribute(ATT_SESSION_USER, login);

                HttpSession session = request.getSession();

        if (checkStudent.isStudent() == true){
            nextPage = "/accueilEtud.jsp";
            this.getServletContext().getRequestDispatcher(nextPage).forward(request, response);
            //System.out.println("User type : "+userType);
        }
        else if (checkTutor.isStudent() == false ){
            nextPage = "/accueilTuteur.jsp";
            this.getServletContext().getRequestDispatcher(nextPage).forward(request, response);
           // System.out.println("User type : "+userType);
        }
        else {
            nextPage = "/portailUniv.jsp";
            this.getServletContext().getRequestDispatcher(nextPage).forward(request, response);
            System.err.println("Erreur de login, veuillez rentrer un login correct svp");
        }

    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "In ConnexionServlet : Servlet en charge de rédiriger vers la bonne page selon que tu es étudiant ou tuteur ";
    }

//    public User loginUniversity(String login, String password) throws DAOException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public Student retrieveStudentFromMail(String mail) throws DAOException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public Student retrieveStudentFromUserID(Long ID) throws DAOException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

}

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

/**
 *
 * @author olga
 */
public class AccueilEtudServlet extends HttpServlet {

    public static final String VUE_FORM = "/accueilEtud.jsp";
    private String nextPage;


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

        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
//        nextPage = "/afficheStage.jsp";
//        this.getServletContext().getRequestDispatcher(nextPage).forward(request, response);

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

        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "In AccueilSerlet : Affiche la page d'accueil de l'étudiant";
    }

}

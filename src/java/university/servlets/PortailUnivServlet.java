package university.servlets;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;


public class PortailUnivServlet extends HttpServlet {

        public static final String VUE_FORM = "/portailUniv.jsp";

    @Override
        public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
                String error = request.getParameter("error");
                if(error != null ){
                    request.setAttribute("error","Infos login incorrectes" );
                }
	}

    @Override
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );

	}

}

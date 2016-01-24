package university.testServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import university.beans.User;
import university.dao.DAOFactory;
import university.dao.UserDao;

public class TestUsers extends HttpServlet {
	public static final String CONF_DAO="daofactory";
	private UserDao userDao;
	
	public void init(){
		this.userDao=((DAOFactory)getServletContext().getAttribute(CONF_DAO)).getUserDao();
	}
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		//Test loginUniversity(String login, String password)
		String login="user";
		String password="user";
		User userLogin=userDao.loginUniversity(login, password);
		request.setAttribute("userLogin", userLogin);
		
		//Test retrieveStudentFromMail(mail)
		String mail="mail";
		User userFromMail=userDao.retrieveStudentFromMail(mail);
		request.setAttribute("userFromMail", userFromMail);
		
		//Test retrieveStudentFromUserID(ID)
		long ID=1;
		User userFromID=userDao.retrieveStudentFromUserID(ID);
		request.setAttribute("userFromID", userFromID);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/TestUsers.jsp").forward(request, response);
	}
	
}

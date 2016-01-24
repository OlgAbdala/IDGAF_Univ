package university.dao;

import university.beans.User;
import university.beans.Student;

public interface UserDao {
	User loginUniversity(String login, String password) throws DAOException;
	Student retrieveStudentFromMail(String mail) throws DAOException;
	Student retrieveStudentFromUserID(Long ID) throws DAOException;
	
}

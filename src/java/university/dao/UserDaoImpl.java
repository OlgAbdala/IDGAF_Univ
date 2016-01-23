package university.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import university.beans.User;
import university.beans.Student;
import university.beans.Tutor;
import static university.dao.DAOUtility.*;

public class UserDaoImpl implements UserDao {
	
	private DAOFactory daoFactory;
	
	private String SQL_SELECT_USER_FROM_CREDENTIALS="SELECT * FROM Users WHERE login=? AND password=?";
	private String SQL_SELECT_STUDENT_FROM_USER_ID="SELECT * FROM Students WHERE userID=?";
	private String SQL_SELECT_TUTOR_FROM_USER_ID="SELECT * FROM Tutors WHERE userID=?";
	private String SQL_JOINT_SELECT_STUDENT_FROM_MAIL="SELECT U.ID, U.login, U.password, U.name, U.surname, U.mail, U.tel, "
											+ "U.department, S.ID AS studentID, S.course, S.year, S.className, S.resumeLink"
											+ "FROM Users AS U"
											+ "INNER JOIN Students AS S"
											+ "ON U.ID=S.userID"
											+ "WHERE U.mail=?";
	private String SQL_JOINT_SELECT_STUDENT_FROM_USER_ID="SELECT U.ID, U.login, U.password, U.name, U.surname, U.mail, U.tel, "
			+ "U.department, S.ID AS studentID, S.course, S.year, S.className, S.resumeLink"
			+ "FROM Users AS U"
			+ "INNER JOIN Students AS S"
			+ "ON U.ID=S.userID"
			+ "WHERE U.ID=?";
	
	
	public UserDaoImpl(DAOFactory dao){
		this.daoFactory=dao;
	}
	
	@Override
	public User loginUniversity(String login, String password)
			throws DAOException {
		User user=null;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try{
			//First we get the user data from login and password and then we try to match Users.ID with
			//Students.userID then with Tutors.userID and we keep the only one giving a result
			connection=this.daoFactory.getConnection();
			preparedStatement=initializePreparedStatement(connection, SQL_SELECT_USER_FROM_CREDENTIALS, false, login, password);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				user=mapUser(resultSet);
				preparedStatement=initializePreparedStatement(connection, SQL_SELECT_STUDENT_FROM_USER_ID, false, user.getID());
				resultSet=preparedStatement.executeQuery();
				if(resultSet.next()){
					Student student=mapStudent(user, resultSet);
					return student;
				}
				else {
					preparedStatement=initializePreparedStatement(connection, SQL_SELECT_TUTOR_FROM_USER_ID, false, user.getID());
					resultSet=preparedStatement.executeQuery();
					if(resultSet.next()){
						Tutor tutor=mapTutor(user, resultSet);
						return tutor;
					}
					else{
						return null;
					}
				}
			}
			else{
				return null;
			}
			
		}catch(SQLException e){
			throw new DAOException(e);
		}finally{
			silentClosings(resultSet, preparedStatement, connection);
		}
	}
	
	@Override
	public Student retrieveStudentFromMail(String mail) throws DAOException {
		Student student=null;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try{
			connection=this.daoFactory.getConnection();
			preparedStatement=initializePreparedStatement(connection, SQL_JOINT_SELECT_STUDENT_FROM_MAIL, false, mail);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				student=mapStudent(resultSet);
			}
		}catch(SQLException e){
			throw new DAOException(e);
		}finally{
			silentClosings(resultSet, preparedStatement, connection);
		}
		return student;
	}
	
	@Override
	public Student retrieveStudentFromUserID(Long ID) throws DAOException {
		Student student=null;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try{
			connection=this.daoFactory.getConnection();
			preparedStatement=initializePreparedStatement(connection, SQL_JOINT_SELECT_STUDENT_FROM_USER_ID, false, ID);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				student=mapStudent(resultSet);
			}
		}catch(SQLException e){
			throw new DAOException(e);
		}finally{
			silentClosings(resultSet, preparedStatement, connection);
		}
		return student;
	}
	
	private static User mapUser(ResultSet resultSet) throws SQLException{
		User user=new User();
		user.setID(resultSet.getLong("ID"));
		user.setLogin(resultSet.getString("login"));
		user.setPassword(resultSet.getString("password"));
		user.setName(resultSet.getString("name"));
		user.setSurname(resultSet.getString("surname"));
		user.setMail(resultSet.getString("mail"));
		user.setTel(resultSet.getString("tel"));
		user.setDepartment(resultSet.getString("department"));
		return user;
	}
	private static Student mapStudent(ResultSet resultSet) throws SQLException{
		Student student=new Student();
		student.setID(resultSet.getLong("ID"));
		student.setLogin(resultSet.getString("login"));
		student.setPassword(resultSet.getString("password"));
		student.setName(resultSet.getString("name"));
		student.setSurname(resultSet.getString("surname"));
		student.setMail(resultSet.getString("mail"));
		student.setTel(resultSet.getString("tel"));
		student.setDepartment(resultSet.getString("department"));
		student.setStudentID(resultSet.getLong("studentID"));
		student.setCourse(resultSet.getString("course"));
		student.setYear(resultSet.getInt("year"));
		student.setClassName(resultSet.getString("className"));
		student.setResumeLink(resultSet.getString("resumeLink"));
		return null;
	}
	
	private static Student mapStudent(User u, ResultSet resultSet) throws SQLException{
		Student student=new Student(u);
		student.setStudentID(resultSet.getLong("ID"));
		student.setCourse(resultSet.getString("course"));
		student.setYear(resultSet.getInt("year"));
		student.setClassName(resultSet.getString("className"));
		student.setResumeLink(resultSet.getString("resumeLink"));
		return student;
	}
	
	private static Tutor mapTutor(User u, ResultSet resultSet) throws SQLException{
		Tutor tutor=new Tutor(u);
		tutor.setTutorID(resultSet.getLong("ID"));
		return tutor;
	}
}

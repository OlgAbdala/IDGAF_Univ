package university.beans;

public class User {
	private Long ID;
	private String login;
	private String password;
	private String name;
	private String surname;
	private String mail;
	private String tel;
	private String department;
	
	public User(){}
	public User(User u){
		this.ID=u.getID();
		this.login=u.getLogin();
		this.password=u.getPassword();
		this.name=u.getName();
		this.surname=u.getSurname();
		this.mail=u.getMail();
		this.tel=u.getTel();
		this.department=u.getDepartment();
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "User [ID=" + ID + ", login=" + login + ", password=" + password + ", name=" + name + ", surname="
				+ surname + ", mail=" + mail + ", tel=" + tel + ", department=" + department + "]";
	}
        public boolean isStudent(){
		return false;
	}
	
}

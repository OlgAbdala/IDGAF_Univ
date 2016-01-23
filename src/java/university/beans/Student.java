package university.beans;

public class Student extends User {
	private Long studentID;
	private String course;
	private Integer year;
	private String className;
	private String resumeLink;
	
	public Student(){};
	public Student(User u){
		super(u);
	}
	
	public Long getStudentID() {
		return studentID;
	}
	public void setStudentID(Long studentID) {
		this.studentID = studentID;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getResumeLink() {
		return resumeLink;
	}
	public void setResumeLink(String resumeLink) {
		this.resumeLink = resumeLink;
	}
	public boolean isStudent(){
		return true;
	}
}

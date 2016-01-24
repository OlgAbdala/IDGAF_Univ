package university.beans;

public class Tutor extends User {
	private Long tutorID;

	public Tutor(){}
	public Tutor(User u){
		super(u);
	}
	
	public Long getTutorID() {
		return tutorID;
	}

	public void setTutorID(Long tutorID) {
		this.tutorID = tutorID;
	}
	public boolean isStudent(){
		return false;
	}
	@Override
	public String toString() {
		return super.toString()+"Tutor [tutorID=" + tutorID + "]";
	}
	
	
}

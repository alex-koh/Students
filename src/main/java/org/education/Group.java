package org.education;

public class Group {
	private int id;
	private String number;
	private String faculty;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Group) {
			Group group = (Group) obj;
			return  id==group.getId() && 
					number.equals(group.getNumber()) &&
					faculty.equals(group.getFaculty());
		}
		else {
			return super.equals(obj);
		}
	}
}

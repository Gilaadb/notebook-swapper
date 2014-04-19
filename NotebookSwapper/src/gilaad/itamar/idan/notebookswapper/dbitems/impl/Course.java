package gilaad.itamar.idan.notebookswapper.dbitems.impl;

import gilaad.itamar.idan.notebookswapper.dbitems.iface.ICourse;

public class Course implements ICourse {

	private int m_Number;
	private String m_Name,m_Faculty;
	
	public Course(int num, String name, String faculty) {
		m_Number=num;
		m_Name=name;
		m_Faculty = faculty;
	}
	
	@Override
	public int getCourseNumber() {
		return m_Number;
	}

	@Override
	public String getCourseName() {
		return m_Name;
	}

	@Override
	public String getFaculty() {
		return m_Faculty;
	}

}

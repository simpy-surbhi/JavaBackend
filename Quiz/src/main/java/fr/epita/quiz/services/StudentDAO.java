package fr.epita.quiz.services;

import java.util.Map;

import fr.epita.quiz.datamodel.Student;


public class StudentDAO extends GenericDAO<Student, String> {

	@Override
	public void setParameters(Map<String, Object> parameters, Student criteria) {
		parameters.put("pTitle", criteria.getName());
	}
}
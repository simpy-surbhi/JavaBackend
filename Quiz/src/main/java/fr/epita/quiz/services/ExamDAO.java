package fr.epita.quiz.services;

import java.util.Map;

import fr.epita.quiz.datamodel.Exam;


public class ExamDAO extends GenericDAO<Exam, Long> {

	@Override
	public void setParameters(Map<String, Object> parameters, Exam criteria) {
		
		parameters.put("pTitle", criteria.getTitle());
	}	
}
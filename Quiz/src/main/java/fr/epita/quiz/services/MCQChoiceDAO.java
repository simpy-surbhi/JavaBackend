package fr.epita.quiz.services;

import java.util.Map;

import fr.epita.quiz.datamodel.MCQChoice;


public class MCQChoiceDAO extends GenericDAO<MCQChoice, Long> {

	@Override
	public void setParameters(Map<String, Object> parameters, MCQChoice criteria) {
		// TODO Auto-generated method stub
		parameters.put("pTitle", criteria.getId());
	}
	
}
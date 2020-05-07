package fr.epita.quiz.services;

import java.util.Map;

import fr.epita.quiz.datamodel.Answer;

public class AnswerDAO extends GenericDAO<Answer, Long> {

	@Override
	public void setParameters(Map<String, Object> parameters, Answer criteria) {
		parameters.put("pTitle", criteria.getId());
	}
}

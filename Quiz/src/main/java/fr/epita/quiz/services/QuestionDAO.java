package fr.epita.quiz.services;

import java.util.Map;

import fr.epita.quiz.datamodel.Question;




public class QuestionDAO extends GenericDAO<Question, Long> {

	@Override
	public void setParameters(Map<String, Object> parameters, Question criteria) {
		parameters.put("pTitle", criteria.getTitle());
	}
}

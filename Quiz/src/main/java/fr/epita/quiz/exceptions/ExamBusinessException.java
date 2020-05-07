package fr.epita.quiz.exceptions;

import fr.epita.quiz.businessservice.BusinessExceptions;

@SuppressWarnings("serial")
public class ExamBusinessException extends BusinessExceptions {
	
	public ExamBusinessException(String exception) {
		super(exception);
	}
}

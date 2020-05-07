package fr.epita.QuizAPI.DTO;

import fr.epita.QuizAPI.Error.GeneralError;
import fr.epita.quiz.datamodel.Question;


public class QuestionDTO extends GeneralError {
	
	private Long id;
	private String title;

	public QuestionDTO() {
	}
	
	public QuestionDTO(Question question) {
		this.id = question.getId();
		this.title = question.getTitle();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}

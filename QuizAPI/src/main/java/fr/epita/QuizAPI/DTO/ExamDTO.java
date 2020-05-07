package fr.epita.QuizAPI.DTO;

import fr.epita.QuizAPI.Error.GeneralError;
import fr.epita.quiz.datamodel.Exam;

public class ExamDTO extends GeneralError {
	
	private Long id;
	private String title;
	
	public ExamDTO() {
		
	}

	public ExamDTO(Exam exam) {
		this.title = exam.getTitle();
		this.id = exam.getId();
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

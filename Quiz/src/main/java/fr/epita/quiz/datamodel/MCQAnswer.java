package fr.epita.quiz.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MCQAnswer")
public class MCQAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="Exam_FK")
	private Exam exam;
	
	@ManyToOne
	@JoinColumn(name="Student_FK")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="MCQChoise_FK")
	private MCQChoice choice;

	public MCQAnswer() {
	
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public MCQChoice getChoice() {
		return choice;
	}

	public void setChoice(MCQChoice choice) {
		this.choice = choice;
	}
}

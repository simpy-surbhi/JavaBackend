package fr.epita.quiz.datamodel;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="Answer")
@Proxy(lazy = false)
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="a_content")
	private String answer;

	@ManyToOne
	@JoinColumn(name="Question_FK")
	private Question question;
	
	@ManyToOne
	@JoinColumn(name="Exam_FK")
	private Exam exam;
	
	@ManyToOne
	@JoinColumn(name="Student_FK")
	private Student student;
	
	public Answer() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
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
}

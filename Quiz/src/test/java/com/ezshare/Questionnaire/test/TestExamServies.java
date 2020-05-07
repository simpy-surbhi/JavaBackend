package com.ezshare.Questionnaire.test;

import java.util.UUID;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.businessservice.ExamBusinessServices;
import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.Student;
import fr.epita.quiz.exceptions.ExamBusinessException;
import fr.epita.quiz.services.ExamDAO;
import fr.epita.quiz.services.QuestionDAO;
import fr.epita.quiz.services.StudentDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationcontext.xml")
public class TestExamServies {
	
	@Inject
	ExamBusinessServices exambusinessservices;
	
	@Inject
	StudentDAO studentDAO;
	
	@Inject
	QuestionDAO questionDAO;
	
	@Inject
	ExamDAO examDAO;
	
	@Test
	public void test() {
		
		Student student = new Student();
		student.setName(UUID.randomUUID().toString());
		studentDAO.create(student);
		
		Question question = new Question();
		question.setTitle("What is Java");
		questionDAO.create(question);
		
		
		Exam exam = new Exam();
		exam.setTitle("Java Assignment");
		examDAO.create(exam);
		
		
		Answer answer = new Answer();
		
		try {
			exambusinessservices.answerQuestion(student, question, answer, exam);
		} catch (ExamBusinessException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}

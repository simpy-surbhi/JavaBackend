package com.ezshare.Questionnaire.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.QuestionDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationcontext.xml")
public class TestQuestionDao {
	
	@Inject
	QuestionDAO dao;
	
	@Test
	public void test() {
		
		Question question = new Question();
		question.setTitle("What is a dependency?");
		dao.create(question);
		
		System.out.println(dao.getById((long) question.getId()).getTitle());
		
		question.setTitle("Who is vishal");
		
		dao.update(question);
		
		System.out.println(dao.getById((long) question.getId()).getTitle());
		
		List<Question> list = dao.search(question,"title");
		System.out.println(list.get(0).getTitle());
		
	}
}
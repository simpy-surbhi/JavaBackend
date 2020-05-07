package com.ezshare.Questionnaire.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.services.StudentDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationcontext.xml")
public class TestStudentDAO {
	
	@Inject
	StudentDAO dao;
	
	@Test
	public void test() {
		
	}
}

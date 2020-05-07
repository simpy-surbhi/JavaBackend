package fr.epita.quiz.businessservice;

@SuppressWarnings("serial")
public class BusinessExceptions extends Exception {
	
	public BusinessExceptions(String exception) {
		System.out.println(exception);
	}
}

package fr.epita.QuizAPI.Error;

public class GeneralError {
	
	private String error;
	
	public GeneralError() {
	
	}
	
	public GeneralError(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}

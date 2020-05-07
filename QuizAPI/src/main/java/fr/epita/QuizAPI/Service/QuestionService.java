package fr.epita.QuizAPI.Service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.epita.QuizAPI.DTO.QuestionDTO;
import fr.epita.QuizAPI.Error.GeneralError;
import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.ExamDAO;
import fr.epita.quiz.services.MCQChoiceDAO;
import fr.epita.quiz.services.QuestionDAO;

@Path("/Questions")
public class QuestionService {

	@Inject
	QuestionDAO questionDAO;
	
	@Inject
	ExamDAO examDAO;
	
	@Inject
	MCQChoiceDAO mcqChoiceDAO;

	@POST
	@Path("/createQuestion")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response createQuestion(@RequestBody QuestionDTO questionDTO) {

		if (questionDTO.getTitle() == null) {
			return Response.ok(new GeneralError("Question is empty")).build();
		}

		Question question = new Question();
		question.setTitle(questionDTO.getTitle());

		questionDAO.create(question);

		questionDTO.setId(question.getId());
		return Response.status(Status.OK).entity(questionDTO).build();
	}

	@GET
	@Path("/getAllQuestion")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAllQuestion() {
		List<Question> list = questionDAO.getAll();
		return Response.status(Status.OK).entity(list).build();
	}
	
	@POST
	@Path("/deleteQuestion")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response deleteQuestion(@RequestBody QuestionDTO questionDTO) {

		if (questionDTO.getId() == null) {
			return Response.ok(new GeneralError("Question is empty")).build();
		}
		
		mcqChoiceDAO.deleteChild(questionDTO.getId(), "question");
		questionDAO.delete(questionDTO.getId());
		return Response.status(Status.OK).entity(questionDTO).build();
	}
}

package fr.epita.QuizAPI.Service;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.QuizAPI.DTO.ExamDTO;
import fr.epita.QuizAPI.Error.GeneralError;
import fr.epita.quiz.businessservice.ExamBusinessServices;
import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.services.AnswerDAO;
import fr.epita.quiz.services.ExamDAO;
import fr.epita.quiz.services.QuestionDAO;

@Path("/exam")
public class ExamService {
	
	@Inject
	ExamBusinessServices exambusinessservice;
	
	@Inject
	AnswerDAO answerDAO;
	
	@Inject
	ExamDAO examDAO;
	
	@Inject
	QuestionDAO questionDAO;
	
	@GET
	@Path("/answer")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response answer() {
		
		Answer answer = new Answer();
		answer.setId(1l);
		
        Response response = Response.status(Status.OK).entity(answer).build();
        return response;
	}
	
	@POST
	@Path("/answer")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response questionToAnswer(@RequestBody Answer answer) {
		try {
			return Response.created(new URI("/rest/exam/answer/" + answer.getId())).status(Status.OK).build();
		} catch (URISyntaxException e) {
			System.out.println(e.getLocalizedMessage());
		}
		return Response.serverError().build();
	}
	
	@GET
	@Path("/answer/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAnswer(@PathParam("id") long answerId) {
		Answer answer = answerDAO.getById(answerId);
		Response response = Response.ok(answer).build();
		return response;
	}
	
	@POST
	@Path("/createExam")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response createExam(@RequestBody ExamDTO examDTO) {
		
		if(examDTO == null || examDTO.getTitle() == null) {
			return Response.ok(new GeneralError("Exam can not create")).build();
		}
		
		Exam exam = new Exam();
		exam.setTitle(examDTO.getTitle());
		
		examDAO.create(exam);
		
		examDTO.setId(exam.getId());
		Response response = Response.ok(examDTO).build();
		return response;
	}
	
	@GET
	@Path("/getAllExam")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAnswer() {
		Response response = Response.ok(examDAO.getAll()).build();
		return response;
	}
	
	@POST
	@Path("/deleteExam")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response deleteExam(@RequestBody ExamDTO examDTO) {
		if(examDTO == null) {
			return Response.ok(new GeneralError("Exam can not deleted")).build();
		}
		
		examDAO.delete(examDTO.getId());
			
		Response response = Response.ok(examDTO).build();
		return response;
	}
	
	@POST
	@Path("/updateExam")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response updateExam(@RequestBody ExamDTO examDTO) {
		if(examDTO == null) {
			return Response.ok(new GeneralError("Exam can not update")).build();
		}
		
		Exam exam = new Exam();
		exam.setId(examDTO.getId());
		exam.setTitle(examDTO.getTitle());
		
		examDAO.update(exam);
		
		Response response = Response.ok(examDTO).build();
		return response;
	}
}

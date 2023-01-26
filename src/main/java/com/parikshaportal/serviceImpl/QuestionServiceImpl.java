package com.parikshaportal.serviceImpl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parikshaportal.model.exam.Question;
import com.parikshaportal.model.exam.Quiz;
import com.parikshaportal.repository.QuestionRepository;
import com.parikshaportal.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public Question addQuestion(Question question) {
		
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestion() {
		
		return new HashSet<>(this.questionRepository.findAll());
	}
	
	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz){
		
		return this.questionRepository.findByQuiz(quiz);
		
	}

	@Override
	public Question getQuestion(Long quesId) {
		
		return this.questionRepository.findById(quesId).get();
	} 

	@Override
	public void deleteQuestion(Long quesId) {
		
		Question question =new Question();
		
		question.setQuesId(quesId);
		
		this.questionRepository.delete(question);
	}

	@Override
	public Question get(Long questionId) {
		
		return this.questionRepository.getOne(questionId);
	}

}

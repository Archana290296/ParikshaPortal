package com.parikshaportal.service;

import java.util.Set;

import com.parikshaportal.model.exam.Question;
import com.parikshaportal.model.exam.Quiz;


public interface QuestionService {
	
	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public Set<Question> getQuestion();
	public Question getQuestion(Long quesId);
	public void deleteQuestion(Long quesId);
	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
	
	public Question get(Long questionId);

}

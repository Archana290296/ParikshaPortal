package com.parikshaportal.service;

import java.util.List;
import java.util.Set;



import com.parikshaportal.model.exam.Category;
import com.parikshaportal.model.exam.Quiz;

public interface QuizService {
	
	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public Set<Quiz> getQuiz();
	public Quiz getQuiz(Long quizId);
	public void deleteQuiz(Long quizId);
	public List<Quiz> getQuezzesOfCategory(Category category);
	
	// get active quizes
	
	public List<Quiz> getActiveQuizzes();
	public List<Quiz> getActiveQuizzesOfCategory(Category c);

}

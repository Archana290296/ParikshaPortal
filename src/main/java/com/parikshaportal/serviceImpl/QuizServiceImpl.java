package com.parikshaportal.serviceImpl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parikshaportal.model.exam.Category;
import com.parikshaportal.model.exam.Quiz;
import com.parikshaportal.repository.QuizRepository;
import com.parikshaportal.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuiz() {
		
		return new LinkedHashSet<>(this.quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		
		return this.quizRepository.findById(quizId).get();
	}

	@Override
	public void deleteQuiz(Long quizId) {
		Quiz quiz=new Quiz();
		
		quiz.setQid(quizId);
		
		this.quizRepository.delete(quiz);
	}

	@Override
	public List<Quiz> getQuezzesOfCategory(Category category) {
		
		return this.quizRepository.findByCategory(category);
	}

	@Override
	public List<Quiz> getActiveQuizzes() {
		
		return this.quizRepository.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizzesOfCategory(Category c) {
		
		return this.quizRepository.findByCategoryAndActive(c, true);
	}

}

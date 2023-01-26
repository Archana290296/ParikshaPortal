package com.parikshaportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parikshaportal.model.exam.Category;
import com.parikshaportal.model.exam.Quiz;
import com.parikshaportal.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	// add quiz
		@PostMapping("/")
		public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz)
		{
			
			Quiz quiz1=this.quizService.addQuiz(quiz);
			
			return ResponseEntity.ok(quiz1);
		}
		
		//get quiz
		@GetMapping("/{quizId}")
		public Quiz getQuiz(@PathVariable("qid") Long qid)
		{
			return this.quizService.getQuiz(qid);
		}
		
		//get all quizes
			@GetMapping("/")
			public ResponseEntity<?> getQuizes()
			{
				return ResponseEntity.ok(this.quizService.getQuiz());
			}
			
		// update quiz
			@PutMapping("/")
			public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz)
			{
				return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
			}
			
	   //delete quiz
			@DeleteMapping("/{qid}")
			public void deleteQuiz(@PathVariable("qidd") Long qid)
			{
				this.quizService.deleteQuiz(qid);
			}
			
			
			@GetMapping("/category/{cid}")
			public List <Quiz> getQuezzesOfCategory(@PathVariable("cid") Long cid)
			{
				Category category=new Category();
				category.setCid(cid);
				return this.quizService.getQuezzesOfCategory(category);
			}
			
			// get active quizzes
			
			@GetMapping("/active")
			public List<Quiz> getActiveQuizzes(){
				
				return this.quizService.getActiveQuizzes();
			}
			
			// get active quizzes of category
			
						@GetMapping("/category/active/{cid}")
						public List<Quiz> getActiveQuizzesOfCategory(@PathVariable("cid")  Long cid ){
							
							Category category=new Category();
							category.setCid(cid);
							
							return this.quizService.getActiveQuizzesOfCategory(category);
						}
						

}

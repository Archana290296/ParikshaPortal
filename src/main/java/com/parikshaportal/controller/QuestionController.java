package com.parikshaportal.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import com.parikshaportal.model.exam.Question;
import com.parikshaportal.model.exam.Quiz;
import com.parikshaportal.service.QuestionService;
import com.parikshaportal.service.QuizService;

import io.jsonwebtoken.lang.Collections;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired 
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	// add question
		@PostMapping("/")
		public ResponseEntity<Question> addQuestion(@RequestBody Question question)
		{
			
			Question question1=this.questionService.addQuestion(question);
			
			return ResponseEntity.ok(question1);
		}
		
		//get question
		@GetMapping("/{quesId}")
		public Question getQuestion(@PathVariable("quesId") Long quesId)
		{
			return this.questionService.getQuestion(quesId);
		}
		
		//get all question of any quiz
			@GetMapping("/quiz/{qid}")
			public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid)
			{
				
				/*
				 * //this will give us all the questions
				 *  Quiz quiz=new Quiz(); 
				 *  quiz.setQid(qid);
				 * Set<Question> questionsOfQuiz=this.questionService.getQuestionsOfQuiz(quiz);
				 * return ResponseEntity.ok(questionsOfQuiz);
				 */
				
				Quiz quiz=this.quizService.getQuiz(qid);
				Set<Question> questions=quiz.getQuestions();
				List<Question> list=new ArrayList<>(questions);
				
				if(list.size() > Integer.parseInt(quiz.getNumberOfQuestions()))
				{
					list=list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
				}
				
				list.forEach(q ->{
					q.setAnswer("");
				});
				
				java.util.Collections.shuffle(list);
				return ResponseEntity.ok(list);
			}
			
		// update question
			@PutMapping("/")
			public ResponseEntity<Question> updateQuestion(@RequestBody Question question)
			{
				return ResponseEntity.ok(this.questionService.updateQuestion(question));
			}
			
	   //delete question
			@DeleteMapping("/{quesId}")
			public void deleteQuestion(@PathVariable("quesId") Long quesId)
			{
				this.questionService.deleteQuestion(quesId);
			}

	 // evaluate quiz
			@PostMapping("/eval-quiz")
			public  ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions)
			{
				
				double marksGot=0;
				int correctAnswers=0;
				int attempted=0;
				
				System.out.println(questions);
				
				for(Question q: questions) {
					//System.out.println(q.getGivenAnswer());
					
					// single question- this answer is given by user
					
					Question que= this.questionService.get(q.getQuesId());
					
					if(que.getAnswer().equals(que.getGivenAnswer()))
					{
						//correct
						correctAnswers++;
						
						double marksSingle=Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
						marksGot +=marksSingle;
					}
					if (q.getGivenAnswer()!=null )
							{
								attempted++;
							}
					
				};
				
				Map<String, Object> map=Map.of("marksGot",marksGot,"correctAnswers",correctAnswers,"attempted",attempted);

				return ResponseEntity.ok(map);
			}
}

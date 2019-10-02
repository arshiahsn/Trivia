import java.io.*;
import java.util.Collections;
import java.util.Scanner;

public class TriviaGame
{
	private TriviaData questions;	// Questions
	private int score;
	private Scanner keyboard;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public TriviaData getQuestions() {
		return questions;
	}

	public void setQuestions(TriviaData questions) {
		this.questions = questions;
	}

	public TriviaGame()
	{
		keyboard = new Scanner(System.in);
		score = 0;
		// Load questions
		setQuestions(new TriviaData());
		getQuestions().addFreeFormQuestion("The possession of more than two sets of chromosomes is termed?",
				"polyploidy", 3);
		getQuestions().addTrueFalseQuestion("Erling Kagge skiied into the north pole alone on January 7, 1993.",
				"F", 1);
		getQuestions().addFreeFormQuestion("1997 British band that produced 'Tub Thumper'",
				"Chumbawumba", 2);
		getQuestions().addFreeFormQuestion("I am the geometric figure most like a lost parrot",
				"polygon", 2);
		getQuestions().addTrueFalseQuestion("Generics were introducted to Java starting at version 5.0.",
				"T", 1);
		Collections.shuffle(getQuestions().getData());
	}

	public void parseQuestion(TriviaQuestion _question, String answer){
		//Parse the question and check the answer
		if (_question instanceof TrueFalseQuestion)
		{
			if (answer.charAt(0) == _question.getAnswer().charAt(0))
			{
				System.out.println("That is correct!  You get " + _question.getValue() + " points.");
				setScore(getScore() + _question.getValue());
			}
			else
			{
				System.out.println("Wrong, the correct answer is " + _question.getAnswer());
			}
		}
		else if (_question instanceof FreeFormQuestion)
		{
			if (answer.toLowerCase().equals(_question.getAnswer().toLowerCase()))
			{
				System.out.println("That is correct!  You get " + _question.getValue() + " points.");
				setScore(getScore() + _question.getValue());
			}
			else
			{
				System.out.println("Wrong, the correct answer is " + _question.getAnswer());
			}
		}

	}

	public void printScore(){
		System.out.println("Your score is " + getScore());
	}

	public void printQuestion(int _questionNo){
		// Show question
		getQuestions().showQuestion(_questionNo);
	}

	public TriviaQuestion getQuestion(int _questionNo){
		return getQuestions().getQuestion(_questionNo);
	}
	public String getAnswer(){
		return keyboard.nextLine();
	}
	public int getNumberOfQuestions(){
		return getQuestions().numQuestions();
	}

	// Main game loop
	public static void main(String[] args)
	{
		int questionCounter = 0;	// Which question we're asking
		TriviaGame game = new TriviaGame();

		// Ask a question as long as we haven't asked them all
		while (questionCounter < game.getNumberOfQuestions())
		{
			game.printQuestion(questionCounter);
			game.parseQuestion(game.getQuestion(questionCounter), game.getAnswer());
			game.printScore();
			questionCounter++;
		}
		System.out.println("Game over!  Thanks for playing!");
	}
}
	


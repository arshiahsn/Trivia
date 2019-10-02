

public abstract class TriviaQuestion
{
	//public static final int TRUEFALSE = 0;
	//public static final int FREEFORM = 1;

	private String question;		// Actual question
	private String answer;		// Answer to question
	private int value;			// Point value of question
	//public int type;			// Question type, TRUEFALSE or FREEFORM


	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TriviaQuestion(String _question, String _answer, int _value)
	{
		question = _question;
		value = _value;
		answer = _answer;
	}

	public void printQuestion(){
		System.out.println(getQuestion());
	}
}

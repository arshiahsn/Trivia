import java.util.ArrayList;
import java.util.List;

public class TriviaData
{
	private List<TriviaQuestion> data;

	public List<TriviaQuestion> getData() {
		return data;
	}

	public void setData(List<TriviaQuestion> data) {
		this.data = data;
	}


	public TriviaData()
	{
		data = new ArrayList<TriviaQuestion>();
	}

	public void addTrueFalseQuestion(String _question, String _answer, int _value)
	{
		TriviaQuestion question = new TrueFalseQuestion(_question, _answer, _value);
		data.add(question);
	}

	public void addFreeFormQuestion(String _question, String _answer, int _value)
	{
		TriviaQuestion question = new FreeFormQuestion(_question, _answer, _value);
		data.add(question);
	}

	public void showQuestion(int index)
	{
		TriviaQuestion _question = getData().get(index);
		System.out.println("Question " + (index +1) + ".  " + _question.getValue() + " points.");
		_question.printQuestion();
	}
	public int numQuestions()
	{
		return getData().size();
	}

	public TriviaQuestion getQuestion(int index)
	{
		return getData().get(index);
	}
}

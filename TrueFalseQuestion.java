public class TrueFalseQuestion extends TriviaQuestion {
    public TrueFalseQuestion(String _question, String _answer, int _value) {
        super(_question, _answer, _value);
    }

    public void printQuestion(){
        super.printQuestion();
        System.out.println("Enter 'T' for true or 'F' for false.");
    }
}

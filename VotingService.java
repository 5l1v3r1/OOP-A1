import java.util.ArrayList;

public class VotingService {
    private Question question;
    private ArrayList<Character> answers = new ArrayList<Character>();

    public VotingService(Question question){
        this.question = question;
    }

    public int getLen(){
        return answers.size();
    }

    public void displayQuestion(){
      System.out.println(question.getQuestion());
    }

    public void displayChoices(){
        System.out.println(question.getChoices());
    }

    public void displayAns(){
        System.out.println(question.getAnswer());
    }




    
}

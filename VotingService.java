import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VotingService {
    private Question question;
    private Map<String, Character> answers = new HashMap<String, Character>();

    public VotingService(Question question){
        this.question = question;
    }

    public int getAnsLen(){
        return answers.size();
    }

    public void displayQuestion(){
      System.out.println(question.getQuestion());
    }

    public void displayChoices(){
        for(String choice: question.getChoices()){
            if(choice != null){
                System.out.println(choice);
            }
            
        }
        
    }

    public void displayAns(){
        System.out.println("Correct Answer: " + question.getAnswer());
    }

    public void acceptAns(char ans, String id){
        answers.put(id,ans);
    }

    public void displayResponses(){
        Set<String> keySet = answers.keySet();
        if(question.getLenChoices() == 4){
            int aCount = 0;
            int bCount = 0;
            int cCount = 0;
            int dCount = 0;


            for (String key : keySet){
                char value = answers.get(key);
                if(value == 'A'){
                    aCount++;
                }
                else if(value == 'B'){
                    bCount++;
                }
                else if(value == 'C'){
                    cCount++;
                }
                else if(value == 'D'){
                    dCount++;
                }
            } 

            System.out.println(aCount + " people have voted A");
            System.out.println(bCount + " people have voted B");
            System.out.println(cCount + " people have voted C");
            System.out.println(dCount + " people have voted D");
        }
        else{
            int tCount = 0;
            int fCount = 0;



            for (String key : keySet){
                char value = answers.get(key);
                if(value == 'T'){
                    tCount++;
                }
                else if(value == 'F'){
                    fCount++;
                }
          
            } 

            System.out.println(tCount + " people have voted true");
            System.out.println(fCount + " people have voted false");
        }
    }  
}

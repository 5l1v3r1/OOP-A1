// interface Question{
//     void displayQuestion();
//     void displayAnswer();
// }
// I was originally going to create an interface and two classes that extend it, one for multipel choice and one for T/F.
// Until I realized the two classes were exactly the same. 

public class Question{
    private String question;
    private char ans;
    private String[] choices;

    public Question(String question, char ans){
        this.question = question;
        this.ans = ans;
    }
    

    public String getQuestion() {
        return question;

    }
    
    public String[] getChoices(){
        return choices;
    }
    
    public char getAnswer() {
        return ans;
    }




}

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SimulationDriver {

    // in this case, I just hard coded 5 students
    // however, instead I could have generated random numbers for id 
    // and add to arbitrarly sized arraylist to create a scalable solution
    
    private static Student[] populateStudents() {
        Student[] students = new Student[10];
        // IDs just need to be strings right?
        students[0] = new Student("yeet");
        students[1] = new Student("yikes");
        students[2] = new Student("yahoo");
        students[3] = new Student("yada");
        students[4] = new Student("yes");
        students[5] = new Student("yellow");
        students[6] = new Student("yesandno");
        students[7] = new Student("yas-min-e");
        students[8] = new Student("yachty");
        students[9] = new Student("yippee!");
        return students;
    }



    private static void round(Student[] students, Question q) {
        VotingService v = new VotingService(q);

        try {

            v.displayQuestion();
            v.displayChoices();
            TimeUnit.SECONDS.sleep(1);
            System.out.println("--------------");
            

            // luckily, answers are submitted into a map
            // map.put() a this neat functionality built in
            // multiple submissions will overwrite/update the value on file for the respective key
            // this design always takes the latest submission
            for(Student dude: students){
                v.acceptAns(dude.vote(q.getLenChoices()), dude.getID());
            }


            v.displayResponses();

            TimeUnit.SECONDS.sleep(1);
            System.out.println("--------------");
            v.displayAns();

            TimeUnit.SECONDS.sleep(3);
            String msg = 
          "    /^^^^    /^^     /^^/^^/^^^^^^^ /^^     /^^       /^^      /^         /^^ ^^  /^^^ /^^^^^^/^^^^^^^^/^^^^^^^    \n" +
          "  /^^    /^^ /^^     /^^/^^       /^^       /^ /^^   /^^^     /^ ^^     /^^    /^^     /^^    /^^      /^^    /^^  \n" +
          "/^^       /^^/^^     /^^/^^      /^^        /^^ /^^ / /^^    /^  /^^     /^^           /^^    /^^      /^^    /^^  \n" +
          "/^^       /^^/^^     /^^/^^    /^^          /^^  /^^  /^^   /^^   /^^      /^^         /^^    /^^^^^^  /^ /^^      \n" +
          "/^^       /^^/^^     /^^/^^   /^^           /^^   /^  /^^  /^^^^^^ /^^        /^^      /^^    /^^      /^^  /^^    \n" +
          "  /^^ /^ /^^ /^^     /^^/^^ /^^             /^^       /^^ /^^       /^^ /^^    /^^     /^^    /^^      /^^    /^^  \n" +
          "    /^^ ^^     /^^^^^   /^^/^^^^^^^^^^^     /^^       /^^/^^         /^^  /^^ ^^       /^^    /^^^^^^^^/^^      /^^\n" +
          "         /^                                                                                                        \n";
    
            System.out.println(msg);
      
            





        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        
        
    }


    // helper function to help process choices into an arraylist
    // later passed to Question constructor
    private static ArrayList<String> buildChoices(String c1, String c2, String c3, String c4){
        ArrayList<String> choices = new ArrayList<String>();
        choices.add("A. " + c1);
        choices.add("B. " + c2);
        choices.add("C. " + c3);
        choices.add("D. " + c4);
        return choices;
    }


    // if buildChoices is called without parameters, it is assumed as a T/F question.
    private static ArrayList<String> buildChoices(){
        ArrayList<String> choices = new ArrayList<String>();
        choices.add("[T]rue");
        choices.add("[F]alse");
        return choices;
    }

    
    // once again, a hard coded, arbitrary solution for the sake of simulation
    // one easily use a local database or connect to a MongoDB cluster
 
    private static Question[] populateQuestions(){
        Question[] q = new Question[4];
  
        
        q[0] = new Question("Where is Ireland?", 'C', buildChoices("Canada", "U.S.", "China", "Great Britain"));
        q[1] = new Question("The boiling point of water is 50 degrees celcius.", 'F', buildChoices());
        q[2] = new Question("Which is the heaviest?", 'D', buildChoices(
        "1 tonne of feathers",
        "1 tonne of steel",
        "1 tonne of bronze",
        "1 tonne of holy water"));
        q[3] = new Question("Oxygen is toxic", 'T', buildChoices());

        return q;
    }

    public static void main(String[] args) {
        Student[] students = populateStudents();
        int questionNum = 0;
        Question[] qlist = populateQuestions();

        while(questionNum < qlist.length){
            round(students, qlist[questionNum]);
            questionNum++;
        }
        


    }
}

import java.util.Random;

public class Student {
    private String studentID;
    // students don't need names :)
    
    public Student(String studentID){
        this.studentID = studentID;
    }

    public String getID(){
        return studentID;
    }

    public char vote(int choices){
        // this method simply generates a number [0-1] || [0-3] and returns related char
        Random rand = new Random();
        int n = rand.nextInt(choices);

        if(choices == 2){
            if(n == 0){
                return 'T';
            }
            else{
                return 'F';
            }
        }
        else{
            if(n == 0){
                return 'A';
            }
            else if(n == 1){
                return 'B';
            }
            else if(n == 2){
                return 'C';
            }
            else if(n == 3){
                return 'D';
            }
        }

        return '0';
    }



}
import javax.management.Query;

public class SimulationDriver {


    private static Student[] populateStudents(){
        Student[] students = new Student[5];
        // IDs just need to be strings right?
        students[0] = new Student("yeet");
        students[1] = new Student("yikes");
        students[2] = new Student("yahoo");
        students[3] = new Student("yada");
        students[4] = new Student("yes");
        return students;
    }

    private static void round(Student[] students) {
        Question q = new Question("Where is the capital of Spain?", 'A');
        VotingService v = new VotingService(q);
        v.displayQuestion();
        v.displayChoices();
        System.out.println(v.getLen());
        v.displayAns();
    }

    

    private static Question[] populateQuestions(){
        Question[] q = new Question[10];
    }

    public static void main(String[] args) {
        Student[] students = populateStudents();
        round(students);


    }
}

Online Quiz System
'''
import java.util.*;
class Question {
    String question, optionA, optionB, optionC, optionD, correctAnswer;
    public Question(String question, String a, String b, String c, String d, String correct) {
        this.question = question;
        this.optionA = a;
        this.optionB = b;
        this.optionC = c;
        this.optionD = d;
        this.correctAnswer = correct;
    }
}
public class OnlineQuizSystem {
    private static final Scanner sc = new Scanner(System.in);
    private static int score = 0;
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("\n⏰ Time's up!");
                showResult();
                System.exit(0);
            }
        }, 60000); 
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Which is the capital of India?",
                "A. Mumbai", "B. Delhi", "C. Kolkata", "D. Chennai", "B"));
        questions.add(new Question("Which language is platform-independent?",
                "A. C", "B. C++", "C. Java", "D. Python", "C"));
        questions.add(new Question("Who is known as father of Computer?",
                "A. Charles Babbage", "B. Alan Turing", "C. Bill Gates", "D. Steve Jobs", "A"));
        for (Question q : questions) {
            System.out.println("\n" + q.question);
            System.out.println(q.optionA);
            System.out.println(q.optionB);
            System.out.println(q.optionC);
            System.out.println(q.optionD);
            System.out.print("Your answer (A/B/C/D): ");
            String ans = sc.next().toUpperCase();
            if (ans.equals(q.correctAnswer)) {
                score++;
            }
        }
        timer.cancel();
        showResult();
    }
    private static void showResult() {
        System.out.println("\n📊 Quiz Over!");
        System.out.println("Your Score: " + score);
    }
}
import java.util.*;
class Question {
    String question, optionA, optionB, optionC, optionD, correctAnswer;
    public Question(String question, String a, String b, String c, String d, String correct) {
        this.question = question;
        this.optionA = a;
        this.optionB = b;
        this.optionC = c;
        this.optionD = d;
        this.correctAnswer = correct;
    }
}
public class OnlineQuizSystem {
    private static final Scanner sc = new Scanner(System.in);
    private static int score = 0;
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("\n⏰ Time's up!");
                showResult();
                System.exit(0);
            }
        }, 60000); 
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Which is the capital of India?",
                "A. Mumbai", "B. Delhi", "C. Kolkata", "D. Chennai", "B"));
        questions.add(new Question("Which language is platform-independent?",
                "A. C", "B. C++", "C. Java", "D. Python", "C"));
        questions.add(new Question("Who is known as father of Computer?",
                "A. Charles Babbage", "B. Alan Turing", "C. Bill Gates", "D. Steve Jobs", "A"));
        for (Question q : questions) {
            System.out.println("\n" + q.question);
            System.out.println(q.optionA);
            System.out.println(q.optionB);
            System.out.println(q.optionC);
            System.out.println(q.optionD);
            System.out.print("Your answer (A/B/C/D): ");
            String ans = sc.next().toUpperCase();
            if (ans.equals(q.correctAnswer)) {
                score++;
            }
        }
        timer.cancel();
        showResult();
    }
'''
    private static void showResult() {
        System.out.println("\n📊 Quiz Over!");
        System.out.println("Your Score: " + score);
    }
}

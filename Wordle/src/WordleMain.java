import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.lang.reflect.Array;
import java.util.*;

public class WordleMain {
    public static void main(String[] args) {
        //this part of code will take all the words from the list and store it all in allWords
        ArrayList<String> allWords = new ArrayList<String>();
        try {
            File myObj = new File("C:\\Users\\Orange\\Desktop\\AP CSA\\Wordle\\src\\wordle.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                allWords.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        boolean game = true;
        boolean correct = true;

        int tick = 0;
        while (game) {
            int winner = 0;
            System.out.println("Do you want to play wordle? (y/n)");
            Scanner sc = new Scanner(System.in);
            String response = sc.nextLine();
            tick = 0;
            correct = true;
            if (response.equals("y")) {

                while (tick <= 5) {
                    int wordselect = (int) ((Math.random() * allWords.size()));
                    String word = allWords.get(wordselect);
                    //set up arraylist of defined word
                    ArrayList<String> word1 = new ArrayList<>();
                    word1 = getLetters(word);
                    System.out.println(word1);

                    while (correct && tick <= 5) {
                        System.out.println("Enter a word");
                        String guess = sc.nextLine();
                        ArrayList<String> guess1 = new ArrayList<>();
                        guess1 = getLetters(guess);



                        //check if anything is in the right place
                        int wCounter = 0;
                        for (int i = 0; i < guess1.size(); i++) {
                            if (guess1.get(i).equals(word1.get(wCounter))) {
                                System.out.println(guess1.get(i) + " is in the right place");
                                winner++;


                            } else {
                                if (existsInArray(word1, guess1.get(i))) {
                                    System.out.println(guess1.get(i) + " is in the word but in the wrong place");
                                    winner = 0;
                                }


                            }
                            wCounter++;
                            if (winner > 4){
                                System.out.println("Congrats! That was correct");
                                tick+= 5000;
                                correct = false;
                            }
                        }
                        tick++;
                    }
                }
                System.out.println("Thanks for playing.");

            }
            else{
                game = false;

            }

        }
    }

    public static ArrayList<String> getLetters(String a) {
        ArrayList<String> b = new ArrayList<>();

        for (int i = 0; i < a.length(); i++) {
            b.add(a.substring(i, i + 1));
        }

        return b;
    }

    public static boolean existsInArray(ArrayList<String> a, String check) {
        boolean toggle = false;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals(check)) {
                toggle = true;
            }
        }
        System.out.println();
        if (toggle)
            return true;
        else
            return false;

    }
}
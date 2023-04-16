import java.util.*;
//this class is used to represent the word people are trying to solve.
public class wordleObject
{
    private String[] letters;  //size 5
    private ArrayList<String> alphabet;  //everytime a user guesses a letter, take out a letter

    public wordleObject(String[] letters)
    {
        this.letters = letters;
        alphabet = new ArrayList<String>();
        String[] x = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w"
                , "x", "y", "z",};
        for (String temp : x)
            alphabet.add(temp);
    }

    //setter getter constrcutor toString
}
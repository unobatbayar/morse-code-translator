import java.util.*;
/**
 * @author unobatbayar
 * Morse code translator, Translator class
 */
class Translator {

    public String userInput;

    public Translator(String input){
        userInput = input;
    }
    // A-Z 1-9-0 in order
    public String[] textAndNumbers = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
    "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", 
    "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

    // morse code international in order
    public String[] morseCode = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
    ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
    "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
    "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
    "-----"};
    
    public String toMorse(){
        // morse code to return
        String morse = "";
        // nested for loop to check each letter
        for(int i = 0; i <userInput.length(); i++){
            for(int k = 0; k <morseCode.length; k++){
                if (userInput.substring(i, i + 1).equals(textAndNumbers[k])){
                    morse = morse + " " + morseCode[k];
                }
            }
            if (userInput.substring(i, i +1).contains(" ")){
                morse = morse + " / ";
            }
        }
        // Removing extra space from front
        morse = morse.substring(1, morse.length());
        return morse;
    }

    public String toText(){
        // text to return
        String text = "";
        // string split by "/" because that's how we divided words,
        String[] words = userInput.split("/");
        for(int i = 0; i<words.length; i++){
            // Temporary varibale to store a word (empty every loop)
            String word = "";
            // the divide the letters by space.
            String[] letters = words[i].split("\\s+");
            for(int k = 0; k<letters.length; k++){
                for(int j = 0; j <textAndNumbers.length; j++){
                    if (letters[k].equals(morseCode[j])){
                        word = word + textAndNumbers[j];
                    }
                }
            }
            text = text + " " + word;
        }
        // Removing extra space from front
        text = text.substring(1, text.length()); 
        return text;
    }
}


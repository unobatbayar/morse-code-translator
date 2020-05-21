import java.util.*;
/**
 * @author unobatbayar
 * Translator 
 */

 // A-Z 1-9-0 Morse Code International 
class Translator {

    private Hashtable<String, String> morseHashtable = new Hashtable<>();

    private String[] textAndNumbers = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"}; 

    private String[] morseCode = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"};
    
    public Translator(){

        for(int i = 0; i<morseCode.length; i++){
            morseHashtable.put(textAndNumbers[i], morseCode[i]);
            morseHashtable.put(morseCode[i], textAndNumbers[i]);
        }
    }

    public String translate(String input){

        String translated = "";

        // found text
        if(Character.isLetter(input.charAt(0)) || Character.isDigit(input.charAt(0))){
            for(int i = 0; i <input.length(); i++){
                if(morseHashtable.containsKey(input.charAt(i) + "")) translated += " " + morseHashtable.get(input.charAt(i) + "");
                if (input.substring(i, i + 1 ).equals(" ")) translated += "/";     
            }
            
            return translated.substring(1);
        }

        // found Morse code
        String[] words = input.split("/");

        for(int i = 0; i < words.length; i++){
            // the divide the letters by space.
            String[] letters = words[i].split("\\s+");
            String word = "";
            for(int k = 0; k < letters.length; k++){
                if(morseHashtable.containsKey(letters[k])) word += morseHashtable.get(letters[k]);
            }

            translated += " " + word;
        }

        return translated.substring(1);
    }
}


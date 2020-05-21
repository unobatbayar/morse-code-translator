import java.util.*;
/**
 * @author unobatbayar
 * Main
 */
class Main {
    private static Translator morseTranslator = new Translator();
    public static void main (String[] args){
        showMenu("Welcome to Morse Code translator by Uno!");
        mainLoop();
    }
    
    private static void mainLoop(){
        String choice = getInput();

        if(choice.equals(":wq")) System.exit(0);
        if(choice.length() > 0) print(morseTranslator.translate(choice.toLowerCase())+ "\n");
        else showMenu("Nothing to translate...");

        mainLoop();
    }

    private static void showMenu(String title){
        print( "\n" + title + " (type ':wq' to exit)" + "\n" + "-> Start by entering text or morse:");
    }

    private static void print(String message){
        System.out.println(message);
    }

    private static String getInput()
    {
        Scanner scanner = new Scanner(System.in);  
        return scanner.nextLine();  
    }
}


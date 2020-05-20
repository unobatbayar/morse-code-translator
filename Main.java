import java.util.*;
/**
 * @author unobatbayar
 * Morse code translator, Main class
 */
class Main {
    public static void main (String[] args){
        showMenu();
        mainLoop();
    }
    // our main steps
    public static void mainLoop(){
        
        // get user choice
        String choice = getInput();

        // function depending on the choice
        switch (choice.toLowerCase()){
            case "morse":
                print( "\n" + "Please enter the text to convert to morse: ");
                Translator morseTranslator = new Translator(getInput().toLowerCase());
                print(morseTranslator.toMorse()+ "\n");
                break;
            case "text":
                print("\n" + "Please enter the morse code to convert to text: ");
                Translator textTranslator = new Translator(getInput().toLowerCase());
                print(textTranslator.toText() + "\n");
                break;
            case "menu":
                showMenu();
                break;
            case "exit":
                System.exit(0);
            default:
                print("Error, please try again.");
                break;
        }

        mainLoop();
    }

    public static void showMenu(){
        print( "\n" +
        "Welcome to Morse Code translator by Uno!" + "\n"
        + " -> Type 'morse' to convert text to morse." + "\n"
        + " -> Type 'text' to convert morse to text."  + "\n"
        + " -> Type 'menu' to see this again."  + "\n" 
        + " -> Type 'exit' to exit the program."  + "\n");
    }

    public static void print(String message){
        System.out.println(message);
    }

    public static String getInput()
    {
        Scanner scanner = new Scanner(System.in);  
        return scanner.nextLine();  
    }
}


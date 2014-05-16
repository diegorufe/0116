import java.util.HashMap;
import java.util.Set;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class CommandWords
{
    // a constant array that holds all valid command words
    private static HashMap<String,Option> validCommands;
    Option option;    

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<String,Option>();
        validCommands.put("go",option.GO);
        validCommands.put("quit",option.QUIT);
        validCommands.put("help",option.HELP);
        validCommands.put("look",option.LOOK);
        validCommands.put("eat",option.EAT);
        validCommands.put("back",option.BACK);
        validCommands.put("take",option.TAKE);
        validCommands.put("drop",option.DROP);
        validCommands.put("ir",option.GO);
        validCommands.put("salir",option.QUIT);
        validCommands.put("ayudar",option.HELP);
        validCommands.put("mirar",option.LOOK);
        validCommands.put("comer",option.EAT);
        validCommands.put("volver",option.BACK);
        validCommands.put("coger",option.TAKE);
        validCommands.put("soltar",option.DROP);
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.size(); i++) {
            if(validCommands.containsKey(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }

    /**
     * Print all valid commands to System.out
     */
    public void showAll(){
        String comandos = "";
        Set<String> keys = validCommands.keySet();
        for(String key:keys){
            comandos=comandos+key+", ";
        }
        System.out.println("Your command words are:");
        System.out.println(comandos);
    }

    /**
     * Return the Option associated with a word.
     * @param commandWord The word to look up (as a string).
     * @return The Option correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public Option getCommandWord(String commandWord){
        Option option =  Option.UNKNOWN;
        if(validCommands.containsKey(commandWord)){
            option = validCommands.get(commandWord);
        }
        return option;
    }
}

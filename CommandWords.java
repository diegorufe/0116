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
    
    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<String,Option>();
        validCommands.put("ir",Option.GO);
        validCommands.put("salir",Option.QUIT);
        validCommands.put("ayuda",Option.HELP);
        validCommands.put("mirar",Option.LOOK);
        validCommands.put("comer",Option.EAT);
        validCommands.put("volver",Option.BACK);
        validCommands.put("coger",Option.TAKE);
        validCommands.put("soltar",Option.DROP);
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

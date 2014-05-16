import java.util.HashMap;
import java.util.Collection;
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
    private Option[] validComands;     
    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
       validComands = Option.values();
    }

    /**
     * Print all valid commands to System.out
     */
    public void showAll(){
        String comandos = "";
        for(int i = 0;i < validComands.length;i++){
            comandos=comandos+validComands[i].getComando()+", ";
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
        boolean searching = true;
        int index = 0;
        while(searching && index < validComands.length){
            if(validComands[index].getComando().equals(commandWord)){
                option = validComands[index];
                searching = false;
            }
            index++;
        }
        return option;
    }
}

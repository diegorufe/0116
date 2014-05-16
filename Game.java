import java.util.Stack;
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Player player;
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        player = new Player();
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms(){
        Room dam,exams,secretariat,entrada,playground,gym,sotano;

        //Create rooms
        entrada = new Room("in entrance of the institute");
        entrada.addItem("Bin",4.0);
        dam = new Room("in DAM classroom ");
        dam.addItem("Pc-Computer",5.0);
        exams = new Room("in exams clasroom");
        exams.addItem("Table",1.5);
        secretariat = new Room("in secretariat room, you´ve found the pump");
        secretariat.addItem("Filing",10);
        playground = new Room("in the playground");
        playground.addItem("soccer goal",15);
        gym = new Room("in the gym");
        gym.addItem("Pad",1.5);
        sotano = new Room("in the basement");
        sotano.addItem("Box",1);
        // initialise room exits
        entrada.setExit("north",secretariat);
        entrada.setExit("east",exams);
        entrada.setExit("west", dam);
        entrada.setExit("southEast",playground);
        entrada.setExit("northWest",gym);
        entrada.setExit("downLevel",sotano);
        dam.setExit("east",entrada);
        exams.setExit("west",entrada);
        secretariat.setExit("south",entrada);
        playground.setExit("west",entrada);
        gym.setExit("west",entrada);
        sotano.setExit("runLevel", entrada);

        player.setCurrentRoom(entrada);  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        Option option = Option.HELP;
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type "+ "'"+option.getComando()+"' "+"if you need help.");
        System.out.println();
        player.look();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        Option commandWord = command.getCommandWord();
        switch(commandWord){
            case HELP:
            printHelp();
            break;

            case GO:
            goRoom(command);
            break;

            case QUIT: 
            wantToQuit = quit(command);
            break;

            case LOOK:
            player.look();
            break;

            case EAT:
            player.remenberEat();
            break;

            case BACK:
            player.returnRoom();
            break;

            case TAKE:
            take(command);
            break;

            case DROP:
            drop(command);
            break;

        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        //parser.getCommandWords().showAll();
        parser.printCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }
        String direction = command.getSecondWord();
        // Try to leave current room.
        player.move(direction);
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    /**
     * Metodo para cojer obejtos del jugador
     *  @param command The command to be processed.
     */
    private void take(Command command){
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("take what??");
            return;
        }
        String description = command.getSecondWord();
        player.take(description);
    }

    /**
     * Metodo para quitar objetos del jugador
     *  @param command The command to be processed.
     */
    private void drop(Command command){
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("drop what??");
            return;
        }
        String description = command.getSecondWord();
        player.drop(description);
    }
}

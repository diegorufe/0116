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
    private Room currentRoom;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /*private void createRooms()
    {
    Room outside, theater, pub, lab, office;

    // create the rooms
    outside = new Room("outside the main entrance of the university");
    theater = new Room("in a lecture theater");
    pub = new Room("in the campus pub");
    lab = new Room("in a computing lab");
    office = new Room("in the computing admin office");

    // initialise room exits
    outside.setExits(null, theater, lab, pub);
    theater.setExits(null, null, null, outside);
    pub.setExits(null, outside, null, null);
    lab.setExits(outside, office, null, null);
    office.setExits(null, null, null, lab);

    currentRoom = outside;  // start game outside
    }*/

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms(){
        Room dam,exams,secretariat,entrada,playground,gym,sotano;

        //Create rooms
        entrada = new Room("in entrance of the institute");
        dam = new Room("in DAM classroom ");
        exams = new Room("in exams clasroom");
        secretariat = new Room("in secretariat room, you´ve found the pump");
        playground = new Room("in the playground");
        gym = new Room("in the gym");
        sotano = new Room("in the basement");
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

        currentRoom = entrada;  // start game outside
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
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
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

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }else if (commandWord.equals("look")) {
            printLocationInfo();
        }else if (commandWord.equals("eat")) {
            System.out.println("You have eaten now and you are not hungry any more");
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
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            printLocationInfo();
        }
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
     * Metodo para evitar la repeticion de codigo e informar donde estamos situados
     */
    private void printLocationInfo(){
        System.out.println(currentRoom.getLongDescription());
        System.out.println();
    }
}

import java.util.HashMap;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private HashMap<String,Room>rooms;
    private String description;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        rooms = new HashMap<String,Room>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west,Room southEast,Room northWest) 
    {
        if(north != null)
            rooms.put("north",north);
        if(east != null)
            rooms.put("east",east);
        if(south != null)
            rooms.put("south",south);
        if(west != null)
            rooms.put("west",west);
        if(southEast != null)
           rooms.put("southEast",southEast);
        if(northWest != null)
             rooms.put("northWest",northWest);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param direccion es la direccion mediante la cual queremos obtenera el atributo Room
     * @return the Room o null sino existe.
     */
    public Room getExit(String direccion){
        return rooms.get(direccion);
    }

    /**
     * Return a description of the room's exits.
     * For example: "Exits: north east west"
     *
     * @ return A description of the available exits.
     */
    public String getExitString(){
        String exitString = "Exits: ";
        if(rooms.containsKey("north"))
            exitString = exitString+"north ";
        if(rooms.containsKey("east"))
            exitString = exitString+"east ";
        if(rooms.containsKey("south"))
            exitString = exitString+"south ";
        if(rooms.containsKey("west"))
            exitString = exitString+"west ";
        if(rooms.containsKey("southEast"))
            exitString = exitString+"southEast ";
        if(rooms.containsKey("northWest"))
            exitString = exitString+"northWest ";
        return exitString;
    }
}

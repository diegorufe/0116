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
    private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;
    private Room southEastExit;
    private Room northEastExit;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west,Room southEast,Room northEast) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
        if(southEast != null)
            southEastExit = southEast;
        if(northEast != null)
            northEastExit = northEast;
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
        Room room = null;
        if(direccion.equals("north")){
            room=northExit;
        }else if(direccion.equals("east")){
            room=eastExit;
        }else if(direccion.equals("south")){
            room=southExit;
        }else if(direccion.equals("west")){
            room=westExit;
        }else if(direccion.equals("southEast")){
            room=southEastExit;
        }else if(direccion.equals("northEast")){
            room = northEastExit;
        }
        return room;
    }

    /**
     * Return a description of the room's exits.
     * For example: "Exits: north east west"
     *
     * @ return A description of the available exits.
     */
    public String getExitString(){
        String exitString = "Exits: ";
        if(northExit != null)
            exitString = exitString+"north ";
        if(eastExit != null)
            exitString = exitString+"east ";
        if(southExit != null)
            exitString = exitString+"south ";
        if(westExit != null)
            exitString = exitString+"west ";
        if(southEastExit != null)
            exitString = exitString+"southEast ";
        if(northEastExit !=null)
            exitString = exitString+"northEast ";
        return exitString;
    }
}

import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
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
 * @author  Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private HashMap<String,Room>rooms;
    private String description;
    private ArrayList<Objet> objects;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        objects = new ArrayList<Objet>();
        rooms = new HashMap<String,Room>();
    }

    /**
     * Define the exits of this room.  
     * @param direccion la direccion hacia donde esta la salida.
     * @param exitRoom la salida que existe.
     */
    public void setExit(String direccion, Room exitRoom) 
    {
        rooms.put(direccion,exitRoom);
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
        String exitString = "Directions exits: ";
        Set<String> keys = rooms.keySet();
        for(String key:keys){
            exitString=exitString+key+" ";
        }
        return exitString;
    }

    /**
     * Return a long description of this room, of the form:
     *     You are in the 'name of room'
     *     Exits: north west southwest
     * @return A description of the room, including exits.
     */
    public String getLongDescription(){
        String objectsDescription="";
        if(objects.size()==0){
            objectsDescription = "There isn´t any objects";
        }else{
            for(int i=0;i < objects.size();i++){
                objectsDescription=objectsDescription+objects.get(i).toString();
            }
        }
        return "You are in the "+getDescription()+",\n"+objectsDescription+",\n"+getExitString();
    }
    
    /**
     * Metodo para obtener un item
     */
    public Objet getObjet(String description){
        Objet objeto = null;
        if(objects.size()>=1){
            for(Objet item : objects){
                if(item.getDescription().equals(description)){
                    objeto = item;
                }
            }
        }
        return objeto;
    }
    
    /**
     * 
     */
    public void addItem(String description,double weigth){
        objects.add(new Objet(description,weigth));
    }
}

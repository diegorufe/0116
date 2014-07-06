import java.util.HashMap;
import java.util.Collection;
import java.util.Stack;
public class Player{
    private HashMap<String,Objet> items;
    private static final double PESO_MAXIMO = 10;
    private Room currentRoom;
    private Stack<Room>lastRooms;
    public Player(){
        items = new HashMap<String,Objet>();
        lastRooms = new Stack<Room>();
    }

    /**
     * Metodo para obtener un objeto
     * @return un objeto de la clase Objet
     */
    public Objet getObject(String nameItem){
        Objet item = null;
        if(items.size() ==0 || !items.containsKey(nameItem)){
            System.out.println("No hay items que coger, o el numero introducido no es valido");
        }else{
            item = items.get(nameItem);
        }
        return item;
    }

    /**
     * Metodo para anadir un objeto
     */
    public void addItem(Objet item){
        if(getWeigthItems()+ item.getWeigth() >=getMaxWeigth()){
            System.out.println("No puedes añadir objetos que superen "+PESO_MAXIMO+" Kilogramos");
        }else{
            items.put(item.getDescription(),item);
        }
    }

    /**
     * Metodo para borrar un objeto
     */
    public void removeItem(String nameItem){
        if(items.size() <= 0 || !items.containsKey(nameItem)){
            System.out.println("No hay items que quitar, o el numero introducido no es valido");
        }else{
            items.remove(nameItem);
        }
    }

    /**
     * Metodo para descripir los objetos
     * @return un string con la descripcion de todos los objetos de la clase Player
     */
    public String itemsDescription(){
        String description = "Descpritions Items for the player: ";
        if(items.size() <=0){
            description += "There isn´t any items";
        }else{
            Collection<Objet> objetos = items.values();
            for(Objet item : objetos){
                description += "\n-"+item.toString();
            }
        }
        return description;
    }

    /**
     * Para calcular el peso que tiene el jugador de items
     * @return el peso maximo del jugador
     */
    public double getWeigthItems(){
        double weigthItems=0;
        Collection<Objet> objetos = items.values();
        for(Objet item : objetos){
            weigthItems += item.getWeigth();
        }
        return  weigthItems;
    }

    /**
     * Metodo que nos devuelve el peso maximo que puede soportar el jugador
     * @return el peso maximo que puede sportar el jugador
     */
    public double getMaxWeigth(){
        return PESO_MAXIMO;
    }

    /**
     * Metodo para fijar o actualizar habitaciones
     */
    public void setCurrentRoom(Room room){
        currentRoom = room;
    }

    /**
     * Metodo para añadir habitaciones visitadas
     */
    public void setLastRoom(Room room){
        lastRooms.push(room);
    }

    /**
     * Metodo para obtener la habitacion por defecto
     * @return la habitacion por defecto 
     */
    public Room getCurrentRoom(){
        return currentRoom;
    }

    /**
     * Metodo para obtener una de las habitaciones visitadas
     * @return la ultima habitacion visitada
     */
    public Room getLastRoom(){
        return lastRooms.pop();
    }

    /**
     * Metodo para obtener si ha habido habitaciones visitadas
     */
    public boolean isVistedRooms(){
        return lastRooms.empty();
    }

    /**
     * Metodo para saber los datos de la habitacion por defecto 
     */
    public void look(){
        System.out.println(currentRoom.getLongDescription());
        System.out.println(itemsDescription());
        System.out.println();
    }

    /**
     * Metodo que nos devuelve un objeto de la habitacion por defecto
     * @return nos devuelve un objeto de la habitacion por defecto
     */
    public Objet itemCurrentRoom(String description){
        return currentRoom.getObjet(description);
    }

    /**
     * Metodo para cojer objetos
     */
    public void take(String description){
        if(getCurrentRoom().getObjet(description)!=null){
            if(itemCurrentRoom(description).getWeigth()+getWeigthItems() < getMaxWeigth()){
                addItem(itemCurrentRoom(description));
                getCurrentRoom().removeItem(description);
                look();
            }else{
                System.out.println();
                System.out.println("There ins´t support more than weigth object");
                System.out.println();
                look();
            }
        }else{
            System.out.println();
            System.out.println("There ins´t the item description");
            System.out.println();
            look();
        }
    }

    /**
     * Metodo para dejar objetos 
     */
    public void drop(String description){
        if(getObject(description)!=null){
            getCurrentRoom().addItem(getObject(description).getDescription(),getObject(description).getWeigth());
            removeItem(description);
            System.out.println();
            look();
        }
        else{
            System.out.println();
            look();
        }
    }

    /**
     * Metodo para que muestre por pantalla  que el jugador tiene que comer. 
     */
    public void remenberEat(){
        System.out.println("You have eaten now and you are not hungry any more");
    }

    /**
     * Metodo por el cual el jugador se mueve de habitacion
     */
    public void move(String direction){
        Room nextRoom = getCurrentRoom().getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            Room lastRoom = getCurrentRoom();
            setLastRoom(lastRoom);
            setCurrentRoom(nextRoom);
            look();
        }
    }

    /**
     * Metodo para volver a habitaciones pasadas
     */
    public void returnRoom(){
        if(isVistedRooms()){
            System.out.println("There ins´t any place to return");
        }else{
            setCurrentRoom(getLastRoom());
            look();
        }
    }
}


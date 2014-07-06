import java.util.HashMap;
import java.util.Collection;
public class Player{
    private HashMap<String,Objet> items;
    private static final double PESO_MAXIMO = 10;
    public Player(){
        items = new HashMap<String,Objet>();
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
            System.out.println("No puedes a�adir objetos que superen "+PESO_MAXIMO+" Kilogramos");
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
            description += "There isn�t any items";
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
}


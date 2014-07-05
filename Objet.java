
/**
 * Write a description of class Objeto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Objet
{
    // instance variables - replace the example below with your own
    private String description;
    private double weigth;
    /**
     * Constructor for objects of class Objeto
     * @param description, the description for this obejct
     * @param  weigth , the weigth for this object
     */
    public Objet(String description,double weigth)
    {
        this.weigth = weigth;
        this.description = description;
    }
    
    /**
     * @return a description for this object
     */
    public String getDescription(){
        return description;
    }
    
    /**
     * @return weigth for this object
     */
    public double getWeigth(){
        return weigth;
    }
    
    /**
     * 
     */
    public String toString(){
        return getDescription()+", and their weigth: "+getWeigth();
    }
}


/**
 * Enumeration class Option - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Option
{
    GO("go","ir"), QUIT("quit","salir"), HELP("help","ayuda"), LOOK("look","mirar") , EAT("eat","comer"), BACK("back","volver") , TAKE("take","coger") , DROP("drop","dejar"),UNKNOWN("unknown","nose");
    private String comandoIngles;
    private String comandoEspanol;

    Option(String comandoIngles,String comandoEspanol){
        this.comandoIngles = comandoIngles;
        this.comandoEspanol = comandoEspanol;
    }
    
    /**
     * Metodo para opterner el comando en ingles
     * @return un string con el comando en ingles
     */
    public String getComandoIngles(){
        return comandoIngles;
    }
    
    /**
     * Metodo para opterner el comando en español
     * @return un string con el comando en español
     */
    public String getComandoEspanol(){
        return comandoEspanol;
    }
    
    /**
     * Metodo para ver todos los comandos.
     * @ return un string con todos los comandos 
     */
    public String allCommands(){
        return  getComandoIngles()+", "+getComandoEspanol();
    }
}

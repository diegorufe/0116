
/**
 * Enumeration class Option - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Option
{
    GO("ir"), QUIT("salir"), HELP("ayuda"), LOOK("mirar") , EAT("comer"), BACK("volver") , TAKE("coger") , DROP("dejar"),UNKNOWN("nose");
    private String comando;
    Option(String comando){
        this.comando = comando;
    }
     
    /**
     * Metodo para opterner el comando
     * @return un string con el comando
     */
    public String getComando(){
        return comando;
    }
}

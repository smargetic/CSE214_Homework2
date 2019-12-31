

public class personNotFoundException extends Exception{
    public personNotFoundException(){
            super("The person you are looking for does not exist.");
        }
    public personNotFoundException(String message){
            super(message);
        }
}

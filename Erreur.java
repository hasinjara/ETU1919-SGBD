package algo.erreur;
import java.io.*;
public class Erreur implements Serializable {
    String message_erreur;
    int numero;

    public Erreur(String message_erreur) {
        setMessage_erreur(message_erreur);
    }
    
    public String getMessage_erreur() {
        return message_erreur;
    }
    public void setMessage_erreur(String message_erreur) {
        this.message_erreur = message_erreur;
    }
    
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
}

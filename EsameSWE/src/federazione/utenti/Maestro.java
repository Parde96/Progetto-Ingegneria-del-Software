package federazione.utenti;

import federazione.Disciplina;
import federazione.Palestra;
import federazione.eventi.Evento;

public class Maestro extends Istruttore{

    public Maestro() {
        super();
    }
    
    // Quando è nuovo
    public Maestro(String nome, String cognome, String dataNascita, 
            String codFisc, String telefono, String email, String password){
        
        super(nome, cognome, dataNascita, codFisc, telefono, email, password);
    }
    
    // Preso da DB
    public Maestro(Evento[] eventiCreati, Palestra[] palestre, String nome, 
            String cognome, String dataNascita, String codFisc, String telefono, 
            String email, String password, boolean iscrizionePalestra, 
            Evento[] eventi, Palestra palestra, Disciplina[] discipline){
        
        super(eventiCreati, palestre, nome, cognome, dataNascita, codFisc, 
                telefono, email, password, iscrizionePalestra, eventi, palestra, 
                discipline);
    }
    
    // Per la modifica
    public Maestro(Maestro m){
        super(m);
    }
    
}

package federazione.utenti;

import federazione.Disciplina;
import federazione.Palestra;
import federazione.eventi.Evento;

public class Istruttore extends Allievo {

    private Evento[] eventiCreati;
    private Palestra[] palestre;

    public Istruttore() {
        super();
    }

    // Quando è nuovo
    public Istruttore(String nome, String cognome, String dataNascita,
            String codFisc, String telefono, String email, String password) {
        
        super(nome, cognome, dataNascita, codFisc, telefono, email, password);
        eventiCreati = null;
        palestre = null;
    }

    // Preso da DB
    public Istruttore(Evento[] eventiCreati, Palestra[] palestre, String nome, 
            String cognome, String dataNascita, String codFisc, String telefono, 
            String email, String password, boolean iscrizionePalestra, 
            Evento[] eventi, Palestra palestra, Disciplina[] discipline) {
        
        super(nome, cognome, dataNascita, codFisc, telefono, email, password, iscrizionePalestra, eventi, palestra, discipline);
        this.eventiCreati = eventiCreati;
        this.palestre = palestre;
    }

    // Per la modifica
    public Istruttore(Istruttore i) {
        super(i);
        eventiCreati = i.eventiCreati;
        palestre = i.palestre;
    }

    public Evento[] getEventiCreati() {
        return eventiCreati;
    }

    public void setEventiCreati(Evento[] eventiCreati) {
        this.eventiCreati = eventiCreati;
    }

    public Palestra[] getPalestre() {
        return palestre;
    }

    public void setPalestre(Palestra[] palestre) {
        this.palestre = palestre;
    }
}

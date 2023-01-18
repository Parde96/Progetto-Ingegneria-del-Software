package DAOs;

import federazione.utenti.Allievo;
import federazione.utenti.Istruttore;

public class DAOUtente {
    public Allievo recuperaUtente(String email, String password) {
        Allievo a = null;
        return a;
    }

    public Allievo[] recuperaUtenti(){
        Allievo[] a = null;
        return a;
    }
    public boolean aggiungiUtente(Allievo a) {
        // ISTRUZIONI SQL PER AGGIUNGERE AL DATABASE CON ENTITY MANAGER
        return true;
    }

    public boolean modificaUtente(Allievo a1, Allievo a2) {
        // ISTRUZIONI SQL PER MODIFICARE AL DATABASE CON ENTITY MANAGER
        return true;
    }

    public boolean eliminaUtente(Allievo a) {
        // ISTRUZIONI SQL PER ELIMINARE AL DATABASE CON ENTITY MANAGER
        return true;
    }
    
    public Istruttore[] ricercaInsegnantiFederazione(){ //modificare nome in UML
        Istruttore[] i = null;
        return i;
    }
}

package federazione.eventi;

import federazione.Palestra;
import federazione.utenti.Istruttore;

public class Stage extends Evento {

    public Stage() {
        super();
    }

    public Stage(String data, String ora, String titolo, String descrizione, Istruttore organizzatore, Palestra luogo) {
        super(data, ora, titolo, descrizione, organizzatore, luogo);
    }
    
    public Stage(Evento e){
        super(e);
    }
    
}

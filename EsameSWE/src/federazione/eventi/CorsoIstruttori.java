package federazione.eventi;

import federazione.Palestra;
import federazione.utenti.Istruttore;

public class CorsoIstruttori extends Evento{

    public CorsoIstruttori() {
        super();
    }
    
    public CorsoIstruttori(String data, String ora, String titolo, String descrizione, Istruttore organizzatore, Palestra luogo) {
        super(data, ora, titolo, descrizione, organizzatore, luogo);
    }
    
    public CorsoIstruttori(Evento e){
        super(e);
    }
}

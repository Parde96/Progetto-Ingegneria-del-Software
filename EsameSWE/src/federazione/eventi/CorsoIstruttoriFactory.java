package federazione.eventi;

import federazione.Palestra;
import federazione.utenti.Istruttore;

public class CorsoIstruttoriFactory implements EventoFactory {

    @Override
    public Evento creaEvento(String data, String ora, String titolo, String descrizione, Istruttore organizzatore, Palestra luogo) {
        return new CorsoIstruttori(data, ora, titolo, descrizione, organizzatore, luogo);
    }

    @Override
    public Evento creaEvento(Evento e) {
        return new CorsoIstruttori(e);
    }
    
}

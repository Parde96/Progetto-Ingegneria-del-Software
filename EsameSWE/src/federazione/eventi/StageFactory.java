package federazione.eventi;

import federazione.Palestra;
import federazione.utenti.Istruttore;

public class StageFactory implements EventoFactory{

    @Override
    public Evento creaEvento(String data, String ora, String titolo, String descrizione, Istruttore organizzatore, Palestra luogo) {
        return new Stage(data, ora, titolo, descrizione, organizzatore, luogo);
    }

    @Override
    public Evento creaEvento(Evento e) {
        return new Stage(e);
    }
    
}

package federazione.eventi;

import federazione.Palestra;
import federazione.utenti.Istruttore;

public interface EventoFactory {
    public Evento creaEvento(String data, String ora, String titolo, String descrizione, Istruttore organizzatore, Palestra luogo);
    public Evento creaEvento(Evento e);
}

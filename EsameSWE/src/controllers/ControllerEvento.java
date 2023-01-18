package controllers;

import DAOs.DAOEvento;
import federazione.Palestra;
import federazione.eventi.Evento;
import federazione.eventi.EventoFactory;
import federazione.utenti.Allievo;
import federazione.utenti.Istruttore;
import java.util.ArrayList;

public class ControllerEvento {

    private EventoFactory ef;

    private DAOEvento DAOE;

    // Arriva la factory giusta in base alla pagina in cui ci troviamo.
    public ControllerEvento(EventoFactory ef) {
        this.ef = ef;
        DAOE = new DAOEvento();
    }

    public boolean aggiungiEvento(String data, String ora, String titolo, String descrizione, Istruttore organizzatore, Palestra luogo) { //AGGIUNGERE AD UML CHE IL CONTROLLER CREA GLI EVENTI
        Evento e = ef.creaEvento(data, ora, titolo, descrizione, organizzatore, luogo);
        return DAOE.aggiungiEvento(e);
    }

    // Li fa visualizzare a schermo.
    public Evento[] recuperaEventi() {
        return DAOE.recuperaEventi();
    }

    /*
    public void modificaData() {

    }

    public void modificaOra() {

    }

    public void modificaTitolo() {

    }

    public void modificaDescrizione() {

    }
     */
 /*
    Preleverà l'evento da modificare dalla pagina e lo stesso per i nuovi dati,
    per testare facciamo che li prende in ingresso da noi, di conseguenza dal
    controller istruttore.
     */
    public boolean modificaEvento(Evento modificare, String data, String ora, String titolo, String descrizione, Istruttore organizzatore, Palestra luogo) {
        Evento modificato = ef.creaEvento(modificare);
        if (data != null && !data.equals("")) {
            modificato.setData(data);
        }
        if (ora != null && !ora.equals("")) {
            modificato.setOra(ora);
        }
        if (titolo != null && !titolo.equals("")) {
            modificato.setData(titolo);
        }
        if (descrizione != null && !descrizione.equals("")) {
            modificato.setDescrizione(descrizione);
        }
        if (organizzatore != null) {
            modificato.setOrganizzatore(organizzatore);
        }
        if (luogo != null) {
            modificato.setLuogo(luogo);
        }
        return DAOE.modificaEvento(modificare, modificato);
    }

    public boolean eliminaEvento(Evento e){
        return DAOE.eliminaEvento(e);
    }
    
    // Prenderebbe un evento selezionato, per testare facciamo che lo mandiamo noi
    public String visualizzaDati(Evento e) { //MODIFICARE IN UML INVECE CHE AVERE METODI PER OGNI ATTRIBUTO
        String data = e.getData();
        String titolo = e.getTitolo();
        String descrizione = e.getDescrizione();
        Istruttore organizzatore = e.getOrganizzatore();
        Palestra luogo = e.getLuogo();

        return "Titolo: " + titolo + ", descrizione: " + descrizione + ", "
                + "data: " + data + ", nome palestra e luogo: "
                + luogo.getNome() + " " + luogo.getIndirizzo() + ", "
                + "organizzatore: " + organizzatore.getNome() + " "
                + organizzatore.getCognome();
    }

    public ArrayList<Allievo> visualizzaIscritti(Evento e){
        return e.getIscritti();
    }
    
    // Prenderebbe l'evento dalla pagina, per test lo mandiamo noi.
    public boolean iscriviAEvento(Allievo iscritto, Evento e) {
        e.aggiungiIscritto(iscritto);
        return DAOE.iscriviAEvento(iscritto, e);
    }
}

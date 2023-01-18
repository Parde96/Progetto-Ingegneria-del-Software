package controllers;

import DAOs.DAOUtente;
import federazione.Palestra;
import federazione.eventi.Evento;
import federazione.utenti.Allievo;
import federazione.utenti.Istruttore;

public class ControllerIstruttore extends ControllerAllievo {

    public ControllerIstruttore(Istruttore a, DAOUtente DAOU) {
        super(a, DAOU);
    }

    public Palestra[] visualizzaPalestre() {
        Istruttore i = (Istruttore) utente;
        return i.getPalestre();
    }

    public Evento[] visualizzaEventiCreati() {
        Istruttore i = (Istruttore) utente;
        return i.getEventiCreati();
    }

    // Invece che ricevere i dati saranno letti dalla pagina web
    public boolean aggiungiAllievo(String nome, String cognome, String dataNascita,
            String codFisc, String telefono, String email, String password) { //AGGIUNGERE AD UML IL FATTO CHE CREA

        Allievo nuovo = new Allievo(nome, cognome, dataNascita, codFisc, telefono, email, password);

        return DAOU.aggiungiUtente(nuovo);
    }

    /*
    Anche qua in realtà legge invece che ricevere, o forse no? Forse si possono 
    usare entrambi gli approcci, per ora il primo. Si invia poi al controller
    degli eventi.
     */
    public boolean creaStage(String data, String ora, String titolo, String descrizione, Istruttore organizzatore, Palestra luogo) {
        return ce.aggiungiEvento(data, ora, titolo, descrizione, organizzatore, luogo);
    }
    
    public boolean eliminaEvento(Evento e){
        return ce.eliminaEvento(e);
    }
    
    /*
    Qua richiama solo il controller degli eventi che poi preleverà i dati 
    dalla pagina, per testare però ci serve che sia lui a mandare i dati.
    Quindi per testare facciamo che gli inviamo noi un evento da modificare con 
    i nuovi dati che possono essere nulli o meno, ci penserà l'altro controller.
    Se nulli rimarranno quelli vecchi.
     */
    public boolean modificaEvento(Evento modificare, String data, String ora, String titolo, String descrizione, Istruttore organizzatore, Palestra luogo) {
        return ce.modificaEvento(modificare, data, ora, titolo, descrizione, organizzatore, luogo);
    }
}

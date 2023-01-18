package controllers;

import DAOs.DAOUtente;
import federazione.Disciplina;
import federazione.Palestra;
import federazione.eventi.Evento;
import federazione.utenti.Allievo;
import federazione.utenti.Istruttore;
import java.util.ArrayList;

public class ControllerAllievo extends ControllerUtente {

    protected ControllerEvento ce;
    protected ControllerPalestra cp;
    protected ControllerDisciplina cd;
    protected DAOUtente DAOU;

    // Dovranno arrivare in ingresso anche gli altri controller o riceverli 
    // con setters?
    public ControllerAllievo(Allievo a, DAOUtente DAOU) {
        super(a);
        //Ricevuto dal controller login per non crearne un altro
        this.DAOU = DAOU;
    }

    public void setControllerEvento(ControllerEvento ce) {
        this.ce = ce;
    }

    public void setControllerPalestra(ControllerPalestra cp) {
        this.cp = cp;
    }

    public void setControllerDisciplina(ControllerDisciplina cd) {
        this.cd = cd;
    }

    /*
    I metodi prendono in ingresso dei parametri solo per fare testing, in 
    realtà quello che farà ogni metodo sarà leggere i campi di testo della 
    pagina web da cui recuperano i dati necessari a compiere le azioni.
     */
 /*
    public void modificaNome(String nome) {
        Allievo modificato = new Allievo(utente);
        if (nome != null && !nome.equals("")) {
            modificato.setNome(nome);
            DAOU.modificaUtente(utente, modificato);
            utente = modificato;
        } else {
            System.err.println("Campo vuoto");
        }

    }

    public void modificaCognome(String cognome) {
        Allievo modificato = new Allievo(utente);
        if (cognome != null && !cognome.equals("")) {
            modificato.setCognome(cognome);
            DAOU.modificaUtente(utente, modificato);
            utente = modificato;
        } else {
            System.err.println("Campo vuoto");
        }

    }

    public void modificaDataNascita(String dataNascita) {
        Allievo modificato = new Allievo(utente);
        if (dataNascita != null && !dataNascita.equals("")) {
            modificato.setDataNascita(dataNascita);
            DAOU.modificaUtente(utente, modificato);
            utente = modificato;
        } else {
            System.err.println("Campo vuoto");
        }

    }

    public void modificaCodFisc(String codFisc) {
        Allievo modificato = new Allievo(utente);
        if (codFisc != null && !codFisc.equals("")) {
            modificato.setCodFisc(codFisc);
            DAOU.modificaUtente(utente, modificato);
            utente = modificato;
        } else {
            System.err.println("Campo vuoto");
        }
    }

    public void modificaTelefono(int telefono) {
        Allievo modificato = new Allievo(utente);
        if (telefono != 0) {
            modificato.setTelefono(telefono);
            DAOU.modificaUtente(utente, modificato);
            utente = modificato;
        } else {
            System.err.println("Campo vuoto");
        }
    }

    public void modificaEmail(String email) {
        Allievo modificato = new Allievo(utente);
        if (email != null && !email.equals("")) {
            modificato.setEmail(email);
            DAOU.modificaUtente(utente, modificato);
            utente = modificato;
        } else {
            System.err.println("Campo vuoto");
        }
    }

    public void modificaPassword(String password) {
        Allievo modificato = new Allievo(utente);
        if (password != null && !password.equals("")) {
            modificato.setPassword(password);
            DAOU.modificaUtente(utente, modificato);
            utente = modificato;
        } else {
            System.err.println("Campo vuoto");
        }
    }
     */
    public boolean modificaDati(String nome, String cognome, String dataNascita,
            String codFisc, String telefono, String email, String password) {

        boolean mod = false;
        Allievo modificato = new Allievo(utente);
        if (nome != null && !nome.equals("")) {
            modificato.setNome(nome);
            mod = true;
        }
        if (cognome != null && !cognome.equals("")) {
            modificato.setCognome(cognome);
            mod = true;
        }
        if (dataNascita != null && !dataNascita.equals("")) {
            modificato.setDataNascita(dataNascita);
            mod = true;
        }
        if (codFisc != null && !codFisc.equals("")) {
            modificato.setCodFisc(codFisc);
            mod = true;
        }
        if (telefono != null && telefono.equals("")) { // frose telefono va messo stringa per controllare che abbia una lunghezza idonea
            modificato.setTelefono(telefono);
            mod = true;
        }
        if (email != null && !email.equals("")) {
            modificato.setEmail(email);
            mod = true;
        }
        if (password != null && !password.equals("")) {
            modificato.setPassword(password);
            mod = true;
        }

        boolean risultatoQuery = false;
        if (mod) {
            risultatoQuery = DAOU.modificaUtente(utente, modificato);
            utente = modificato;
        }
        
        return risultatoQuery;
    }

    public String visualizzaDati() {
        String nome = utente.getNome();
        String cognome = utente.getCognome();
        String data = utente.getDataNascita();
        String codFisc = utente.getCodFisc();
        String telefono = utente.getTelefono();
        String email = utente.getEmail();
        String iscritto = "";
        if (utente.isIscrizionePalestra()) {
            iscritto = "iscritto nella palestra " + utente.getPalestra();
        }

        return "Nome: " + nome + ", cognome: " + cognome + ", " + "data: "
                + data + ", codice fiscale: " + codFisc + ", "
                + "telefono: " + telefono + ", email: " + email + ", "
                + iscritto;
    }

    // I valori di ritorno sono restituiti alla pagina che poi li farà
    // visualizzare
    public ArrayList<Evento> visualizzaEventiIscritto() {
        return utente.getEventi();
    }

    public Palestra visualizzaPalestra() {
        return utente.getPalestra();
    }

    public ArrayList<Disciplina>  visualizzaDiscipline() {
        return utente.getDiscipline();
    }

    // Rivedere se far visualizzare in pagina direttamente dal controller 
    // palestra, per testare forse va lasciato così
    public ArrayList<Palestra> ricercaPalestre() {
        return cp.recuperaPalestreFederazione();
    }

    // Dopo averli recuperati li restituisce alla pagine che li elencherà
    public Istruttore[] ricercaInsegnanti() {
        return DAOU.ricercaInsegnantiFederazione();
    }

    public Evento[] ricercaEventi() {
        return ce.recuperaEventi();
    }

    // L'evento a cui iscriversi sarà letto dal controller degli eventi, ora lo
    // mandiamo noi per riuscire a testarlo.
    public boolean iscriviAEvento(Evento e) {
        return ce.iscriviAEvento(utente, e);
    }

    // La palestra a cui iscriversi sarà letta dal controller della palestra,
    // per testare si manda noi.
    public boolean iscrizionePalestra(Palestra p) {
        boolean conferma = false;
        if (!utente.isIscrizionePalestra()) {
            conferma = cp.iscriviInPalestra(utente, p);
        } else {
            System.err.println("Già iscritto ad una palestra");
        }
        return conferma;
    }

    // Inviata da qui perchè va testato, senò presa dal controller
    public boolean iscrizioneDisciplina(Disciplina d) { //AGGIUGNERE IN UML
        boolean conferma = false;
        if (!utente.isIscrizionePalestra()) {
            System.err.println("Non si è iscritti a nessuna palestra");
        } else {
            if (!cp.disciplinaInPalestra(utente.getPalestra(), cd)) {
                System.err.println("Disciplina non presente nella palestra in cui si è iscritti");
            } else {
                conferma = cd.iscriviADisciplina(d, utente);
            }
        }
        return conferma;
    }
}

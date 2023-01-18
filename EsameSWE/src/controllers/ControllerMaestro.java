package controllers;

import DAOs.DAOUtente;
import federazione.Disciplina;
import federazione.Palestra;
import federazione.utenti.Allievo;
import federazione.utenti.Istruttore;
import federazione.utenti.Maestro;

public class ControllerMaestro extends ControllerIstruttore {

    public ControllerMaestro(Maestro a, DAOUtente DAOU) {
        super(a, DAOU);
    }
    
    
    public Allievo[] recuperaUtenti(){
        return DAOU.recuperaUtenti();
    }
    
    public boolean aggiungiIstruttore(String nome, String cognome, String dataNascita,
            String codFisc, String telefono, String email, String password) { //AGGIUNGERE AD UML IL FATTO CHE CREA // OK

        Istruttore nuovo = new Istruttore(nome, cognome, dataNascita, codFisc, telefono, email, password);
        return DAOU.aggiungiUtente(nuovo);
    }

    public boolean aggiungiMaestro(String nome, String cognome, String dataNascita,
            String codFisc, String telefono, String email, String password) { //AGGIUNGERE AD UML IL FATTO CHE CREA // OK

        Maestro nuovo = new Maestro(nome, cognome, dataNascita, codFisc, telefono, email, password);
        return DAOU.aggiungiUtente(nuovo);
    }
    
    public boolean aggiungiPalestra(String nome, String indirizzo, int telefono, String email) {
        return cp.aggiungiPalestra(nome, indirizzo, telefono, email);
    }

    // Prende i dati per testare, li prenderà in realtà il controller discipline dopo averlo richiesto
    public boolean aggiungiDisciplina(String nome, String descrizione){ //AGGIUNGERE IN UML // OK
        return cd.aggiungiDisciplina(nome, descrizione);
    }
    
    public boolean modificaUtente(Allievo modificare, String nome, String cognome, String dataNascita,
            String codFisc, String telefono, String email, String password){
        
        Allievo modificato = new Allievo(modificare);        
        boolean mod = false;
        boolean conferma = false;

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
        if (telefono != null && !telefono.equals("")) { // frose telefono va messo stringa per controllare che abbia una lunghezza idonea
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
        
        if(mod){
            conferma = DAOU.modificaUtente(modificare, modificato);
        }
        return conferma;
    }

    //La palestra la prende il controller palestra, per testare va mandata da qua la roba
    public boolean modificaPalestra(Palestra modificare, String nome, String indirizzo, int telefono, String email) {
        return cp.modificaPalestra(modificare, nome, indirizzo, telefono, email);
    }
    
    public boolean modificaDisciplina(Disciplina d, String nome, String descrizione){
        return cd.modificaDisciplina(d, nome, descrizione);
    }
    
    // Prende dalla pagina, noi glielo manderemo per test
    public boolean eliminaUtente(Allievo a) {
        return DAOU.eliminaUtente(a);
    }
    
    public boolean eliminaPalestra(Palestra p){
        return cp.eliminaPalestra(p);
    }
    
    // Dobbiamo prenderla noi per testare
    public boolean eliminaDisciplina(Disciplina d){ //AGGIUNGERE IN UML //OK
        return cd.eliminaDisciplina(d);
    }
    
    // I dati li prende il controlle eventi, si prendono da qua per testare
    public boolean creaCorsoIstruttori(String data, String ora, String titolo, String descrizione, Istruttore organizzatore, Palestra luogo) {
        return ce.aggiungiEvento(data, ora, titolo, descrizione, organizzatore, luogo);
    }
}

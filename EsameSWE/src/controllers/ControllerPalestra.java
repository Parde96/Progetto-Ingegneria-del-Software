package controllers;

import DAOs.DAOPalestra;
import federazione.Disciplina;
import federazione.Palestra;
import federazione.eventi.Evento;
import federazione.utenti.Allievo;
import federazione.utenti.Istruttore;
import java.util.ArrayList;

public class ControllerPalestra {

    private DAOPalestra DAOP;

    public ControllerPalestra(DAOPalestra DAOP) {
        this.DAOP = DAOP;
    }

    public ArrayList<Palestra> recuperaPalestreFederazione() {
        return DAOP.recuperaPalestre();
    }

    public boolean aggiungiPalestra(String nome, String indirizzo, int telefono, String email) { //AGGIUNGERE IL FATTO CHE CREA
        Palestra nuova = new Palestra(nome, indirizzo, telefono, email);
        return DAOP.aggiungiPalestra(nuova);
    }

    /*
    public void visualizzaIndirizzo() {

    }

    public void visualizzaTelefono() {

    }

    public void visualizzaEmail() {

    }
     */
 /*
    Spostare queste due successive in una classe specializzata solo per il 
    maestro potendole fare solo lui e così gli altri non le vedono?
     */
    public boolean modificaPalestra(Palestra modificare, String nome, String indirizzo, int telefono, String email) { //AGGIUNGERE IL FATTO CHE CREA
        Palestra modificata = new Palestra(modificare);
        boolean mod = false;
        
        if (nome != null && !nome.equals("")) {
            modificata.setNome(nome);
            mod = true;
        }
        if (indirizzo != null && !indirizzo.equals("")) {
            modificata.setIndirizzo(indirizzo);
            mod = true;
        }
        if (telefono != 0) {
            modificata.setTelefono(telefono);
            mod = true;
        }
        if (email != null && !email.equals("")) {
            modificata.setEmail(email);
            mod = true;
        }
        
        boolean risultatoQuery = false;
        if(mod){
            risultatoQuery = DAOP.modificaPalestra(modificare, modificata);
        }
        return risultatoQuery;
    }

    public boolean eliminaPalestra(Palestra p) {
        boolean conferma = false;
        if (p != null) {
            conferma = DAOP.eliminaPalestra(p);
        }
        return conferma;
    }

    // Presa dalla pagina, per testare la mandiamo noi
    public String visualizzaDati(Palestra p) {
        String nome = p.getNome();
        String indirizzo = p.getIndirizzo();
        int telefono = p.getTelefono();
        String email = p.getEmail();

        return "Nome: " + nome + ", indirizzo: " + indirizzo + ", telefono: "
                + telefono + ", email: " + email;
    }

    // Presa dalla pagina, per testare la mandiamo noi
    public ArrayList<Istruttore> visualizzaInsegnanti(Palestra p) {
        return p.getInsegnanti();
    }

    // Presa dalla pagina, per testare la mandiamo noi
    public ArrayList<Evento> visualizzaEventi(Palestra p) {
        return p.getEventiOspitati();
    }

    // Presa dalla pagina, per testare la mandiamo noi
    public ArrayList<Allievo> visualizzaIscritti(Palestra p) {
        return p.getIscritti();
    }

    // Presa dalla pagina, per testare la mandiamo noi
    public ArrayList<Disciplina> visualizzaDiscipline(Palestra p) {
        return p.getDiscipline();
    }

    // Presa dalla pagina, per testare la mandiamo noi dal controller utente
    public boolean  iscriviInPalestra(Allievo a, Palestra p) {
        return DAOP.iscriviInPalestra(a, p);
    }

    public boolean disciplinaInPalestra(Palestra p, ControllerDisciplina cd) { //AGGIUNGERE IN UML
        Disciplina d = cd.restituisciDisciplina();
        boolean presente = false;

        if (p.getDiscipline().contains(d)) {
            presente = true;
        }

        return presente;
    }
}

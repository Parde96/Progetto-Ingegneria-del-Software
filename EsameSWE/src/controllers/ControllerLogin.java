package controllers;

import DAOs.DAOUtente;
import federazione.utenti.Allievo;
import federazione.utenti.Istruttore;
import federazione.utenti.Maestro;

public class ControllerLogin {

    private DAOUtente DAOU;

    //Inviato dall'esterno o creato lui stesso?
    public ControllerLogin(DAOUtente DAOU) {
        this.DAOU = DAOU;
    }    
    
    /*
    Il metodo invece che ricevere andrà a leggere i dati da usare dalla pagina,
    la pagina poi controllerà che sia stato restituito il controller.
    */
    public ControllerUtente login(String email, String password){
        Allievo a = DAOU.recuperaUtente(email, password);
        if (a != null){
            if (a instanceof Allievo){
                return new ControllerAllievo(a, DAOU);
            }
            else if (a instanceof Istruttore) {
                Istruttore i = (Istruttore)a;
                return new ControllerIstruttore(i, DAOU);
            }
            else if (a instanceof Maestro){
                Maestro m = (Maestro)a;
                return new ControllerMaestro(m, DAOU);
            }
        }
        System.err.println("Erorre, controllare i dati inseriti");
        return null;
    }
}

package controllers;

import federazione.utenti.Allievo;

public abstract class ControllerUtente { // DA AGGIUNGERE A UML

    protected Allievo utente;

    public ControllerUtente(Allievo utente) {
        this.utente = utente;
    }
}

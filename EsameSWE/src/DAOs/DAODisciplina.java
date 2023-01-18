package DAOs;

import federazione.Disciplina;
import federazione.utenti.Allievo;

public class DAODisciplina {

    public Disciplina recuperaDisciplina() {

        return new Disciplina();
    }

    public boolean aggiungiDisciplina(Disciplina d) {
        return true;
    }

    public boolean modificaDisciplina(Disciplina d1, Disciplina d2) {
        return true;
    }

    public boolean eliminaDisciplina(Disciplina d) {
        return true;
    }

    public boolean iscrivi(Disciplina d, Allievo a) { //AGGIUGNERE IN UML
        return true;
    }
}

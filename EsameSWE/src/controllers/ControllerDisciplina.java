package controllers;

import DAOs.DAODisciplina;
import federazione.Disciplina;
import federazione.Palestra;
import federazione.utenti.Allievo;

public class ControllerDisciplina {

    private DAODisciplina DAOD;

    public Disciplina[] recuperaDisciplineDB() {

        Disciplina[] d = null;

        return d;
    }

    // Recupera i dati dalla pagina, ora per test si mandano
    public boolean aggiungiDisciplina(String nome, String descrizione) {
        Disciplina nuova = new Disciplina(nome, descrizione);
        return DAOD.aggiungiDisciplina(nuova);
    }

    // Legge quella da modificare dalla pagina, gliela mandiamo per test insieme ai nuovi dati da usare per la modifica
    public boolean modificaDisciplina(Disciplina modificare, String nome, String descrizione) {
        Disciplina modificata = new Disciplina(modificare);
        boolean mod = false;
        boolean conferma = false;
        
        if(nome != null && !nome.equals("")){
            modificata.setNome(nome);
            mod = true;
        }
        
        if (descrizione != null && !descrizione.equals("")){
            modificata.setDescrizione(descrizione);
            mod = true;
        }
        
        if(mod){
            conferma = DAOD.modificaDisciplina(modificare, modificata);
        }
        return conferma;
    }
    
    // La prende dalla pagina, per test gliela mandiamo
    public boolean eliminaDisciplina(Disciplina d) {
        return DAOD.eliminaDisciplina(d);
    }
    
    // Prende la selezionata dalla pagina e la rende a chi serve, tipo la palestra per vedere se è presente tra le sue
    public Disciplina restituisciDisciplina() {

        return new Disciplina();
    }

    /*
    public void visualizzaNome() {

    }

    public void visualizzaDescrizione() {

    }
     */
    // Recupera disciplina seleziona, ora si manda per test
    public String visualizzaDati(Disciplina d) {
        String nome = d.getNome();
        String descrizione = d.getDescrizione();

        return "Nome: " + nome + ", descrizione: " + descrizione;
    }

    // Recupera disciplina seleziona, ora si manda per test
    public Palestra[] visualizzaPalestre(Disciplina d) {
        return d.getPalestre();
    }

    // Recupera disciplina seleziona, ora si manda per test
    public Allievo[] visualizzaIScritti(Disciplina d) {
        return d.getIscritti();
    }

    // Disciplina recuperata dalla pagina, ora inviata per test
    public boolean iscriviADisciplina(Disciplina d, Allievo a) { //AGGIUNGERE IN UML
        return DAOD.iscrivi(d, a);
    }
}

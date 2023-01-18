package federazione;

import federazione.eventi.Evento;
import federazione.utenti.Allievo;
import federazione.utenti.Istruttore;
import java.util.ArrayList;

public class Palestra {

    private static int counter = 0;
    private int id;
    private String nome; // AGGIUNGERE AD UML
    private String indirizzo;
    private int telefono;
    private String email;

    private ArrayList<Evento> eventiOspitati;
    private ArrayList<Allievo> iscritti;
    private ArrayList<Istruttore> insegnanti;
    private ArrayList<Disciplina> discipline;

    public Palestra() {
    }

    // Nuova
    public Palestra(String nome, String indirizzo, int telefono, String email) {
        this.id = counter++;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.telefono = telefono;
        this.email = email;
        this.eventiOspitati = new ArrayList<>();
        this.iscritti = new ArrayList<>();
        this.insegnanti = new ArrayList<>();
        this.discipline = new ArrayList<>();
    }

    // Da DB
    public Palestra(int id, String nome, String indirizzo, int telefono, String email, ArrayList<Evento> eventiOspitati, ArrayList<Allievo> iscritti, ArrayList<Istruttore> insegnanti, ArrayList<Disciplina> discipline) {
        this.id = id;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.telefono = telefono;
        this.email = email;
        this.eventiOspitati = eventiOspitati;
        this.iscritti = iscritti;
        this.insegnanti = insegnanti;
        this.discipline = discipline;
    }

    // Copia, per modifica
    public Palestra(Palestra p) {
        this.id = p.id;
        this.nome = p.nome;
        this.indirizzo = p.indirizzo;
        this.telefono = p.telefono;
        this.email = p.email;
        this.eventiOspitati = p.eventiOspitati;
        this.iscritti = p.iscritti;
        this.insegnanti = p.insegnanti;
        this.discipline = p.discipline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Evento> getEventiOspitati() {
        return eventiOspitati;
    }

    public void setEventiOspitati(ArrayList<Evento> eventiOspitati) {
        this.eventiOspitati = eventiOspitati;
    }

    public ArrayList<Allievo> getIscritti() {
        return iscritti;
    }

    public void setIscritti(ArrayList<Allievo> iscritti) {
        this.iscritti = iscritti;
    }

    public ArrayList<Istruttore> getInsegnanti() {
        return insegnanti;
    }

    public void setInsegnanti(ArrayList<Istruttore> insegnanti) {
        this.insegnanti = insegnanti;
    }

    public ArrayList<Disciplina> getDiscipline() {
        return discipline;
    }

    public void setDiscipline(ArrayList<Disciplina> discipline) {
        this.discipline = discipline;
    }

    //Necessario per i test per usare assertEquals
    @Override
    public boolean equals(Object obj) {
        boolean risultato = false;
        Palestra confronto = (Palestra) obj;
        if (id == confronto.id && nome.equals(confronto.nome)
                && indirizzo.equals(confronto.indirizzo)
                && telefono == confronto.telefono 
                && email.equals(confronto.email)
                && eventiOspitati == confronto.eventiOspitati
                && discipline == confronto.discipline
                && insegnanti == confronto.insegnanti) {
            
            risultato = true;
        }

        return risultato;
    }

}

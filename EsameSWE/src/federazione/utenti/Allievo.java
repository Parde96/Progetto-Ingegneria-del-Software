package federazione.utenti;

import federazione.Disciplina;
import federazione.Palestra;
import federazione.eventi.Evento;
import java.util.ArrayList;

public class Allievo {

    private static int counter = 0;
    private int id;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String codFisc;
    private String telefono;
    private String email;
    private String password;
    private boolean iscrizionePalestra;

    private ArrayList<Evento> eventi;
    private Palestra palestra;
    private ArrayList<Disciplina> discipline;

    public Allievo() {
    }

    // Usato quando creato con dati da database
    public Allievo(String nome, String cognome, String dataNascita,
            String codFisc, String telefono, String email, String password,
            boolean iscrizionePalestra, Evento[] eventi, Palestra palestra,
            Disciplina[] discipline) {

        this.id = counter++;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.codFisc = codFisc;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.iscrizionePalestra = iscrizionePalestra;
        this.eventi = new ArrayList<>();
        this.palestra = palestra;
        this.discipline = new ArrayList<>();
    }

    // Usato quando viene aggiunto un nuovo allievo
    public Allievo(String nome, String cognome, String dataNascita,
            String codFisc, String telefono, String email, String password) {

        this.id = counter++;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.codFisc = codFisc;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.iscrizionePalestra = false;
        this.eventi = null;
        this.palestra = null;
        this.discipline = null;
    }

    // Costruttore di copia usato nella modifica dei dati
    public Allievo(Allievo a) {
        this.id = a.id;
        this.nome = a.nome;
        this.cognome = a.cognome;
        this.dataNascita = a.dataNascita;
        this.codFisc = a.codFisc;
        this.telefono = a.telefono;
        this.email = a.email;
        this.password = a.password;
        this.iscrizionePalestra = a.iscrizionePalestra;
        this.eventi = a.eventi;
        this.palestra = a.palestra;
        this.discipline = a.discipline;
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getCodFisc() {
        return codFisc;
    }

    public void setCodFisc(String codFisc) {
        this.codFisc = codFisc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIscrizionePalestra() {
        return iscrizionePalestra;
    }

    public void setIscrizionePalestra(boolean iscrizionePalestra) {
        this.iscrizionePalestra = iscrizionePalestra;
    }

    public ArrayList<Evento> getEventi() {
        return eventi;
    }

    public void setEventi(ArrayList<Evento> eventi) {
        this.eventi = eventi;
    }

    public Palestra getPalestra() {
        return palestra;
    }

    public void setPalestra(Palestra palestra) {
        this.palestra = palestra;
    }

    public ArrayList<Disciplina> getDiscipline() {
        return discipline;
    }

    public void setDiscipline(ArrayList<Disciplina> discipline) {
        this.discipline = discipline;
    }

    @Override
    public boolean equals(Object obj) {
        boolean risultato = false;
        Allievo confronto = (Allievo) obj;
        
        if(id == confronto.id && nome.equals(confronto.nome) 
                && cognome.equals(cognome) 
                && dataNascita.equals(confronto.dataNascita) 
                && codFisc.equals(confronto.codFisc) 
                && telefono.equals(confronto.telefono) 
                && email.equals(confronto.email) 
                && password.equals(confronto.password) 
                && iscrizionePalestra == confronto.iscrizionePalestra 
                && eventi == confronto.eventi 
                && palestra == confronto.palestra 
                && discipline == confronto.discipline){
            
            risultato = true;
        }
        
        return risultato;
    }
    
    

}

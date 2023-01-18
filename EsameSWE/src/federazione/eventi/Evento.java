package federazione.eventi;

import federazione.Palestra;
import federazione.utenti.Allievo;
import federazione.utenti.Istruttore;
import java.util.ArrayList;

public abstract class Evento {
    private static int counter = 0;
    private int id;
    private String data;
    private String ora;
    private String titolo;
    private String descrizione;
    
    private ArrayList<Allievo> iscritti;
    private Istruttore organizzatore;
    private Palestra luogo;

    public Evento() {
    }

    public Evento(String data, String ora, String titolo, String descrizione, Istruttore organizzatore, Palestra luogo) {
        this.id = counter++;
        this.data = data;
        this.ora = ora;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.iscritti = new ArrayList<>();
        this.organizzatore = organizzatore;
        this.luogo = luogo;
    }
    
    public Evento(Evento e) {
        this.id = e.id;
        this.data = e.data;
        this.ora = e.ora;
        this.titolo = e.titolo;
        this.descrizione = e.descrizione;
        this.iscritti = e.iscritti;
        this.organizzatore = e.organizzatore;
        this.luogo = e.luogo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public ArrayList<Allievo> getIscritti() {
        return iscritti;
    }

    public void setIscritti(ArrayList<Allievo> iscritti) {
        this.iscritti = iscritti;
    }

    public Istruttore getOrganizzatore() {
        return organizzatore;
    }

    public void setOrganizzatore(Istruttore organizzatore) {
        this.organizzatore = organizzatore;
    }

    public Palestra getLuogo() {
        return luogo;
    }

    public void setLuogo(Palestra luogo) {
        this.luogo = luogo;
    }
    
    public void aggiungiIscritto(Allievo a){
        iscritti.add(a);
    }
}

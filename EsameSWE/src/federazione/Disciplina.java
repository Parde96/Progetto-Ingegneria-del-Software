package federazione;

import federazione.utenti.Allievo;

public class Disciplina {

    private String nome;
    private String descrizione;

    private Allievo[] iscritti;
    private Palestra[] palestre;

    public Disciplina() {
    }

    // Per nuova
    public Disciplina(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.iscritti = null;
        this.palestre = null;
    }

    // Per DB
    public Disciplina(String nome, String descrizione, Allievo[] iscritti, Palestra[] palestre) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.iscritti = iscritti;
        this.palestre = palestre;
    }

    // Per modifica
    public Disciplina(Disciplina d) {
        this.nome = d.nome;
        this.descrizione = d.descrizione;
        this.iscritti = d.iscritti;
        this.palestre = d.palestre;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Allievo[] getIscritti() {
        return iscritti;
    }

    public void setIscritti(Allievo[] iscritti) {
        this.iscritti = iscritti;
    }

    public Palestra[] getPalestre() {
        return palestre;
    }

    public void setPalestre(Palestra[] palestre) {
        this.palestre = palestre;
    }
}

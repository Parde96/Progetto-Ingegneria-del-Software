package DAOs;

import federazione.Palestra;
import federazione.utenti.Allievo;
import java.util.ArrayList;

public class DAOPalestra {

    private ArrayList<Palestra> pp;

    public DAOPalestra() {
        pp = new ArrayList<>();
    }
    
    public ArrayList<Palestra> recuperaPalestre() {
        return pp;
    }

    public boolean aggiungiPalestra(Palestra p) {
        pp.add(p);
        return true;
    }

    public boolean modificaPalestra(Palestra modificare, Palestra modificata) {
        pp.remove(modificare);
        pp.add(modificata);
        return true;
    }

    public boolean eliminaPalestra(Palestra p) {
        return true;
    }
    
    public boolean iscriviInPalestra(Allievo a, Palestra p){
        return true;
    }
}

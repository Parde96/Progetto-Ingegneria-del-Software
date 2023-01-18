package controllers;

import DAOs.DAOPalestra;
import DAOs.DAOUtente;
import federazione.Palestra;
import federazione.utenti.Maestro;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControllerMaestroTest {

    public static ControllerMaestro cm;

    public ControllerMaestroTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        String nome = "";
        String cognome = "";
        String dataNascita = "";
        String codFisc = "";
        String telefono = "0";
        String email = "";
        String password = "";
        cm = new ControllerMaestro(new Maestro(nome, cognome, dataNascita, 
                codFisc, telefono, email, password), new DAOUtente());
    }

    @Test
    public void testModificaNomePalestraDB() {

        /*
        Testa che sia stata eseguita l'operazione sul DB, adesso 
        semplicemente controlla che si arrivi a chiamare quel metodo
         */
        
        //Set up di palestra e recupero, in realtà saranno riprese da una 
        //lista nella pagina web
        
        String nome = "";
        String indirizzo = "";
        int telefono = 0;
        String email = "";
        Palestra p = new Palestra(nome, indirizzo, telefono, email);

        nome = "Renbukan";
        cm.setControllerPalestra(new ControllerPalestra(new DAOPalestra()));
        assertTrue(cm.modificaPalestra(p, nome, indirizzo, telefono, email));
    }

    @Test
    public void testModificaNomePalestra() {

        //Set up di palestra e recupero, in realtà saranno riprese da una 
        // lista dalla pagina web
        String nome = "Renbuken";
        String indirizzo = "";
        int telefono = 0;
        String email = "";
        //Supponendo di aver già testato ControllerPalestra
        ControllerPalestra cp = new ControllerPalestra(new DAOPalestra());
        cp.aggiungiPalestra(nome, indirizzo, telefono, email);
        Palestra actual = cp.recuperaPalestreFederazione().get(0);

        nome = "Renbukan";
        Palestra expected = new Palestra(actual);
        expected.setNome(nome);

        //Test
        cm.setControllerPalestra(cp);
        cm.modificaPalestra(actual, nome, indirizzo, telefono, email);

        actual = cp.recuperaPalestreFederazione().get(0);
        //assertEquals(cp.visualizzaDati(expected), cp.visualizzaDati(actual));
        // Meglio questo che controlla anche id
        assertEquals(expected, actual);
    }

}

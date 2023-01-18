package controllers;

import DAOs.DAOUtente;
import federazione.Palestra;
import federazione.eventi.Evento;
import federazione.eventi.Stage;
import federazione.utenti.Allievo;
import federazione.utenti.Istruttore;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ControllerAllievoTest {
    
    private static ControllerAllievo ca;
    private static ControllerEvento ce;
    
    public ControllerAllievoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        String nome = "Msttia";
        String cognome = "Pardeo";
        String dataNascita = "17-04-1996";
        String codFisc = "PRDMTT96D17D575E";
        String telefono = "3xxxxxxxxx";
        String email = "mattia.pardeo@stud.unifi.it";
        String password = "MattiaP.";
        ca = new ControllerAllievo(new Allievo(nome, cognome, dataNascita, 
                codFisc, telefono, email, password), new DAOUtente());
        //Controller creato dalla pagina in realtà e poi settato
        ce = new ControllerEvento(null);
        ca.setControllerEvento(ce);
    }
    
    @Test
    public void testModificaDati() {
        //Setup
        String nome = "Mattia";
        String cognome = "";
        String dataNascita = "";
        String codFisc = "";
        String telefono = "";
        String email = "";
        String password = "";
        Allievo expected = new Allievo(ca.utente);
        expected.setNome(nome);
        
        //Test
        ca.modificaDati(nome, cognome, dataNascita, codFisc, telefono, 
                email, password);
        //assertEquals(test.visualizzaDati(), actual.visualizzaDati());
        Allievo actual = ca.utente;
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testIscriviAEvento(){
       
        //Evento in realtà inviato dalla pagina web al controller eventi
        Evento testStage = new Stage("12-12-2022", "10.30", "Stage", 
                "Stage di Karambit", new Istruttore(), new Palestra());
        
        ca.iscriviAEvento(testStage);
        assertTrue(testStage.getIscritti().contains(ca.utente));
    }
    
}
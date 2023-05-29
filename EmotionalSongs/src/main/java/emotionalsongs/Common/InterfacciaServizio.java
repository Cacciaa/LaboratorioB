/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emotionalsongs.Common;

import emotionalsongs.Common.*;
import java.rmi.Remote;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public interface InterfacciaServizio extends Remote {

    void login(String cf, String password) throws UtenteInesistente, PasswordErrata, MyServerException;

    void registrazione(String cf, String nome, String cognome, String citta, int cap, String via, int civico, String email, String password) throws ChiaveDuplicata, DatiNonValidi, MyServerException;

    ArrayList<Canzoni> filtraPerTitolo(String titolo) throws CanzoneInesistente, MyServerException;

    ArrayList<Canzoni> filtraPerAutoreAnno(String autore, int anno) throws CanzoneInesistente, MyServerException;

    Emozioni getEmozioniFromBrano(String titolo, String autore, int anno) throws EmozioniInesistenti, MyServerException;

    ArrayList<Canzoni> getCanzoniForPlaylist() throws MyServerException, CanzoneInesistente;

    void createPlaylist(String nomeplaylist, ArrayList<Canzoni> canzoni, String cf) throws ChiaveDuplicata,DatiNonValidi, MyServerException;

    ArrayList<Playlist> getPlaylist(String cf) throws PlaylistInesistenti, MyServerException;

    ArrayList<Canzoni> getCanzoniFromPlaylist(String idPlaylist) throws MyServerException,CanzoneInesistente ;

    void inserisciEmozione (String titolo, String autore, int anno, String cf, 
            int amazement, int nostalgia, int calmness, int power, int joy, int tension, int sadness, int tenderness, int solemnity, 
            String amazement_notes, String nostalgia_notes, String calmness_notes, String power_notes, String joy_notes, String tension_notes,String sadness_notes,
            String tenderness_notes, String solemnity_notes) throws MyServerException, DatiNonValidi,ChiaveDuplicata;
    
    
    
}

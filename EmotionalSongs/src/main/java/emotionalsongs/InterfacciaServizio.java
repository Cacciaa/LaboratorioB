/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emotionalsongs;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public interface InterfacciaServizio extends Remote {

    boolean login(String cf, String password) throw UtenteInesistente, PasswordErrata;

    boolean registrazione(String cf, String nome, String cognome, String citta, int cap, String via, int civico, String email, String password) throws UtenteGiaRegistrato, DatiNonValidi;

    ArrayList<Canzoni> filtraPerTitolo(String titolo) throws CanzoneInesistente;

    ArrayList<Canzoni> filtraPerAutoreAnno(String autore, int anno) throws CanzoneInesistenti;

    Emozioni getEmozioniFromBrano(String titolo, String autore, int anno) throws EmozioniInesistenti;

    ArrayList<Canzoni> getCanzoniForPlaylist() throws MyServerException;

    boolean createPlaylist(String nomeplaylist, ArrayList<Canzoni> canzoni, String cf) throws MyServerException;

    ArrayList<Playlist> getPlaylist(String cf) throws PlaylistInesistenti;

    ArrayList<Canzoni> getCanzoniFromPlaylist(String idPlaylist) throws MyServerException ;

    boolean inserisciEmozione (String titolo, String autore, int anno, String cf, 
            int amazement, int nostalgia, int calmness, int power, int joy, int tension, int sadness, int tenderness, int solemnity, 
            String amazament_notes, String nostalgia_notes, String calmness_notes, String power_notes, String joy_notes, String tension_notes,String sadness_notes,
            String tenderness_notes, String solemnity_notes);
    
    
    
}

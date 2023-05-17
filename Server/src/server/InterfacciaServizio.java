/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public interface InterfacciaServizio {

    boolean login(String cf, String password);

    boolean registrazione(String cf, String nome, String cognome, String citta, int cap, String via, int civico, String email, String password);

    ArrayList<Canzoni> filtraPerTitolo(String titolo);

    ArrayList<Canzoni> filtraPerAutoreAnno(String autore, int anno);

    Emozioni getEmozioniFromBrano(String titolo, String autore, int anno);

    ArrayList<Canzoni> getCanzoniForPlaylist();

    boolean createPlaylist(String nomeplaylist, ArrayList<Canzoni> canzoni, String cf);

    ArrayList<Playlist> getPlaylist(String cf);

    ArrayList<Canzoni> getCanzoniFromPlaylist(String idPlaylist);

    boolean inserisciEmozione (String titolo, String autore, int anno, String cf, 
            int amazement, int nostalgia, int calmness, int power, int joy, int tension, int sadness, int tenderness, int solemnity, 
            String amazament_notes, String nostalgia_notes, String calmness_notes, String power_notes, String joy_notes, String tension_notes,String sadness_notes,
            String tenderness_notes, String solemnity_notes);
    
    
    
}

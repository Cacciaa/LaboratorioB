/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import common.PasswordErrata;
import common.Canzoni;
import common.PlaylistInesistenti;
import common.EmozioniCanzone;
import common.EmozioniInesistenti;
import common.Emozioni;
import common.UtenteInesistente;
import common.MediaEmozioni;
import common.CanzoneInesistente;
import common.Playlist;
import common.UtentiRegistrati;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class DataTables {

    private ArrayList<Canzoni> canzonitable;
    
    private Emozioni emozionitable;
    
    private ArrayList<Playlist> playlistable;

    public DataTables() {
         this.canzonitable = new ArrayList<>();
         this.emozionitable = new Emozioni();
         this.playlistable = new ArrayList<>();
    }

   

    public ArrayList<Canzoni> handleCanzoniSet(ResultSet rs) throws SQLException, CanzoneInesistente {
        resetCanzoniTable();
        while (rs.next()) {

            Canzoni canzone = new Canzoni(rs.getString("titolo"), rs.getString("autore"), rs.getInt("anno"));

            canzonitable.add(canzone);
        }
        
        if(canzonitable.size() > 0){
            return canzonitable;
        }
        else{
            throw new CanzoneInesistente("GET CANZONI FAILED - Nessuna canzone trovata");
        }
    }
    
    public Emozioni handleEmozioniSet(ResultSet rs, ResultSet rsmedia) throws SQLException, EmozioniInesistenti{
        resetEmozioni();
        while (rs.next()) {
            EmozioniCanzone emocanzone = new EmozioniCanzone(rs.getInt("idvalutazione"), rs.getString("titolo"), rs.getString("autore"), 
                                        rs.getInt("anno"), rs.getString("codicefiscale"), rs.getInt("amazement"), rs.getInt("nostalgia"), 
                                        rs.getInt("calmness"), rs.getInt("power"), rs.getInt("joy"), rs.getInt("tension"), rs.getInt("sadness"),
                                        rs.getInt("tenderness"), rs.getInt("solemnity"), rs.getString("amazement_notes"), rs.getString("nostalgia_notes"),
                                        rs.getString("calmness_notes"),  rs.getString("power_notes"), rs.getString("joy_notes"), rs.getString("tension_notes"),
                                        rs.getString("sadness_notes"), rs.getString("tenderness_notes"), rs.getString("solemnity_notes"));
           emozionitable.aggiungiEmozione(emocanzone);
        }
        
        
        MediaEmozioni media = new MediaEmozioni(rsmedia.getInt("avg_amazement"), rsmedia.getInt("avg_nostalgia"), rsmedia.getInt("avg_calmness"),
                                            rsmedia.getInt("avg_power"), rsmedia.getInt("avg_joy"), rsmedia.getInt("avg_tension"),
                                            rsmedia.getInt("avg_sadness"), rsmedia.getInt("avg_tenderness"), rsmedia.getInt("avg_solemnity"));
        
        emozionitable.setMedia(media);
        
        if(emozionitable.getNumeroEmozioni() > 0){
            return emozionitable;
        }
        else{
            throw new EmozioniInesistenti("GET EMOZIONI FAILED - Nessuna emozione trovata");
        }
    }
    
    public ArrayList<Playlist> handlePlaylistSet(ResultSet rs) throws PlaylistInesistenti, SQLException{
        resetPlaylistTable();
        
        while(rs.next()){
             Playlist pl = new Playlist(rs.getInt("idplaylist"), rs.getString("nomeplaylist"), rs.getString("codicefiscale"));

            playlistable.add(pl);
        }
        
        if(playlistable.size() > 0){
            return playlistable;
        }
        else{
            throw new PlaylistInesistenti("GET PLAYLIST FAILED -  Playlist non trovata");
        }
    }
    
    
    public UtentiRegistrati handleUtenteRegistrato(ResultSet rs) throws SQLException{
        
        return new UtentiRegistrati(rs.getString("nome"),rs.getString("cognome"));
    }
        
     public void checkLogin(ResultSet rs, String password) throws SQLException, PasswordErrata, UtenteInesistente {
        if (rs.next()) {
            if (!(rs.getString("password").equals(password))) {
                throw new PasswordErrata("LOGIN FAILED - Password non corretta");
            }
        } else {
            throw new UtenteInesistente("LOGIN FAILED - Utente inesistente");
        }

    }
     
     public void resetCanzoniTable(){
         canzonitable.clear();
     }
     
     public void resetEmozioni(){
         emozionitable = new Emozioni();
     }
     
     public void resetPlaylistTable(){
         playlistable.clear();
     }
     
}

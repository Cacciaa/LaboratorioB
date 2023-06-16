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
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo Erba, 748702
 *
 * Lorenzo Erba, 748702,Ferialdo Elezi 749721,Alessandro Zancanella
 * 751494,Matteo Cacciarino 748231, sede CO
 *
 * Classe rappresentante il datamodel dei resultset
 */
public class DataTables implements Serializable {

    /**
     * @brief Metodo invocato per mappare il datamodel delle canzoni ottenute dall'esecuzione delle query
     * @param rs oggetto di tipo ResultSet contenente il resultset ottenuto dall'esecuzione delle query
     * @return oggetto di tipo ArrayList<Canzoni> contenente le canzoni ottenute come risultato dalle query
     * @throws SQLException eccezione sollevata nel caso in cui il mapping produca errori
     * @throws CanzoneInesistente eccezione sollevata nel caso in cui l'esecuzione della query non produca risultato
     */
    public ArrayList<Canzoni> handleCanzoniSet(ResultSet rs) throws SQLException, CanzoneInesistente {
        ArrayList<Canzoni> canzonitable = new ArrayList<Canzoni>();
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
    
    /**
     * @brief Metodo invocato per mappare il datamodel delle emozioni ottenute dall'esecuzione delle query
     * @param rs oggetto di tipo ResultSet contenente il resultset ottenuto dall'esecuzione delle query
     * @return oggetto di tipo Emozioni contenente le emozioni ottenute come risultato dalle query
     * @throws SQLException eccezione sollevata nel caso in cui il mapping produca errori
     * @throws EmozioniInesistenti eccezione sollevata nel caso in cui l'esecuzione della query non produca risultato
     */
    public Emozioni handleEmozioniSet(ResultSet rs) throws SQLException, EmozioniInesistenti{
        Emozioni emozionitable = new Emozioni();
        while (rs.next()) {
            EmozioniCanzone emocanzone = new EmozioniCanzone(rs.getInt("idvalutazione"), rs.getString("titolo"), rs.getString("autore"), 
                                        rs.getInt("anno"), rs.getString("codicefiscale"), rs.getInt("amazement"), rs.getInt("nostalgia"), 
                                        rs.getInt("calmness"), rs.getInt("power"), rs.getInt("joy"), rs.getInt("tension"), rs.getInt("sadness"),
                                        rs.getInt("tenderness"), rs.getInt("solemnity"), rs.getString("amazement_notes"), rs.getString("nostalgia_notes"),
                                        rs.getString("calmness_notes"),  rs.getString("power_notes"), rs.getString("joy_notes"), rs.getString("tension_notes"),
                                        rs.getString("sadness_notes"), rs.getString("tenderness_notes"), rs.getString("solemnity_notes"));
           emozionitable.aggiungiEmozione(emocanzone);
        }
        
         if(emozionitable.getNumeroEmozioni() > 0){
            return emozionitable;
        }
        else{
            throw new EmozioniInesistenti("GET EMOZIONI FAILED - Nessuna emozione trovata");
        }
 
    }
    
    /**
     * @brief Metodo invocato per mappare il datamodel delle medie emozioni ottenute dall'esecuzione delle query
     * @param rsmedia oggetto di tipo ResultSet contenente il resultset ottenuto dall'esecuzione delle query
     * @return oggetto di tipo MediaEmozioni contenente le medie delle emozioni ottenute come risultato dalle query
     * @throws SQLException  eccezione sollevata nel caso in cui il mapping produca errori
     */
    public MediaEmozioni handleEmozioniMediaSet(ResultSet rsmedia) throws SQLException{
        rsmedia.next();
        MediaEmozioni media = new MediaEmozioni((int) rsmedia.getDouble("avg_amazement"), (int) rsmedia.getDouble("avg_nostalgia"), (int) rsmedia.getDouble("avg_calmness"),
                                            (int) rsmedia.getDouble("avg_power"), (int) rsmedia.getDouble("avg_joy"), (int) rsmedia.getDouble("avg_tension"),
                                            (int) rsmedia.getDouble("avg_sadness"), (int) rsmedia.getDouble("avg_tenderness"), (int) rsmedia.getDouble("avg_solemnity"));
        
        
        return media;
    }
    
    /**
     * @brief Metodo invocato per mappare il datamodel delle playlist ottenute dall'esecuzione delle query
     * @param rs oggetto di tipo ResultSet contenente il resultset ottenuto dall'esecuzione delle query
     * @return oggetto di tipo ArrayList<Playlist> contenente le playlist ottenute come risultato dalle query
     * @throws PlaylistInesistenti eccezione sollevata nel caso in cui l'esecuzione della query non produca risultato
     * @throws SQLException eccezione sollevata nel caso in cui il mapping produca errori
     */
    public ArrayList<Playlist> handlePlaylistSet(ResultSet rs) throws PlaylistInesistenti, SQLException{
        ArrayList<Playlist> playlistable = new ArrayList<Playlist>();
        
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
    
    /**
     * @brief Metodo invocato per mappare il datamodel degli utenti registrati ottenuti dall'esecuzione delle query
     * @param rs oggetto di tipo ResultSet contenente il resultset ottenuto dall'esecuzione delle query
     * @return oggetto di tipoUtentiRegistrati contenente gli utenti registrati ottenuti come risultato dalle query
     * @throws SQLException eccezione sollevata nel caso in cui il mapping produca errori
     */
    public UtentiRegistrati handleUtenteRegistrato(ResultSet rs) throws SQLException{
        
        return new UtentiRegistrati(rs.getString("nome"),rs.getString("cognome"));
    }
      
    /**
     * @brief Metodo invocato per effettuare il login da parte dell'utente. Controlla se l'utente che ha richiesto l'accesso ha inserito le credenziali corrette
     * @param rs oggetto di tipo ResultSet contenente il resultset ottenuto dall'esecuzione delle query
     * @param password oggetto di tipo String contenente la password dell'utente
     * @throws SQLException eccezione sollevata nel caso in cui il mapping produca errori
     * @throws PasswordErrata eccezione sollevata nel caso la password inserita dall'utente è errata
     * @throws UtenteInesistente eccezione sollevata nel caso l'utente che ha richiesto l'accesso non risulti registrato
     */
     public void checkLogin(ResultSet rs, String password) throws SQLException, PasswordErrata, UtenteInesistente {
        if (rs.next()) {
            if (!(rs.getString("password").equals(password))) {
                throw new PasswordErrata("LOGIN FAILED - Password non corretta");
            }
        } else {
            throw new UtenteInesistente("LOGIN FAILED - Utente inesistente");
        }

    }
     
   
     
}

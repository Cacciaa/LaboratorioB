/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.Serializable;

/**
 *
 * @author Lorenzo Erba, 748702
 *
 * Lorenzo Erba, 748702,Ferialdo Elezi 749721,Alessandro Zancanella 751494,Matteo Cacciarino 748231, sede CO
 * 
 * Classe rappresentante la playlist dell'utente
 */
public class Playlist implements Serializable {
    //attributo privato di tipo int contenente l'id della playlist
    private int idPlaylist;
    
    //attributo privato di tipo String contenente il nome della playlist
    private String nomeplaylist;
    
    //attributo privato di tipo String contenente il codicefiscale dell'utente
    private String codiceFiscale;
    
    /**
     * @brief Costruttore parametrico della classe Playlist
     * @param idPlaylist oggetto di tipo int contenente l'id della playlist
     * @param nomeplaylist oggetto di tipo String contenente il nome della playlist
     * @param codiceFiscale oggetto di tipo String contenente il codicefiscale dell'utente
     */
    public Playlist(int idPlaylist, String nomeplaylist, String codiceFiscale) {
        this.idPlaylist = idPlaylist;
        this.nomeplaylist = nomeplaylist;
        this.codiceFiscale = codiceFiscale;
    }

    /**
     * @brief Getter dell'attributo idplaylist
     * @return oggetto di tipo int contenente l'id della playlist
     */
    public int getIdPlaylist() {
        return idPlaylist;
    }
    
    /**
     * @brief Setter dell'attributo idplaylist
     * @param idPlaylist  oggetto di tipo int contenente l'id della playlist
     */
    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }
    
    /**
     * @brief Getter dell'attributo nomeplaylist
     * @return oggetto di tipo String contenente il nome della playlist
     */
    public String getNomeplaylist() {
        return nomeplaylist;
    }
    
    /**
     * @brief Setter dell'attributo nomeplaylist
     * @param nomeplaylist oggetto di tipo String contenente il nome della playlist
     */
    public void setNomeplaylist(String nomeplaylist) {
        this.nomeplaylist = nomeplaylist;
    }

    /**
     * @brief Getter dell'attributo codicefiscale
     * @return oggetto di tipo String contenente il codicefiscale dell'utente
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    
    /**
     * @brief Setter dell'attributo codicefiscale
     * @param codiceFiscale oggetto di tipo String contenente il codicefiscale dell'utente
     */
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }
    
    
}

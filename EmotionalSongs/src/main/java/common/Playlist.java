/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.Serializable;

/**
 *
 * @author Lorenzo
 */
public class Playlist implements Serializable {
    private int idPlaylist;
    
    private String nomeplaylist;
    
    private String codiceFiscale;

    public Playlist(int idPlaylist, String nomeplaylist, String codiceFiscale) {
        this.idPlaylist = idPlaylist;
        this.nomeplaylist = nomeplaylist;
        this.codiceFiscale = codiceFiscale;
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getNomeplaylist() {
        return nomeplaylist;
    }

    public void setNomeplaylist(String nomeplaylist) {
        this.nomeplaylist = nomeplaylist;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }
    
    
}

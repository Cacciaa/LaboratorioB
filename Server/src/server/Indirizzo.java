/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.Serializable;

/**
 *
 * @author Lorenzo
 */
public class Indirizzo implements Serializable{
    
    private String citta;
    
    private int cap;
    
    private String via;
    
    private int civico;

    public Indirizzo(String citta, int cap, String via, int civico) {
        this.citta = citta;
        this.cap = cap;
        this.via = via;
        this.civico = civico;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getCivico() {
        return civico;
    }

    public void setCivico(int civico) {
        this.civico = civico;
    }
    
    
    
    
}

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
 * Classe rappresentante l'utente registrato al sistema
 */
public class UtentiRegistrati implements Serializable {
    
    //attributo privato di tipo String contenente il codicefiscale dell'utente
    private String codiceFiscale;
    
    //attributo privato di tipo String contenente il nome dell'utente
    private String nome;
    
    //attributo privato di tipo String contenente il cognome dell'utente
    private String cognome;
    
    //attributo privato di tipo String contenente la citta dell'utente
    private String citta;
    
    //attributo privato di tipo int contenente il cap dell'utente
    private int cap;
    
    //attributo privato di tipo String contenente la via dell'utente
    private String via;
    
    //attributo privato di tipo int contenente il civico dell'utente
    private int civico;
    
    //attributo privato di tipo String contenente l'email dell'utente
    private String email;
    
    //attributo privato di tipo String contenente la password dell'utente
    private String password;
    
    /**
     * @brief Costruttore parametrico della classe UtentiRegistrati
     * @param codiceFiscale oggetto di tipo String contenente il codicefiscale dell'utente
     * @param nome oggetto di tipo String contenente il nome dell'utente
     * @param cognome oggetto di tipo String contenente il cognome dell'utente
     * @param citta oggetto di tipo String contenente la citta dell'utente
     * @param cap oggetto di tipo int contenente il cap dell'utente
     * @param via oggetto di tipo String contenente la via dell'utente
     * @param civico oggetto di tipo int contenente il civico dell'utente
     * @param email oggetto di tipo String contenente l'email dell'utente
     * @param password  oggetto di tipo String contenente la password dell'utente
     */
    public UtentiRegistrati(String codiceFiscale, String nome, String cognome, String citta, int cap, String via, int civico, String email, String password) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.citta = citta;
        this.cap = cap;
        this.via = via;
        this.civico = civico;
        this.email = email;
        this.password = password;
    }
    
    /**
     * @brief Costruttore parametrico della classe UtentiRegistrati
     * @param nome oggetto di tipo String contenente il nome dell'utente
     * @param cognome oggetto di tipo String contenente il cognome dell'utente
     */
    public UtentiRegistrati(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }
    
    /**
     * @brief Getter dell'attributo codicefiscale 
     * @return oggetto di tipo String rappresentante il codicefiscale
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    
    /**
     * @brief Setter dell'attributo codicefiscale
     * @param codiceFiscale oggetto di tipo String contenente il codicefiscale
     */
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }
    
    /**
     * @brief Getter dell'attributo nome
     * @return oggetto di tipo String rappresentante il nome
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * @brief Setter dell'attributo nome
     * @param nome oggetto di tipo String contenente il nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @brief Getter dell'attributo cognome
     * @return oggetto di tipo String rappresentante il cognome
     */
    public String getCognome() {
        return cognome;
    }
    
    /**
     * @brief Setter dell'attributo cognome
     * @param cognome oggetto di tipo String contenente il cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    /**
     * @brief Getter dell'attributo citta
     * @return oggetto di tipo String rappresentante la citta
     */
    public String getCitta() {
        return citta;
    }
    
    /**
     * @brief Setter dell'attributo citta
     * @param citta oggetto di tipo String contenente la citta
     */
    public void setCitta(String citta) {
        this.citta = citta;
    }
    
    /**
     * @brief Getter dell'attributo cap
     * @return oggetto di tipo int rappresentante il cap
     */
    public int getCap() {
        return cap;
    }
    
    /**
     * @brief Setter dell'attributo cap
     * @param cap oggetto di tipo int contenente il cap
     */
    public void setCap(int cap) {
        this.cap = cap;
    }
    
    /**
     * @brief Getter dell'attributo via
     * @return oggetto di tipo String rappresentante la via
     */
    public String getVia() {
        return via;
    }
    
    /**
     * @brief Setter dell'attributo via
     * @param via oggetto di tipo String contenente la via
     */
    public void setVia(String via) {
        this.via = via;
    }
    
    /**
     * @brief Getter dell'attributo civico
     * @return oggetto di tipo int rappresentante il civico
     */
    public int getCivico() {
        return civico;
    }
    
    /**
     * @brief Setter dell'attributo civico
     * @param civico oggetto di tipo int contenente il civico
     */
    public void setCivico(int civico) {
        this.civico = civico;
    }
    
    /**
     * @brief Getter dell'attributo email
     * @return oggetto di tipo String rappresentante la mail
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * @brief Setter dell'attributo email
     * @param email oggetto di tipo String contenente l'email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * @brief Getter dell'attributo password
     * @return oggetto di tipo String rappresentante la password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * @brief Setter dell'attributo password
     * @param password oggetto di tipo String contenente la password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}

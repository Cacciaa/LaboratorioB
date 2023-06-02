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
 * Classe rappresentante l'emozione rilasciata da un utente per una determinata canzone
 */
public class EmozioniCanzone implements Serializable {
    
    //atributo privato di tipo int rappresentante l'id dell'emozione rilasciata
    private int idValutazione;
    
    //attributo privato di tipo String rappresentante il titolo della canzone
    private String titolo;

    //attributo privato di tipo String rappresentante l'autore della canzone
    private String autore;
    
    //attributo privato di tipo int rappresentante l'anno di rilascio della canzone
    private int anno;
    
    //attributo privato di tipo String rappresentante il codicefiscale dell'utente
    private String codiceFiscale;
    
    //attributo privato di tipo int rappresentante l'emozione amazement
    private int amazement;
    
    //attributo privato di tipo int rappresentante l'emozione nostalgia
    private int nostalgia;
    
    //attributo privato di tipo int rappresentante l'emozione calmness
    private int calmness;
    
    //attributo privato di tipo int rappresentante l'emozione power
    private int power;
    
    //attributo privato di tipo int rappresentante l'emozione joy 
    private int joy;
    
    //attributo privato di tipo int rappresentante l'emozione tension
    private int tension;
    
    //attributo privato di tipo int rappresentante l'emozione sadness
    private int sadness;
    
    //attributo privato di tipo int rappresentante l'emozione tenderness
    private int tenderness;
    
    //attributo privato di tipo int rappresentante l'emozione solemnity
    private int solemnity;
    
    //attributo privato di tipo String rappresentante le note dell'emozione amazement 
    private String amazement_notes;
    
    //attributo privato di tipo String rappresentante le note dell'emozione nostalgia  
    private String nostalgia_notes;
    
    //attributo privato di tipo String rappresentante le note dell'emozione calmness
    private String calmness_notes;
    
    //attributo privato di tipo String rappresentante le note dell'emozione power
    private String power_notes;
    
    //attributo privato di tipo String rappresentante le note dell'emozione joy
    private String joy_notes;
    
    //attributo privato di tipo String rappresentante le note dell'emozione tension
    private String tension_notes;
    
    //attributo privato di tipo String rappresentante le note dell'emozione sadness
    private String sadness_notes;
    
    //attributo privato di tipo String rappresentante le note dell'emozione tenderness
    private String tenderness_notes;
    
    //attributo privato di tipo String rappresentante le note dell'emozione solemnity
    private String solemnity_notes;
    
    /**
     * @brief Costruttore della classe EmozioniCanzone
     * @param idValutazione oggetto di tipo int rappresentante l'id dell'emozione rilasciata
     * @param titolo oggetto di tipo String rappresentante il titolo della canzone
     * @param autore oggetto di tipo String rappresentante l'autore della canzone
     * @param anno oggetto di tipo int rappresentante l'anno della canzone
     * @param codiceFiscale oggetto di tipo String rappresentante il codicefiscale dell'utente
     * @param amazement oggetto di tipo int rappresentante l'emozione amazement
     * @param nostalgia oggetto di tipo int rappresentante l'emozione nostalgia
     * @param calmness oggetto di tipo int rappresentante l'emozione calmness
     * @param power oggetto di tipo int rappresentante l'emozione power
     * @param joy oggetto di tipo int rappresentante l'emozione joy
     * @param tension oggetto di tipo int rappresentante l'emozione tension
     * @param sadness oggetto di tipo int rappresentante l'emozione sadness
     * @param tenderness oggetto di tipo int rappresentante l'emozione tenderness
     * @param solemnity oggetto di tipo int rappresentante l'emozione solemnity
     * @param amazement_notes  oggetto di tipo String rappresentante le note dell'emozione amazement
     * @param nostalgia_notes oggetto di tipo String rappresentante le note dell'emozione nostalgia
     * @param calmness_notes oggetto di tipo String rappresentante le note dell'emozione calmness
     * @param power_notes oggetto di tipo String rappresentante le note dell'emozione power
     * @param joy_notes oggetto di tipo String rappresentante le note dell'emozione joy
     * @param tension_notes oggetto di tipo String rappresentante le note dell'emozione tension
     * @param sadness_notes oggetto di tipo String rappresentante le note dell'emozione sadness
     * @param tenderness_notes oggetto di tipo String rappresentante le note dell'emozione tenderness
     * @param solemnity_notes  oggetto di tipo String rappresentante le note dell'emozione solemnity
     */
    public EmozioniCanzone(int idValutazione, String titolo, String autore, int anno, String codiceFiscale, int amazement, int nostalgia, int calmness, int power, int joy, int tension, int sadness, int tenderness, int solemnity, String amazement_notes, String nostalgia_notes, String calmness_notes, String power_notes, String joy_notes, String tension_notes, String sadness_notes, String tenderness_notes, String solemnity_notes) {
        this.idValutazione = idValutazione;
        this.titolo = titolo;
        this.autore = autore;
        this.anno = anno;
        this.codiceFiscale = codiceFiscale;
        this.amazement = amazement;
        this.nostalgia = nostalgia;
        this.calmness = calmness;
        this.power = power;
        this.joy = joy;
        this.tension = tension;
        this.sadness = sadness;
        this.tenderness = tenderness;
        this.solemnity = solemnity;
        this.amazement_notes = amazement_notes;
        this.nostalgia_notes = nostalgia_notes;
        this.calmness_notes = calmness_notes;
        this.power_notes = power_notes;
        this.joy_notes = joy_notes;
        this.tension_notes = tension_notes;
        this.sadness_notes = sadness_notes;
        this.tenderness_notes = tenderness_notes;
        this.solemnity_notes = solemnity_notes;
    }
    
    /**
     * @brief Getter dell'attributo idvalutazione
     * @return oggetto di tipo int contenente l'id della valutazione
     */
    public int getIdValutazione() {
        return idValutazione;
    }
    
    /**
     * @brief Getter dell'attributo titolo
     * @return oggetto di tipo String contenente il titolo della canzone
     */
    public String getTitolo() {
        return titolo;
    }
    
    /**
     * @brief Getter dell'attributo autore
     * @return oggetto di tipo String contenente l'autore della canzone
     */
    public String getAutore() {
        return autore;
    }

    /**
     * @brief Getter dell'attributo anno
     * @return oggetto di tipo int contenente l'anno della canzone
     */
    public int getAnno() {
        return anno;
    }
    
    /**
     * @brief Getter dell'attributo codicefiscale
     * @return oggetto di tipo String contenente il codicefiscale
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    
    /**
     * @brief Getter dell'attributo amazement
     * @return oggetto di tipo int contenente l'emozione amazement
     */
    public int getAmazement() {
        return amazement;
    }
    
    /**
     * @brief Getter dell'attributo nostalgia
     * @return oggetto di tipo int contenente l'emozione nostalgia
     */
    public int getNostalgia() {
        return nostalgia;
    }

    /**
     * @brief Getter dell'attributo calmness
     * @return oggetto di tipo int contenente l'emozione calmness
     */
    public int getCalmness() {
        return calmness;
    }
    
    /**
     * @brief Getter dell'attributo power
     * @return oggetto di tipo int contenente l'emozione power
     */
    public int getPower() {
        return power;
    }
    
    /**
     * @brief Getter dell'attributo joy
     * @return oggetto di tipo int contenente l'emozione joy
     */
    public int getJoy() {
        return joy;
    }
    
    /**
     * @brief Getter dell'attributo tension
     * @return oggetto di tipo int contenente l'emozione tension
     */
    public int getTension() {
        return tension;
    }
    
    /**
     * @brief Getter dell'attributo sadness
     * @return oggetto di tipo int contenente l'emozione sadness
     */
    public int getSadness() {
        return sadness;
    }
    
    /**
     * @brief Getter dell'attributo tenderness
     * @return oggetto di tipo int contenente l'emozione tenderness
     */
    public int getTenderness() {
        return tenderness;
    }
    
    /**
     * @brief Getter dell'attributo solemnity
     * @return oggetto di tipo int contenente l'emozione solemnity
     */
    public int getSolemnity() {
        return solemnity;
    }
    
    /**
     * @brief Getter dell'attributo amazement_notes
     * @return oggetto di tipo String contenente la nota dell'emozione amazement
     */
    public String getAmazement_notes() {
        return amazement_notes;
    }
    
     /**
     * @brief Getter dell'attributo nostalgia_notes
     * @return oggetto di tipo String contenente la nota dell'emozione nostalgia
     */
    public String getNostalgia_notes() {
        return nostalgia_notes;
    }
    
    /**
     * @brief Getter dell'attributo calmness_notes
     * @return oggetto di tipo String contenente la nota dell'emozione calmness
     */
    public String getCalmness_notes() {
        return calmness_notes;
    }
    
    /**
     * @brief Getter dell'attributo power_notes
     * @return oggetto di tipo String contenente la nota dell'emozione power
     */
    public String getPower_notes() {
        return power_notes;
    }
    
    /**
     * @brief Getter dell'attributo joy_notes
     * @return oggetto di tipo String contenente la nota dell'emozione joy
     */
    public String getJoy_notes() {
        return joy_notes;
    }
    
    /**
     * @brief Getter dell'attributo tension_notes
     * @return oggetto di tipo String contenente la nota dell'emozione tension
     */
    public String getTension_notes() {
        return tension_notes;
    }
    
    /**
     * @brief Getter dell'attributo sadness_notes
     * @return oggetto di tipo String contenente la nota dell'emozione sadness
     */

    public String getSadness_notes() {
        return sadness_notes;
    }
    
    /**
     * @brief Getter dell'attributo tenderness_notes
     * @return oggetto di tipo String contenente la nota dell'emozione tenderness 
     */
    public String getTenderness_notes() {
        return tenderness_notes;
    }
    
    /**
     * @brief Getter dell'attributo solemnity_notes
     * @return oggetto di tipo String contenente la nota dell'emozione solemnity 
     */
    public String getSolemnity_notes() {
        return solemnity_notes;
    }

    
    
    

}

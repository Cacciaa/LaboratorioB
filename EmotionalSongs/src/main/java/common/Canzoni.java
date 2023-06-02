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
 * Classe rappresentante la canzone presente nella base di dati
 */
public class Canzoni implements Serializable {
    
    //attributo private di tipo String rappresentante il titolo della canzone
    private String titolo;
    
     //attributo private di tipo String rappresentante l'autore della canzone
    private String autore;
    
     //attributo private di tipo int rappresentante l'anno di pubblicazione della canzone
    private int anno;

    /**
     * @brief Costruttore della canzone
     * @param titolo oggetto di tipo String contenente il titolo della canzone
     * @param autore oggetto di tipo String contenente l'autore della canzone
     * @param anno oggetto di tipo int contenente l'anno di pubblicazione della canzone
     */
    public Canzoni(String titolo, String autore, int anno) {
        this.titolo = titolo;
        this.autore = autore;
        this.anno = anno;
    }
    
    /**
     * @brief Getter dell'attributo titolo
     * @return oggetto di tipo String contenente il titolo
     */
    public String getTitolo() {
        return titolo;
    }
    
    /**
     * @brief Setter dell'attributo titolo
     * @param titolo oggetto di tipo String contenente il titolo
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    
    /**
     * @brief Getter dell'attributo autore
     * @return oggetto di tipo String contenente l'autore
     */
    public String getAutore() {
        return autore;
    }
    
    /**
     * @brief Setter dell'attributo autore
     * @param autore oggetto di tipo String contenente l'autore
     */
    public void setAutore(String autore) {
        this.autore = autore;
    }
    
    /**
     * @brief Getter dell'attributo anno
     * @return oggetto di tipo int contenente l'anno
     */
    public int getAnno() {
        return anno;
    }
    
    /**
     * @brief Setter dell'attributo anno
     * @param anno oggetto di tipo int contenente l'anno
     */
    public void setAnno(int anno) {
        this.anno = anno;
    }
    
    
    
    
}

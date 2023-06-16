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
 * Lorenzo Erba, 748702,Ferialdo Elezi 749721,Alessandro Zancanella
 * 751494,Matteo Cacciarino 748231, sede CO
 *
 * Classe rappresentante le medie calcolate dal DBMS relative alle emozioni di una canzone
 */
public class MediaEmozioni implements Serializable {
    
    //attributo privato di tipo int rappresentante la media dell'emozione amazement
    private int avg_amazement;
    
    //attributo privato di tipo int rappresentante la media dell'emozione nostalgia
    private int avg_nostalgia;
    
    //attributo privato di tipo int rappresentante la media dell'emozione calmness
    private int avg_calmness;
    
    //attributo privato di tipo int rappresentante la media dell'emozione power
    private int avg_power;
    
    //attributo privato di tipo int rappresentante la media dell'emozione joy
    private int avg_joy;
    
    //attributo privato di tipo int rappresentante la media dell'emozione tension
    private int avg_tension;
    
    //attributo privato di tipo int rappresentante la media dell'emozione sadness
    private int avg_sadness;
    
    //attributo privato di tipo int rappresentante la media dell'emozione tenderness
    private int avg_tenderness;
    
    //attributo privato di tipo int rappresentante la media dell'emozione solemnity
    private int avg_solemnity;
    
    /**
     * @brief Costruttore parametrico della classe MediaEmozioni
     * @param avg_amazement oggetto di tipo int di tipo int rappresentante la media dell'emozione amazement
     * @param avg_nostalgia oggetto di tipo int rappresentante la media dell'emozione nostalgia
     * @param avg_calmness oggetto di tipo int rappresentante la media dell'emozione calmness
     * @param avg_power oggetto di tipo int rappresentante la media dell'emozione power
     * @param avg_joy oggetto di tipo int rappresentante la media dell'emozione joy
     * @param avg_tension oggetto di tipo int rappresentante la media dell'emozione tension
     * @param avg_sadness oggetto di tipo int rappresentante la media dell'emozione sadness
     * @param avg_tenderness oggetto di tipo int rappresentante la media dell'emozione tenderness
     * @param avg_solemnity oggetto di tipo int 
     */
    public MediaEmozioni(int avg_amazement, int avg_nostalgia, int avg_calmness, int avg_power, int avg_joy, int avg_tension, int avg_sadness, int avg_tenderness, int avg_solemnity) {
        this.avg_amazement = avg_amazement;
        this.avg_nostalgia = avg_nostalgia;
        this.avg_calmness = avg_calmness;
        this.avg_power = avg_power;
        this.avg_joy = avg_joy;
        this.avg_tension = avg_tension;
        this.avg_sadness = avg_sadness;
        this.avg_tenderness = avg_tenderness;
        this.avg_solemnity = avg_solemnity;
    }
    
    /**
     * @brief Costruttore di default della classe MediaEmozioni
     */
    public MediaEmozioni() {
        this.avg_amazement = 0;
        this.avg_nostalgia = 0;
        this.avg_calmness = 0;
        this.avg_power = 0;
        this.avg_joy = 0;
        this.avg_tension = 0;
        this.avg_sadness = 0;
        this.avg_tenderness = 0;
        this.avg_solemnity = 0;
    }
    
   
    /**
     * @Getter della media dell'emozione amazement
     * @return oggetto di tipo int contenente la media dell'emozione amazement
     */
    public int getAvg_amazement() {
        return avg_amazement;
    }
    
    /**
     * @Getter della media dell'emozione nostalgia
     * @return oggetto di tipo int contenente la media dell'emozione nostalgia
     */
    public int getAvg_nostalgia() {
        return avg_nostalgia;
    }
    
    /**
     * @Getter della media dell'emozione calmness
     * @return oggetto di tipo int contenente la media dell'emozione calmness
     */
    public int getAvg_calmness() {
        return avg_calmness;
    }
    
    /**
     * @Getter della media dell'emozione power
     * @return oggetto di tipo int contenente la media dell'emozione power
     */
    public int getAvg_power() {
        return avg_power;
    }
    
    /**
     * @Getter della media dell'emozione joy
     * @return oggetto di tipo int contenente la media dell'emozione joy
     */
    public int getAvg_joy() {
        return avg_joy;
    }
    
    /**
     * @Getter della media dell'emozione tension
     * @return oggetto di tipo int contenente la media dell'emozione tension
     */
    public int getAvg_tension() {
        return avg_tension;
    }
    
    /**
     * @Getter della media dell'emozione sadness
     * @return oggetto di tipo int contenente la media dell'emozione sadness
     */
    public int getAvg_sadness() {
        return avg_sadness;
    }
    
    /**
     * @Getter della media dell'emozione tenderness
     * @return oggetto di tipo int contenente la media dell'emozione tenderness
     */
    public int getAvg_tenderness() {
        return avg_tenderness;
    }
    
    /**
     * @Getter della media dell'emozione solemnity
     * @return oggetto di tipo int contenente la media dell'emozione solemnity
     */
    public int getAvg_solemnity() {
        return avg_solemnity;
    }
    
    
    
    
}

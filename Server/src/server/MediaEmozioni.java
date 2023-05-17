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
public class MediaEmozioni implements Serializable {
    
    
     private int avg_amazement;
    
    private int avg_nostalgia;
    
    private int avg_calmness;
    
    private int avg_power;
    
    private int avg_joy;
    
    private int avg_tension;
    
    private int avg_sadness;
    
    private int avg_tenderness;
    
    private int avg_solemnity;

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

    public int getAvg_amazement() {
        return avg_amazement;
    }

    public int getAvg_nostalgia() {
        return avg_nostalgia;
    }

    public int getAvg_calmness() {
        return avg_calmness;
    }

    public int getAvg_power() {
        return avg_power;
    }

    public int getAvg_joy() {
        return avg_joy;
    }

    public int getAvg_tension() {
        return avg_tension;
    }

    public int getAvg_sadness() {
        return avg_sadness;
    }

    public int getAvg_tenderness() {
        return avg_tenderness;
    }

    public int getAvg_solemnity() {
        return avg_solemnity;
    }
    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emotionalsongs.Common;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class Emozioni implements Serializable{
    
    private ArrayList<EmozioniCanzone> emozionicanzoni;
    private MediaEmozioni media;
    
    public Emozioni(ArrayList<EmozioniCanzone> emozionicanzoni, MediaEmozioni media){
        this.emozionicanzoni = emozionicanzoni;
        this.media = media;
    }
    
    public Emozioni(){
        this.emozionicanzoni = new ArrayList<>();
        this.media = media;
    }

    public ArrayList<EmozioniCanzone> getEmozionicanzoni() {
        return emozionicanzoni;
    }

    public MediaEmozioni getMedia() {
        return media;
    }
    
    
    public void aggiungiEmozione(EmozioniCanzone e){
        this.emozionicanzoni.add(e);
    }

    public void setMedia(MediaEmozioni media) {
        this.media = media;
    }
    
    public int getNumeroEmozioni(){
        return this.emozionicanzoni.size();
    }
    
    
    
    
}

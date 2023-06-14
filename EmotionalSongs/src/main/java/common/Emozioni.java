/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo Erba, 748702
 *
 * Lorenzo Erba, 748702,Ferialdo Elezi 749721,Alessandro Zancanella 751494,Matteo Cacciarino 748231, sede CO
 * 
 * Classe rappresentante l'emozione inserita dall'utente
 */
public class Emozioni implements Serializable{
    
    /**
     * attributo privato di tipo ArrayList<EmozioniCanzone> rappresentante la lista delle emozioni rilasciate dall'utente per una relativa canzone
     * @see EmozioniCanzone 
    */
    private ArrayList<EmozioniCanzone> emozionicanzoni;
    /**
     * attributo privato di tipo MediaEmozioni rappresentante le medie delle emozioni rilasciate dagli utenti per una relativa canzone
     * @see MediaEmozioni
    */
    private MediaEmozioni media;
    
    /**
     * Costruttore della classe Emozioni
     * @param emozionicanzoni oggetto di tipo EmozioniCanzone rappresentante la lista di emozioni rilasciate dall'utente per una relativa canzone
     * @param media oggetto di tipo MediaEmozioni rappresentante le medie delle emozioni rilasciate dagli utenti per una relativa canzone
     */
    public Emozioni(ArrayList<EmozioniCanzone> emozionicanzoni, MediaEmozioni media){
        this.emozionicanzoni = emozionicanzoni;
        this.media = media;
    }
    
    /**
     * @brief Costruttore di default
     * Inizializza a un oggetto di default gli attributi della classe Emozioni
     */
    public Emozioni(){
        this.emozionicanzoni = new ArrayList<>();
        this.media = new MediaEmozioni();
    }
    
    /**
     * @brief Getter dell'attributo emozionicanzoni
     * @return oggetto di tipo EmozioniCanzone rappresentante la lista di emozioni rilasciate dall'utente per una relativa canzone
     */
    public ArrayList<EmozioniCanzone> getEmozionicanzoni() {
        return emozionicanzoni;
    }
    
    /**
     * @brief Getter dell'attributo media
     * @return oggetto di tipo MediaEmozioni rappresentante le medie delle emozioni rilasciate dagli utenti per una relativa canzone
     */
    public MediaEmozioni getMedia() {
        return media;
    }
    
   
    /**
     * @brief Aggiunge l'emozione rilasciata da un utente per una determinata canzone alla lista attributo emozionicanzoni
     * @param e 
     */
    public void aggiungiEmozione(EmozioniCanzone e){
        this.emozionicanzoni.add(e);
    }
    
    /**
     * @brief Setter dell'attributo media
     * @param media 
     */
    public void setMedia(MediaEmozioni media) {
        this.media = media;
    }
    
    public int getNumeroEmozioni(){
        return this.emozionicanzoni.size();
    }
    
    
    
    
}

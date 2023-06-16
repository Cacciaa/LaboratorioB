/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

/**
 *
 * @author Lorenzo Erba, 748702
 *
 * Lorenzo Erba, 748702,Ferialdo Elezi 749721,Alessandro Zancanella 751494,Matteo Cacciarino 748231, sede CO
 * 
 * Classe rappresentante l'eccezzione UtenteInesistente sollevata qual'ora l'utente provi a registrarsi, essendo precedentemente già registrato al sistema
 */
public class UtenteInesistente extends Exception {
    
    /**
     * @brief Costruttore dell'eccezione 
     * @param message Oggetto di tipo stringa contentente il messaggio mostrato a console 
     */
    public UtenteInesistente(String message){
        super(message);
    }
}

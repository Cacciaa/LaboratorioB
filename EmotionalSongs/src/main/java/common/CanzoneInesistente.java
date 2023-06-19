
package common;

/**
 *
 * @author Lorenzo Erba, 748702
 *
 * Lorenzo Erba, 748702,Ferialdo Elezi 749721,Alessandro Zancanella 751494,Matteo Cacciarino 748231, sede CO
 * 
 * Classe rappresentante l'eccezzione CanzoneInesistente sollevata qual'ora la canzone ricercata non fosse presente nella base di dati
 */
public class CanzoneInesistente extends Exception {
    /**
     * @brief Costruttore dell'eccezione
     * @param message Oggetto di tipo stringa contentente il messaggio mostrato a console
     */
    public CanzoneInesistente(String message) {
        super(message);
    }
}

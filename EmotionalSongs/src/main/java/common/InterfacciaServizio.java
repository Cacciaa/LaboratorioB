/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.rmi.Remote;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo Erba, 748702
 *
 * Lorenzo Erba, 748702,Ferialdo Elezi 749721,Alessandro Zancanella
 * 751494,Matteo Cacciarino 748231, sede CO
 *
 * Classe rappresentante l'interfaccia del servizio implementato dal server
 */
public interface InterfacciaServizio extends Remote {

    /**
     * @brief Metodo per effettuare il login dell'utente al sistema
     * @param cf Oggetto di tipo String contenente il codicefiscale dell'utente
     * @param password oggetto di tipo String contenente la password dell'utente
     * @throws UtenteInesistente eccezione sollevata nel caso l'utente non sia
     * già registrato
     * @throws PasswordErrata eccezione sollevata nel caso la password inserita
     * dall'utente sia errata
     * @throws MyServerException eccezzione generica sollevata durante la
     * comunicazione col DBMS.
     */
    UtentiRegistrati login(String cf, String password) throws UtenteInesistente, PasswordErrata, MyServerException;

    /**
     * @brief Metodo per effettuare la registrazione al sistema
     *@param utente oggetto di classe UtentiRegistrati rappresentante l'utente da registrare
     * @throws ChiaveDuplicata eccezione sollevata nel caso l'utente sia già
     * registrato, chiave codicefiscale duplicata
     * @throws DatiNonValidi eccezione sollevata nel caso i dati inseriti non
     * rispettano i vincoli di integrità
     * @throws MyServerException eccezzione generica sollevata durante la
     * comunicazione col DBMS.
     */
    void registrazione(UtentiRegistrati utente) throws ChiaveDuplicata, DatiNonValidi, MyServerException;

    /**
     * @brief Metodo che filtra le canzoni per il titolo
     * @param titolo oggetto di tipo String contenente il titolo della canzone
     * da ricercare
     * @return oggetto di tipo ArrayList<Canzoni> contenente la lista delle
     * canzoni filtrate
     * @throws CanzoneInesistente eccezione sollevata nel caso la ricerca non
     * produca nessun risultato
     * @throws MyServerException eccezzione generica sollevata durante la
     * comunicazione col DBMS.
     */
    ArrayList<Canzoni> filtraPerTitolo(String titolo) throws CanzoneInesistente, MyServerException;

    /**
     * @brief Metodo che filtra le canzoni per autore e anno
     * @param autore oggetto di tipo String contenente l'autore della canzone da
     * ricercare
     * @param anno oggetto di tipo int contenente l'anno della canzone da
     * ricercare
     * @return oggetto di tipo ArrayList<Canzoni> contenente la lista delle
     * canzoni filtrate
     * @throws CanzoneInesistente eccezione sollevata nel caso la ricerca non
     * produca nessun risultato
     * @throws MyServerException eccezzione generica sollevata durante la
     * comunicazione col DBMS
     */
    ArrayList<Canzoni> filtraPerAutoreAnno(String autore, int anno) throws CanzoneInesistente, MyServerException;

    /**
     * @brief Metodo che restituisce le emozioni del brano specificato
     * @param canzone oggetto di tipo Canznoni rappresentante la canzone da cui ottenere le emozioni associate
     * @return oggetto di tipo Emozioni contenente le emozioni associate al
     * brano
     * @throws EmozioniInesistenti eccezione sollevata nel caso la ricerca non
     * produca nessun risultato
     * @throws MyServerException eccezzione generica sollevata durante la
     * comunicazione col DBMS
     */
    Emozioni getEmozioniFromBrano(Canzoni canzone) throws EmozioniInesistenti, MyServerException;

    /**
     * @brief Metodo che restituisce le canzoni da inserire nella playlist
     * dell'utente
     * @return @throws MyServerException eccezzione generica sollevata durante
     * la comunicazione col DBMS
     * @throws CanzoneInesistente eccezione sollevata nel caso la ricerca non
     * produca nessun risultato
     */
    ArrayList<Canzoni> getCanzoniForPlaylist() throws MyServerException, CanzoneInesistente;
    
    /**
     * @brief Metodo che crea la playlist inserendo le canzoni scelte dall'utente
     * @param nomeplaylist oggetto di tipo String contenente il nome della playlist
     * @param canzoni oggetto di tipo ArrayList<Canzoni> contenente le canzoni da inserire nella playlist
     * @param cf oggetto di tipo String contenente il codicefiscale dell'utente
     * @throws ChiaveDuplicata eccezione sollevata nel caso l'utente sia già
     * registrato, chiave codicefiscale duplicata
     * @throws DatiNonValidi eccezione sollevata nel caso i dati inseriti non
     * rispettano i vincoli di integrità
     * @throws MyServerException eccezzione generica sollevata durante
     * la comunicazione col DBMS
     */
    void createPlaylist(String nomeplaylist, ArrayList<Canzoni> canzoni, String cf) throws ChiaveDuplicata, DatiNonValidi, MyServerException;
    
    /**
     * @brief Metodo che restituisce le playlist associate all'utente
     * @param cf oggetto di tipo String contenente il codicefiscale dell'utente
     * @return oggetto di tipo ArrayList<Playlist> contenente 
     * @throws PlaylistInesistenti eccezione sollevata nel caso in cui la ricerca non produca nessun risultato
     * @throws MyServerException eccezzione generica sollevata durante
     * la comunicazione col DBMS
     */
    ArrayList<Playlist> getPlaylist(String cf) throws PlaylistInesistenti, MyServerException;
    
    /**
     * @brief Metodo che restituisce le canzoni associate alla playlist
     * @param idPlaylist oggetto di tipo String contenente l'id della playlist 
     * @return oggetto di tipo ArrayList<Canzoni> contenente la lista delle canzoni presenti nella playlist
     * @throws MyServerException eccezzione generica sollevata durante
     * la comunicazione col DBMS
     * @throws CanzoneInesistente eccezione sollevata nel caso la ricerca non
     * produca nessun risultato
     */
    ArrayList<Canzoni> getCanzoniFromPlaylist(String idPlaylist) throws MyServerException, CanzoneInesistente;
    
    /**
     * @brief Metodo che inserisce l'emozione rilasciata dall'utente
     * @param emocanzone oggetto di tipo EmozioniCanzone contenente le emozioni di una canzone rilasciate dall'utente
     * @throws MyServerException eccezzione generica sollevata durante
     * la comunicazione col DBMS
     * @throws ChiaveDuplicata eccezione sollevata nel caso l'utente sia già
     * registrato, chiave codicefiscale duplicata
     * @throws DatiNonValidi eccezione sollevata nel caso i dati inseriti non
     * rispettano i vincoli di integrità
     */
    void inserisciEmozione(String titolo, String autore, int anno, String cf, EmozioniCanzone emocanzone) throws MyServerException, DatiNonValidi, ChiaveDuplicata;

}

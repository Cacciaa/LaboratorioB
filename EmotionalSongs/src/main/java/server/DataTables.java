/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import emotionalsongs.Common.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class DataTables {

    private ArrayList<Canzoni> canzonitable;

    public DataTables() {
         this.canzonitable = new ArrayList<>();
        
    }

   

    public ArrayList<Canzoni> handleCanzoniSet(ResultSet rs) throws SQLException, CanzoneInesistente {
        reset(canzonitable);
        while (rs.next()) {

            Canzoni canzone = new Canzoni(rs.getString("titolo"), rs.getString("autore"), rs.getInt("anno"));

            canzonitable.add(canzone);
        }
        
        if(canzonitable.size() > 0){
            return canzonitable;
        }
        else{
            throw new CanzoneInesistente("FILTER FAILED - Canzone inesistente");
        }
    }
        
     public void checkLogin(ResultSet rs, String password) throws SQLException, PasswordErrata, UtenteInesistente {
        if (rs.next()) {
            if (!(rs.getString("password").equals(password))) {
                throw new PasswordErrata("LOGIN FAILED - Password non corretta");
            }
        } else {
            throw new UtenteInesistente("LOGIN FAILED - Utente inesistente");
        }

    }
     
     public void reset(ArrayList<Canzoni> lst){
         lst.clear();
     }
}

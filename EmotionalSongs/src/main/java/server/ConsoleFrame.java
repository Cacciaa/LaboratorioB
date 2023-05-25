/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package server;

import emotionalsongs.Common.*;
import java.awt.Window;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Lorenzo
 */
public class ConsoleFrame extends javax.swing.JPanel implements InterfacciaServizio {

    private Database db;
    private DataTables dt;

    /**
     * Creates new form ConsoleFrame
     */
    public ConsoleFrame(String user, String pass) {
        initComponents();

        try {
            //ottengo l'istanza singleton dell'oggetto per effettuare le chiamate al database
            this.db = Database.getInstance(user, pass);
            //stampo sulla console visuale un messaggio di avvenuta connesione
            this.txtAreaConsole.append("Connessione al database avvenuta correttamente.");

        } catch (SQLException ex) {
            //PopUp d'errore connessione al database
            JOptionPane.showConfirmDialog(null, "Errore di connessione al database", "Errore di connessione.", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);

            //chiusura del panel
            Window win = SwingUtilities.getWindowAncestor(this);
            win.dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaConsole = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        txtAreaConsole.setEditable(false);
        txtAreaConsole.setColumns(20);
        txtAreaConsole.setRows(5);
        jScrollPane1.setViewportView(txtAreaConsole);

        jLabel1.setText("CONSOLE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(476, 476, 476)
                .addComponent(jLabel1)
                .addContainerGap(459, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(79, 79, 79)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaConsole;
    // End of variables declaration//GEN-END:variables

    @Override
    public synchronized void login(String cf, String password) throws UtenteInesistente, PasswordErrata, MyServerException {
        try {
            ResultSet rs = db.submitQuery("SELECT password FROM utentiregistrati WHERE LOWER(codicefiscale) = LOWER('" + cf + "');");
            dt.checkLogin(rs, password);

        } catch (SQLException ex) {
            throw new MyServerException("LOGIN FAILED - SQL ERROR: " + ex.getSQLState());
        }
    }

    @Override
    public void registrazione(String cf, String nome, String cognome, String citta, int cap, String via, int civico, String email, String password) throws UtenteGiaRegistrato, DatiNonValidi, MyServerException {

        try {
            db.submitQueryUpdate("INSERT INTO utentiregistrati VALUES('" + cf + "','"
                    + nome + "','"
                    + cognome + "','"
                    + citta + "',"
                    + cap + ",'"
                    + via + "',"
                    + civico + ",'"
                    + email + "','"
                    + password + "')");

        } catch (SQLException ex) {

            if (ex.getSQLState().equals("22001")) {
                txtAreaConsole.append("INSERT ERROR - I dati inseriti non sono validi");
                throw new DatiNonValidi("I dati inseriti non sono validi");
            } else if (ex.getSQLState().equals("23505")) {
                txtAreaConsole.append("INSERT ERROR - Duplicato della chiave primaria");
                throw new UtenteGiaRegistrato("Duplicato della chiave primaria");
            } else {
                throw new MyServerException("INSERT ERROR - SQL ERROR: " + ex.getSQLState());
            }
        }

    }

    @Override
    public ArrayList<Canzoni> filtraPerTitolo(String titolo) throws CanzoneInesistente, MyServerException {
        try {
            ResultSet rs = db.submitQuery("SELECT * FROM canzoni WHERE LOWER(titolo) LIKE LOWER('" + titolo + "%')");
            return dt.handleCanzoniSet(rs);
        } catch (SQLException ex) {
            throw new MyServerException("FILTER BY TITLE FAILED - SQL ERROR: " + ex.getSQLState());
        }
    }

    @Override
    public ArrayList<Canzoni> filtraPerAutoreAnno(String autore, int anno) throws CanzoneInesistente, MyServerException {
        try {
            ResultSet rs = db.submitQuery("SELECT * FROM canzoni WHERE LOWER(autore) LIKE LOWER('" + autore + "%') AND anno = " + anno);
            return dt.handleCanzoniSet(rs);
        } catch (SQLException ex) {
            throw new MyServerException("FILTER BY AUTHOR AND YEAR FAILED - SQL ERROR: " + ex.getSQLState());
        }
    }

    @Override
    public Emozioni getEmozioniFromBrano(String titolo, String autore, int anno) throws EmozioniInesistenti {

    }

    @Override
    public ArrayList<Canzoni> getCanzoniForPlaylist() throws MyServerException, CanzoneInesistente {
        try {
            ResultSet rs = db.submitQuery("SELECT * FROM canzoni");
            return dt.handleCanzoniSet(rs);
        } catch (SQLException ex) {
            throw new MyServerException("GET ALL SONGS FAILED - SQL ERROR: " + ex.getSQLState());
        }
    }

    @Override
    public boolean createPlaylist(String nomeplaylist, ArrayList<Canzoni> canzoni, String cf) throws MyServerException {

    }

    @Override
    public ArrayList<Playlist> getPlaylist(String cf) throws PlaylistInesistenti {

    }

    @Override
    public ArrayList<Canzoni> getCanzoniFromPlaylist(String idPlaylist) throws MyServerException {

    }

    @Override
    public boolean inserisciEmozione(String titolo, String autore, int anno, String cf, int amazement, int nostalgia, int calmness, int power, int joy, int tension, int sadness, int tenderness, int solemnity, String amazament_notes, String nostalgia_notes, String calmness_notes, String power_notes, String joy_notes, String tension_notes, String sadness_notes, String tenderness_notes, String solemnity_notes) throws MyServerException {

    }
}

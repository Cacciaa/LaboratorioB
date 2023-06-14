package client;

import common.InterfacciaServizio;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author Alessandro Zancanella, 751494, sede CO
 *
 * Lorenzo Erba, 748702,Ferialdo Elezi 749721,Alessandro Zancanella
 * 751494,Matteo Cacciarino 748231, sede CO
 *
 * Classe rappresentate l'interfaccia con la quale si puo interagire con le
 * playlist per decidere se crearne una nuova o visualizzare quelle presenti nel
 * repository
 *
 */
public class Gui_Playlist extends javax.swing.JPanel {

    //varaibile identificatrice dell'id dell'utente
    private static String idUtente;
    private EmotionalSongs previousframe;
    private InterfacciaServizio is;

    /**
     * Costruttore e inizializatore dell'idUtente
     *
     * @param idUtente - nuemro identificativo dell utente
     * @param emo - riferimento al frame iniziale
     */
    public Gui_Playlist(String idUtente, EmotionalSongs emo, InterfacciaServizio is) {
        //METODO DA RICHIAMARE DOPO IL LOGIN
        initComponents();
        this.idUtente = idUtente;
        this.previousframe = emo;
        this.is=is;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxtNomePlaylist = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jBtnCreaPlaylist = new javax.swing.JButton();
        jBtnVisualizzaPlaylist = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("<html> <h1 style=\"color:green;\"> <u>Playlist Emotional Songs Application</h1> </html>");

        jTxtNomePlaylist.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel2.setText("Inserire il nome della plyalist che si vuole creare:");

        jBtnCreaPlaylist.setText("<html> <h3> Crea Playlist </h3> </html>");
        jBtnCreaPlaylist.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0), 2));
        jBtnCreaPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCreaPlaylistActionPerformed(evt);
            }
        });

        jBtnVisualizzaPlaylist.setText("<html> <h3> Visualizza Playlist </h3> <html>");
        jBtnVisualizzaPlaylist.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0), 2));
        jBtnVisualizzaPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVisualizzaPlaylistActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel3.setText("<html> Selezionare <b>\"Visualizza Playlist\"</b> <br> per visualizzare le proprie playlist.  <html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(193, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTxtNomePlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(104, 104, 104)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jBtnCreaPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBtnVisualizzaPlaylist, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(124, 124, 124))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnCreaPlaylist, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jTxtNomePlaylist))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnVisualizzaPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(183, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Metodo invocato al click del bottone Crea playlist, va a richiamare la
     * nuova interfaccia passando l'idUtente, il nomePlaylist e il costuttore,
     * rendendo visiblile la nuova inerfacca e nascondendo questa
     *
     * @param evt - evento del click del bottone
     *
     */
    private void jBtnCreaPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCreaPlaylistActionPerformed
        // TODO add your handling code here:
        if (this.jTxtNomePlaylist.getText().isBlank() || this.jTxtNomePlaylist.getText().equals(" ")) {
            JOptionPane.showMessageDialog(this, "Inserire il nome della playlist.", "Errore", JOptionPane.ERROR_MESSAGE);
        } else {
            final JDialog frame = new JDialog(this.previousframe, "Gui_CreaPlaylist", true);
            //aggiunta dell'istanza del nuovo JPanel Gui_CreaPlaylist al JDialog.
            frame.getContentPane().add(new Gui_CreaPlaylist(idUtente, jTxtNomePlaylist.getText(), this.previousframe, is));
            //packing del nuovo JPanel
            frame.pack();
            //visualizzazione del nuovo JPanel appena realizzato
            frame.setVisible(true);
            clanJText();
        }

    }//GEN-LAST:event_jBtnCreaPlaylistActionPerformed

    public void clanJText() {
        this.jTxtNomePlaylist.setText("");
    }

    /**
     * Metodo invocato al click del bottone Visualizza playlist, va a richiamare
     * la nuova interfaccia passando l'idUtente e il costuttore, rendendo
     * visiblile la nuova interfacca e nascondendo questa
     *
     *@param evt - evento del click del bottone
     */
    private void jBtnVisualizzaPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVisualizzaPlaylistActionPerformed
        final JDialog frame = new JDialog(this.previousframe, "Gui_VisualizzaPlaylist", true);
        //aggiunta dell'istanza del nuovo JPanel Gui_VisualizzaPlaylist al JDialog.
        frame.getContentPane().add(new Gui_VisualizzaPlaylist(idUtente, this.previousframe, is));
        //packing del nuovo JPanel
        frame.pack();
        //visualizzazione del nuovo JPanel appena realizzato
        frame.setVisible(true);
        clanJText();
    }//GEN-LAST:event_jBtnVisualizzaPlaylistActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCreaPlaylist;
    private javax.swing.JButton jBtnVisualizzaPlaylist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTxtNomePlaylist;
    // End of variables declaration//GEN-END:variables
}

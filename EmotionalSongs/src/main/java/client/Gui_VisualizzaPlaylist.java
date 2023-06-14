package client;

import common.*;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.xml.sax.SAXException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 * @author Alessandro Zancanella, 751494, sede CO
 *
 * Classe rappresentate l'interfaccia con la quale l'utente puo visualizzare le
 * playlist savate e selezionarne una da poter aprire
 *
 * Lorenzo Erba, 748702,Ferialdo Elezi 749721,Alessandro Zancanella
 * 751494,Matteo Cacciarino 748231, sede CO
 */
public class Gui_VisualizzaPlaylist extends javax.swing.JPanel {

    private String userId;
    private EmotionalSongs previousframe;
    private ArrayList<Playlist> listaPlaylist;
    private InterfacciaServizio is;

    /**
     * Create the frame.
     *
     * @param userId - codice identificativo utente
     * @param emo - riferimento al frame iniziale
     */
    public Gui_VisualizzaPlaylist(String userId, EmotionalSongs emo, InterfacciaServizio is) {
        this.userId = userId;
        this.previousframe = emo;
        this.is=is;
        listaPlaylist = new ArrayList<Playlist>();
        initComponents();

        try {
            listaPlaylist = is.getPlaylist(userId);
        }catch(PlaylistInesistenti | MyServerException | RemoteException ex){
            JOptionPane.showMessageDialog(this, "Errore #A1023. Errore durante la lettura del file playlist", "Errore", JOptionPane.ERROR_MESSAGE);
        } 
        
            DefaultListModel modelloLista = new DefaultListModel<>();
            this.jLstPlaylist.setModel(modelloLista);
            for (Playlist p : listaPlaylist) {
                modelloLista.addElement(p.getNomeplaylist());
                System.out.println(p.getNomeplaylist());
            }
            this.jLblUserId.setText(this.jLblUserId.getText() + userId);
        
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
        jLabel2 = new javax.swing.JLabel();
        jBtnApriPlaylist = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLstPlaylist = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLblUserId = new javax.swing.JLabel();

        jLabel1.setText("<html> <h1 style=\"color:green;\"> <u>Le mie playlist</h1> </html>");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel2.setText("Selezionare una playlist dall'elenco sottostante per poter visualizzare i brani.");

        jBtnApriPlaylist.setText("<html> <h3> Apri playlist selezionata");
        jBtnApriPlaylist.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0), 2));
        jBtnApriPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnApriPlaylistActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jLstPlaylist);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel3.setText("Playlist:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(jBtnApriPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblUserId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(323, 323, 323))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblUserId))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(jBtnApriPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(222, 222, 222))))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo invocato al click del bottone di conferma selezione della
     * playlist. passando l'oggetto playlist
     *
     * @param evt evento del click del bottone
     */
    private void jBtnApriPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnApriPlaylistActionPerformed
        // TODO add your handling code here:
        if (this.jLstPlaylist.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Selezionare una playlist.", "Errore.", JOptionPane.ERROR_MESSAGE);
        } else {
            String select = (String) this.jLstPlaylist.getSelectedValue();
            for (Playlist p : listaPlaylist) {
                if (p.getNomeplaylist().equals(select)) {
                    //oggetto di tipo JDialog contenente il riferimento al nuovo JPanel, repositoryChoice_GUi
                    final JDialog frame = new JDialog(this.previousframe, "Gui_ElencoBrani", true);
                    //aggiunta dell'istanza del nuovo JPanel repositoryChoice_Gui al JDialog.
                    frame.getContentPane().add(new Gui_ElencoBrani(this.userId,p,this.previousframe, is));
                    //packing del nuovo JPanel
                    frame.pack();
                    //visualizzazione del nuovo JPanel appena realizzato
                    frame.setVisible(true);
                }
            }
        }

    }//GEN-LAST:event_jBtnApriPlaylistActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnApriPlaylist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLblUserId;
    private javax.swing.JList<String> jLstPlaylist;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

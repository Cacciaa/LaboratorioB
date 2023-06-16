package client;

import common.*;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Ferialdo Elezi, 749721
 *
 * Lorenzo Erba, 748702,Ferialdo Elezi 749721,Alessandro Zancanella
 * 751494,Matteo Cacciarino 748231, sede CO
 *
 */
public class GUI_login extends javax.swing.JFrame {

    
    private EmotionalSongs previousframe;
    
    private InterfacciaServizio is;

    /**
     * Metodo costruttore che crea la nuova interfaccia GUI_login, inizializzando le variabili
     *
     * @param emo contenente il riferimento al frame precedente
     * @param is contenente il riferimento all'oggetto contentente i servizi del server
     *
     */
    public GUI_login(EmotionalSongs emo, InterfacciaServizio is) {
        initComponents();
        this.previousframe = emo;
        this.is=is;        
    }

    private GUI_login() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtUserId = new javax.swing.JTextPane();
        txtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        Login.setText("<html> <h2>Accedi");
        Login.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0), 2));
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        jLabel1.setText("<html> <h2>UserId");

        jLabel2.setText("<html> <h2>Password");

        jScrollPane1.setViewportView(txtUserId);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 51));
        jLabel3.setText("<html> <h1 style=\"color:green;\"><u>Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(63, 63, 63)
                        .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Metodo invocato al click del bottone "Login". Tale metodo verifica se
     * l'userId e la password esistono e combaciano nel database attraverso il metodo messo a disposizione dal server
     * Se corretti aprirà il nuovo JPanel Gui_Playlist
     */
    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        
        //assegno alla variabile user il contenuto della textbox dove l'utente inserirà il suo UserId/codice fiscale
        String codFisc = txtUserId.getText();
        //assegno alla variabile password il contenuto della textbox dove l'utente inserirà la sua password
        String password = txtPassword.getText();
        UtentiRegistrati utente;
        boolean check=false;
        
        try{    
            //metodo che effettua il login 
            utente =is.login(codFisc, password);
            check = true;
        }catch (UtenteInesistente ex) {  
            JOptionPane.showMessageDialog(null, "Utente non registrato", "Errore", JOptionPane.ERROR_MESSAGE);
        } catch (PasswordErrata ex) {
            JOptionPane.showMessageDialog(null, "Password errata", "Errore", JOptionPane.ERROR_MESSAGE);
        } catch (MyServerException | RemoteException ex) {
            Logger.getLogger(GUI_login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //dopo aver verificato che il login sia andato a buon termine, invoco il JPanel successivo
        if(check){
            JOptionPane.showMessageDialog(null, "Benvenuto: " + codFisc, "Info", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            final JDialog frame = new JDialog(this, "Gui_Playlist", true);
            //aggiunta dell'istanza del nuovo JPanel Gui_Playlist al JDialog.
            frame.getContentPane().add(new Gui_Playlist(codFisc,previousframe,is));
            //packing del nuovo JPanel
            frame.pack();
            //visualizzazione del nuovo JPanel appena realizzato
            frame.setVisible(true);
        }

    }//GEN-LAST:event_LoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextPane txtUserId;
    // End of variables declaration//GEN-END:variables
}

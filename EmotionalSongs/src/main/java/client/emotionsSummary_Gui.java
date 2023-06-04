/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package client;

import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Lorenzo Erba, 748702
 *
 * Lorenzo Erba, 748702,Ferialdo Elezi 749721,Alessandro Zancanella
 * 751494,Matteo Cacciarino 748231, sede CO
 *
 * Classe rappresentante il panel che mostra le emozioni della canzone
 * selezionatatory".
 */
public class emotionsSummary_Gui extends javax.swing.JPanel {

    //attributo costante di tipo String contenente il percorso relativo del file contenente le emozioni
    private final String PATH_FILE_EMOZIONI;
    //attributo costante di tipo String contenente il nome del file contenente le emozioni
    private final String FILE_EMOZIONI;
    //attributo costante di tipo String contenente il nome del file contenente le emozioni
    private final String PATH_XSD_EMOZIONI;
    //attributo di tipo Emozioni_Canzone rappresentante la lista delle emozioni relative alla canzone specificata
    private Emozioni_Canzone emo_canzone;
    //attributo di tipo Canzone contenente le informazioni delle canzone selezionata
    private Canzone canzone;
    //attributo costante di tipo EmotionalSongs contenente il riferimento al frame iniziale
    private final EmotionalSongs previousframe;

    /**
     * Costruttore parametrico che inizializza tutti gli attributi
     *
     * @param pathfilemozioni variabile di tipo String contenente il percorso
     * del file contenente le emozioni
     * @param nomefilemozioni variabile di tipo String contenente il nome del
     * file contenente le emozioni
     * @param pathxsdemozioni variabile di tipo String contenente il percorso
     * del file xsd contenente le emozioni
     * @param canzone variabile di tipo Canzone contenenete la canzone
     * selezionata dalla quale prelevare le emozioni
     * @param previousframe variabile di tipo EmotionalSongs contenente il
     * riferimento al frame iniziale
     */
    public emotionsSummary_Gui(String pathfilemozioni, String nomefilemozioni, String pathxsdemozioni, Canzone canzone, EmotionalSongs previousframe) {
        initComponents();
        this.PATH_FILE_EMOZIONI = pathfilemozioni;
        this.FILE_EMOZIONI = nomefilemozioni;
        this.PATH_XSD_EMOZIONI = pathxsdemozioni;
        this.canzone = canzone;
        this.previousframe = previousframe;

    }

    /**
     * Metodo che permette di prelevare le emozioni relative al brano indicato
     *
     * @return boolean true --> la tabella è stata riempita correttamente
     * @return boolean false --> errore. implica la visualizzazione di una
     * JOptionPane contenente il codice d'errore
     */
    public boolean visualizzaEmozioneBrano() {
        try {
            //oggetto di tipo OperazioniXML che permette il parsing del file indicato
            OperazioniXML op = new OperazioniXML(PATH_FILE_EMOZIONI, FILE_EMOZIONI, PATH_XSD_EMOZIONI);
            //parsing del file contenente le emoozioni
            Object objresult = op.parseDocumentEmozioni("brano", canzone);
            //controllo se il risultato ottenuto è istanceof di Emozioni_Canzone, implica che il parsing è andato a buon fine
            if (objresult instanceof Emozioni_Canzone) {
                //controllo se il riempimento della tabella delle emozioni ha prodotto esito positivo
                if (this.riempiTabella((Emozioni_Canzone) objresult, jTblEmo).equals("1")) {

                    return true;
                } else {
                    return false;
                }

            } else {
                //stampa della JOptionPane contenente l'errore che si è verificato
                JOptionPane.showMessageDialog(null, objresult, "Errore", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            //catch dell'eccezione in fase dell'inizializzazione della tabella
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Errore #A1016. Errore durante l'inizializzazione della pagina emotionsSummary_Gui", "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Metodo che permette di inserire le emozioni lette dal file nella tabella
     *
     * @param emo_canzone oggetto di tipo Emozioni_Canzone contenente la lista
     * delle emozioni rilasciate da ogni utente
     * @param tabella oggetto di tipo JTable contenente il riferimento alla
     * tabella presente nella pagina
     * @return Oggetto di tipo String --> "1" il riempimento è andato a buon
     * fine
     * @return Oggetto di tipo String --> contenente l'errore generato in fase
     * di popolamento della tabella
     */
    private Object riempiTabella(Emozioni_Canzone emo_canzone, JTable tabella) {
        try {
            //model della tabella
            DefaultTableModel df = (DefaultTableModel) tabella.getModel();
            //setting dell'attributo emo_canzone
            this.emo_canzone = emo_canzone;
            //for per il riempimento di ogni riga della tabella
            for (int i = 0; i < emo_canzone.getNumEl(); i++) {
                //settings della riga della tabella con le emozioni di ogni utente
                df.addRow(emo_canzone.getEmoCanzonePunteggiToArray(i));
            }
            //setting delle medie delle emozioni
            this.setMedieTabella(tabella);
            Object obj = "1";
            return obj;
            //catch dell'eccezione in fase di popolamento della tabella
        } catch (Exception e) {
            Object obj = "Errore #A1003. Errore durante il popolamento della tabella.";
            return obj;
        }

    }

    /**
     * Metodo che permette di settare le colonne delle emozioni con le medie
     * relative
     *
     * @param tabella oggetto di tipo JTable contenente il riferimento alla
     * tabella presente nella pagina
     * @return boolean true -> settings della tabella avvenuto con esito
     * positivo
     * @return boolean false -> settings della tabella ha prodotto un errore
     */
    private boolean setMedieTabella(JTable tabella) {
        int avrg = -1;
        try {
            //model delle colonne della tabella
            TableColumnModel df = (TableColumnModel) tabella.getColumnModel();
            //for per l'aggiornamento delle colonne della tabella con le medie di ogni emozioni
            for (int i = 1; i < df.getColumnCount(); i++) {
                //ottengo la media di ogni emozione specificata all'indice indicato
                avrg = this.emo_canzone.getMediaAtIndex(i);
                //nel caso in cui ottengo -1, errore durante l'invocazione del get delle medie
                if (avrg == -1) {
                    return false;
                } else {
                    //setting della colonna i-esima col valore della media ottenuta
                    df.getColumn(i).setHeaderValue(tabella.getColumnName(i) + "(" + avrg + ")");
                }

            }
            return true;
            //catch dell'eccezione in fase di popolamento delle colonne della tabella
        } catch (Exception e) {
            return false;
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblEmo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("<html> <h1 style=\"color:green;\"><u>Prospetto delle emozioni del brano</u></h1>");

        jTblEmo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTblEmo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "<html> <h3> Utente</h4>", "<html> <h3>Amazement", "<html> <h3>Solemnity", "<html> <h3>Tenderness", "<html> <h3>Nostalgia", "<html> <h3>Calmness", "<html> <h3>Power", "<html> <h3>Joy", "<html> <h3>Tension", "<html> <h3>Sadness"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblEmo.setSelectionBackground(new java.awt.Color(116, 153, 221));
        jTblEmo.getTableHeader().setReorderingAllowed(false);
        jTblEmo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblEmoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblEmo);
        if (jTblEmo.getColumnModel().getColumnCount() > 0) {
            jTblEmo.getColumnModel().getColumn(0).setResizable(false);
            jTblEmo.getColumnModel().getColumn(1).setResizable(false);
            jTblEmo.getColumnModel().getColumn(2).setResizable(false);
            jTblEmo.getColumnModel().getColumn(3).setResizable(false);
            jTblEmo.getColumnModel().getColumn(3).setPreferredWidth(85);
            jTblEmo.getColumnModel().getColumn(4).setResizable(false);
            jTblEmo.getColumnModel().getColumn(5).setResizable(false);
            jTblEmo.getColumnModel().getColumn(6).setResizable(false);
            jTblEmo.getColumnModel().getColumn(7).setResizable(false);
            jTblEmo.getColumnModel().getColumn(8).setResizable(false);
            jTblEmo.getColumnModel().getColumn(9).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel2.setText("<html> Di seguito vengono riportate le emozioni, di ogni utente, associate al brano: <br> In ogni colonna <b>tra parentesi tonde</b> viene riportata la <b>media</b> di ogni emozione. <br>Selezionare una riga per visualizzare i <b>commenti</b> rilasciati dal relativo utente.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(348, 348, 348))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 553, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo invocato al click della riga della tabella. Tale
     * metodo apre il JPanel notes_Gui, contenente i commenti dell'utente selezionato.
     *
     * @param evt evento rappresentante il click della riga della tabella jTblEmo
     */
    private void jTblEmoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblEmoMouseClicked
        //ottengo l'indice della riga selezionata dalla tabella jTblEmo
        int selectedRowIndex = this.jTblEmo.getSelectedRow();
        //oggetto di tipo JDialog contenente il riferimento al nuovo JPanel, notes_Gui
        JDialog frame = new JDialog(this.previousframe, "notes_Gui", true);
        //aggiunta dell'istanza del nuovo JPanel notes_Gui al JDialog.
        frame.getContentPane().add(new notes_Gui(this.emo_canzone, selectedRowIndex));
        //packing del nuovo JPanel
        frame.pack();
        //visualizzazione del nuovo JPanel appena realizzato
        frame.setVisible(true);
    }//GEN-LAST:event_jTblEmoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblEmo;
    // End of variables declaration//GEN-END:variables
}

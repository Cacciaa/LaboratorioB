/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package client;

import common.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Lorenzo Erba, 748702
 *
 * Lorenzo Erba, 748702,Ferialdo Elezi 749721,Alessandro Zancanella
 * 751494,Matteo Cacciarino 748231, sede CO
 *
 * Classe rappresentante il jPanel che permette di filtrare il repository in
 * base al titolo del brano, oppure in base ad Autore e Anno.
 */
public class repositoryChoice_Gui extends javax.swing.JPanel {

   
    //attributo di tipo EmotionalSongs contenente il riferimento al frame iniziale
    private EmotionalSongs previousframe;
    private InterfacciaServizio is;

    /**
     * Costruttore parametrico che inizializza tutti gli attributi
     * 
     * @param emo variabile di tipo EmotionalSongs contenente il riferimento al
     * frame iniziale
     */
    public repositoryChoice_Gui(EmotionalSongs emo, InterfacciaServizio is) {
        initComponents();
        this.previousframe = emo;
        this.is=is;        
    }

    /**
     * Metodo che permette di leggere le canzoni dal file filtrandole in base al
     * titolo. Il metodo verifica se il titolo inserito come filtro coincide col
     * titolo di una canzone oppure restituisce le canzoni il cui titolo inizia con i
     * caratteri inseriti.
     *
     * @param titolo , variabile di tipo String contente il titolo inserito
     * dall'utente per effettuare il filtraggio delle canzoni
     * @return String "1" --> esito positivo. La lettura non ha causato
     * eccezzioni
     * @return String "Errore #A1001" --> errore, il file indicato non è un
     * file.
     * @return String "Errore #A1002" --> errore, si è verificata un errore in
     * fase di lettura.
     */
    private Object cercaBranoMusicale(String titolo) {
        //Oggetto di tipo File che rappresenta il file canzoni.xml
        try {
            //parsing del documento contenente il repository
            ArrayList<Canzoni> canzoni = is.filtraPerTitolo(titolo);
            return riempiTabella( canzoni, this.jTableAA);
            
        } catch (CanzoneInesistente ex) {
            JOptionPane.showMessageDialog(null, "Canzone inesistente", "Errore", JOptionPane.WARNING_MESSAGE);
        }  catch (RemoteException |MyServerException ex) {
            JOptionPane.showMessageDialog(null, "Errore", "Errore", JOptionPane.WARNING_MESSAGE);
        }
        
        return null;
    }

    /**
     * Metodo che permette di filtrare le canzoni presenti nel database tramite l'anno e l'autore
     * indicati
     *
     * @param anno variabile di tipo String contenente l'anno usato come filtro
     * @param autore variabile di tipo String contenente l'autore usato come
     * filtro
     * @return oggetto di tipo Object instanceof Repository -> lista delle
     * canzoni filtrate
     * @return oggetto di tipo Object instanceof String -> errore
     */
    private Object cercaBranoMusicale(String anno, String autore) {
        try {
            //parsing del file contenente il repository
            ArrayList<Canzoni> canzoni = is.filtraPerAutoreAnno(autore, Integer.valueOf(anno));
            return riempiTabella( canzoni, this.jTableAA);
            
        } catch (CanzoneInesistente ex) {
            JOptionPane.showMessageDialog(null, "Canzone inesistente", "Errore", JOptionPane.WARNING_MESSAGE);
        }  catch (RemoteException |MyServerException ex) {
            JOptionPane.showMessageDialog(null, "Errore", "Errore", JOptionPane.WARNING_MESSAGE);
        }
        
        return null;

    }

    /**
     * Metodo che permette di inserire nella tabella le canzoni filtrate. Nel
     * caso in cui non è stata trovata nessuna canzone viene visualizzato un
     * messaggio di informazione e la tabella risulta in tal caso vuoto.
     *
     * @return String "1" --> esito positivo. L'inserimento dei dati nella
     * tabella non ha causato eccezzioni
     * @return String "Errore #A1003" --> errore, l'inserimento dei dati in
     * tabella ha causato un'eccezione.
     */
    private Object riempiTabella(ArrayList<Canzoni> canzoni, JTable tabella) {
        try {
            //model della tabella
            DefaultTableModel df = (DefaultTableModel) tabella.getModel();
            
            Vector<String> vector = new Vector<>();
            df.setRowCount(0); //reset tabella
            
            //for per il riempimento di ogni riga della tabella
            for (int i = 0; i < canzoni.size(); i++) {
                vector = transform(i, canzoni);
                if (vector.get(0).equals("Errore #B0001.indexNonValido")) {
                    JOptionPane.showMessageDialog(null, vector.get(0), "Errore", JOptionPane.ERROR_MESSAGE);
                    break;
                } else {
                // Aggiungo la riga
                df.addRow(vector);
                }
            }
            
            Object obj =  "1";
            return obj;
          //catch dell'eccezione in fase di popolamento della tabella 
        } catch (Exception e) {
            Object obj =  "Errore #A1003. Errore durante il popolamento della tabella.";
            return obj;
        }

    }
    
    /**
     * Metodo che trasforma i brani in un Vector per poterli inserire in una
     * jTable
     *
     * @param index parametro di tipo int contenente l'indice corrente
     * @param brani ArrayList di tipo Canzone, che è da convertire
     */
    private Vector<String> transform(int index, ArrayList<Canzoni> brani) {
        Vector<String> vector = new Vector<>();
        if (index < brani.size()) {
            // Aggiungo le varie informazioni del brano
            vector.add(brani.get(index).getTitolo());
            vector.add(brani.get(index).getAutore());
            vector.add(String.valueOf(brani.get(index).getAnno()));
            return vector;
        } else {
            vector.add("Errore #B0001.indexNonValido"); // Errore 
            return vector;
        }
    }

    /**
     * Metodo che permette di azzerare il numero di righe della tabella indicata
     * @param table oggetto di tipo JTable contenente il riferimento alla tabella
     */
    private void azzeraRigheTabella(JTable table) {
        //model della tabella
        DefaultTableModel df = (DefaultTableModel) table.getModel();
        //setting del numero di righe a 0
        df.setRowCount(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBtnFiltraTitolo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableT = new javax.swing.JTable();
        jTxtTitolo = new javax.swing.JTextField();
        jBtnCancella1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxtAutore = new javax.swing.JTextField();
        jTxtAnno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAA = new javax.swing.JTable();
        jBtnFiltraAutoreAnno = new javax.swing.JToggleButton();
        jBtnCancella2 = new javax.swing.JButton();

        jLabel1.setText("<html> <h1>Titolo</h2> </html>");

        jBtnFiltraTitolo.setText("<html> <h3> Filtra </h3> </html>");
        jBtnFiltraTitolo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), new java.awt.Color(0, 204, 204)));
        jBtnFiltraTitolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFiltraTitoloActionPerformed(evt);
            }
        });

        jTableT.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTableT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "<html> <h3> Titolo</h3> </html>", "<html> <h3> Autore</h3> </html>", "<html> <h3> Anno</h3> </html>"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableT.setSelectionBackground(new java.awt.Color(116, 153, 221));
        jTableT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableT);
        if (jTableT.getColumnModel().getColumnCount() > 0) {
            jTableT.getColumnModel().getColumn(0).setResizable(false);
            jTableT.getColumnModel().getColumn(1).setResizable(false);
            jTableT.getColumnModel().getColumn(2).setResizable(false);
        }

        jTxtTitolo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jBtnCancella1.setText("<html> <h3> Cancella</h3>");
        jBtnCancella1.setToolTipText("");
        jBtnCancella1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 0, 0), new java.awt.Color(153, 0, 0)));
        jBtnCancella1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancella1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTxtTitolo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBtnFiltraTitolo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jBtnCancella1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 266, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(345, 345, 345))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtTitolo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnFiltraTitolo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCancella1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201))
        );

        jLabel1.getAccessibleContext().setAccessibleName("<html>\n<center>Titolo</center>");

        jTabbedPane1.addTab("<html> <h3> <u> Filtra per brano</u> </h3>", jPanel1);

        jLabel2.setText("<html> <h1> Autore </h1> </html>");

        jLabel3.setText("<html> <h1> Anno </h1> </html>");

        jTxtAutore.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jTxtAnno.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jTableAA.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTableAA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "<html> <h3> Titolo</h3>", "<html> <h3> Autore </h3> </html>", "<html> <h3>Anno</h3></html>"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAA.setSelectionBackground(new java.awt.Color(116, 153, 221));
        jTableAA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAA);
        if (jTableAA.getColumnModel().getColumnCount() > 0) {
            jTableAA.getColumnModel().getColumn(0).setResizable(false);
            jTableAA.getColumnModel().getColumn(1).setResizable(false);
            jTableAA.getColumnModel().getColumn(2).setResizable(false);
        }

        jBtnFiltraAutoreAnno.setText("<html> <h3> Filtra </h3> </html>");
        jBtnFiltraAutoreAnno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 204, 204), new java.awt.Color(0, 204, 204)));
        jBtnFiltraAutoreAnno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFiltraAutoreAnnoActionPerformed(evt);
            }
        });

        jBtnCancella2.setText("<html> <h3> Cancella </h3>");
        jBtnCancella2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 0, 0), new java.awt.Color(153, 0, 0)));
        jBtnCancella2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancella2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jTxtAutore, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTxtAnno, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jBtnFiltraAutoreAnno, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnCancella2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTxtAnno)
                    .addComponent(jTxtAutore, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCancella2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnFiltraAutoreAnno, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("<html> <h3> <u>Filtra per autore e anno</u></h3>", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Metodo invocato al click del bottone FiltraTitolo. Tale
     * metodo permette di leggere le canzoni dal databse e filtrare le canzoni tramite il titolo inserito
     *
     * @param evt evento rappresentante il click del bottone FiltraTitolo
     */
    private void jBtnFiltraTitoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFiltraTitoloActionPerformed
        //controllo se l'utente ha inserito un titolo da utilizzare come filtro
        if (!jTxtTitolo.getText().equals("")) {
            //azzero le righe della tabella
            azzeraRigheTabella(jTableT);
            //invoco il metodo che permette di cercare il brano filtrandolo per il titolo
            Object objresult = cercaBranoMusicale(jTxtTitolo.getText());
            //controllo se il risultato è instanceof String --> implica che il parsing ha prodotto errori
            if(objresult.equals(null)){
                    JOptionPane.showMessageDialog(null, objresult, "Errore", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Inserire un titolo all'interno della barra di ricerca.", "Info", 1);
        }
    }//GEN-LAST:event_jBtnFiltraTitoloActionPerformed
    
    /**
     * Metodo invocato al click del bottone FiltraAutoreAnno. Tale
     * metodo permette di leggere le canzoni dal databse e filtrare le canzoni tramite anno e autore inseriti
     *
     * @param evt evento rappresentante il click del bottone FiltraAutoreAnno
     */
    private void jBtnFiltraAutoreAnnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFiltraAutoreAnnoActionPerformed
       //controllo se l'utente ha inserito un anno e autore da utilizzare come filtro
        if (!jTxtAnno.getText().equals("") && !jTxtAutore.getText().equals("")) {
            //azzero le righe della tabella
            azzeraRigheTabella(jTableAA);
            //invoco il metodo che permette di cercare il brano filtrandolo per anno e autore
            Object objresult = cercaBranoMusicale(jTxtAnno.getText(), jTxtAutore.getText());
            //controllo se il risultato è instanceof String --> implica che il parsing ha prodotto errori
            if(objresult.equals(null)){
                    JOptionPane.showMessageDialog(null, objresult, "Errore", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Inserire autore e anno all'interno della barra di ricerca.", "Info", 1);
        }
    }//GEN-LAST:event_jBtnFiltraAutoreAnnoActionPerformed
    
    /**
     * Metodo invocato al click del bottone Cancella. Tale
     * metodo permette di cancellare le righe della tabella e della barra contenente il titolo nella pagina filtra per titolo
     *
     * @param evt evento rappresentante il click del bottone Cancella
     */
    private void jBtnCancella1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancella1ActionPerformed
        // TODO add your handling code here:
        this.azzeraRigheTabella(jTableT);
        this.jTxtTitolo.setText("");
    }//GEN-LAST:event_jBtnCancella1ActionPerformed
    
    /**
     * Metodo invocato al click del bottone Cancella. Tale
     * metodo permette di cancellare le righe della tabella e della barra contenente anno e autore nella pagina filtra per anno e autore
     *
     * @param evt evento rappresentante il click del bottone Cancella
     */
    private void jBtnCancella2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancella2ActionPerformed
        // TODO add your handling code here:
        this.azzeraRigheTabella(jTableAA);
        this.jTxtAutore.setText("");
        this.jTxtAnno.setText("");
    }//GEN-LAST:event_jBtnCancella2ActionPerformed
    
    /**
     * Metodo invocato al click della riga della tabella contenente i risultati ottenuti tramite il filtro del titolo. Tale
     * metodo permette di  aprire il JPanel emotionsSummary_Gui contenente le emozioni rilasciate dagli utenti relative alla canzone selezionata
     *
     * @param evt evento rappresentante il click della riga della tabella
     */
    private void jTableTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTMouseClicked
        //oggetto di tipo Canzone contenente le informazioni della canzone selezionata
        Canzoni canzone;
        String titolo = (String) jTableT.getValueAt(jTableT.getSelectedRow(), 0);
        String autore = (String) jTableT.getValueAt(jTableT.getSelectedRow(), 1);
        String anno = (String) jTableT.getValueAt(jTableT.getSelectedRow(), 2);
        
        canzone = new Canzoni(titolo, autore, Integer.valueOf(anno));
        //oggetto di tipo JDialog contenente il riferimento al nuovo JPanel, emotionsSummary_Gui
        JDialog frame = new JDialog(this.previousframe, "emotionsSummary_Gui", true);
        
        emotionsSummary_Gui emogui = new emotionsSummary_Gui(canzone, this.previousframe, is);
        
        //invoco la visualizzazione delle emozioni del brano nel nuovo JPanel
        if (emogui.visualizzaEmozioneBrano()) {
            //aggiunta dell'istanza del nuovo JPanel emotionsSummary_Gui al JDialog.
            frame.getContentPane().add(emogui);
            //packing del nuovo JPanel
            frame.pack();
            //visualizzazione del nuovo JPanel appena realizzato
            frame.setVisible(true);
        }

    }//GEN-LAST:event_jTableTMouseClicked
    
    /**
     * Metodo invocato al click della riga della tabella contenente i risultati ottenuti tramite il filtro dell'autore e dell'anno. Tale
     * metodo permette di  aprire il JPanel emotionsSummary_Gui contenente le emozioni rilasciate dagli utenti relative alla canzone selezionata
     *
     * @param evt evento rappresentante il click della riga della tabella
     */
    private void jTableAAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAAMouseClicked
        //oggetto di tipo Canzone contenente le informazioni della canzone selezionata
        Canzoni canzone;
        String titolo = (String) jTableAA.getValueAt(jTableAA.getSelectedRow(), 0);
        String autore = (String) jTableAA.getValueAt(jTableAA.getSelectedRow(), 1);
        String anno = (String) jTableAA.getValueAt(jTableAA.getSelectedRow(), 2);

        canzone = new Canzoni(titolo, autore, Integer.valueOf(anno));
        //oggetto di tipo JDialog contenente il riferimento al nuovo JPanel, emotionsSummary_Gui
        JDialog frame = new JDialog(this.previousframe, "emotionsSummary_Gui", true);
        emotionsSummary_Gui emogui = new emotionsSummary_Gui( canzone, this.previousframe, is);
        
        //invoco la visualizzazione delle emozioni del brano nel nuovo JPanel
        if (emogui.visualizzaEmozioneBrano()) {
            //aggiunta dell'istanza del nuovo JPanel emotionsSummary_Gui al JDialog.
            frame.getContentPane().add(emogui);
            //packing del nuovo JPanel
            frame.pack();
            //visualizzazione del nuovo JPanel appena realizzato
            frame.setVisible(true);
        }

    }//GEN-LAST:event_jTableAAMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancella1;
    private javax.swing.JButton jBtnCancella2;
    private javax.swing.JToggleButton jBtnFiltraAutoreAnno;
    private javax.swing.JButton jBtnFiltraTitolo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableAA;
    private javax.swing.JTable jTableT;
    private javax.swing.JTextField jTxtAnno;
    private javax.swing.JTextField jTxtAutore;
    private javax.swing.JTextField jTxtTitolo;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgVue;

import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import pkgEntite.Etablissement;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pkgEntite.HibernateUtil;

/**
 *
 * @author Kevin
 */
public class JPanelEtabListe extends javax.swing.JPanel {

    /**
     * Creates new form JPanelListEtab
     */
    public JPanelEtabListe() {
        initComponents();
        
    }
    
    public void listeEtablissements(){
 
        viderTableau();
        
        String sQuery = "FROM Etablissement";
        Query qm = JFrameFestival.getSession().createQuery(sQuery);
        Iterator etab= qm.iterate();
        while (etab.hasNext()){
            Etablissement unEtablissement2 = (Etablissement) etab.next();
            //System.out.println(unEtablissement2.getEtaId());
            ((DefaultTableModel) jTableEtab.getModel()).addRow(new Object[]
            {unEtablissement2.getEtaId(), unEtablissement2.getEtaNom(), unEtablissement2.getEtaVille(),unEtablissement2.getEtaTel()});
           }
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEtab = new javax.swing.JTable();
        jLblTitre1 = new javax.swing.JLabel();
        jLblTitre2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAdresse = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtVille = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbCivil = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtNomResp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPrenomResp = new javax.swing.JTextField();
        jBtnModifier = new javax.swing.JButton();
        jBtnSupprimer = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 800));

        jTableEtab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Etablissements", "Ville", "Telephone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEtab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEtabMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableEtab);
        jTableEtab.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTableEtab.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTableEtab.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTableEtab.getColumnModel().getColumn(3).setPreferredWidth(200);

        jLblTitre1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLblTitre1.setText("Litste d'établissements");

        jLblTitre2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLblTitre2.setText("Informations");

        jLabel1.setText("ID");

        jLabel2.setText("Nom");

        jLabel4.setText("Adresse");

        jLabel5.setText("Code Postale");

        jLabel3.setText("Ville");

        jLabel6.setText("Téléphone");

        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Responsable");

        cbCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCivilActionPerformed(evt);
            }
        });

        jLabel8.setText("Nom");

        jLabel9.setText("Prenom");

        jBtnModifier.setText("Modifier");
        jBtnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModifierActionPerformed(evt);
            }
        });

        jBtnSupprimer.setText("Supprimer");
        jBtnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLblTitre1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLblTitre2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtCP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdresse, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNom, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVille, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addComponent(lblID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(36, 36, 36)
                                .addComponent(txtNomResp, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrenomResp, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(175, 175, 175))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(cbCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel7)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBtnModifier)
                .addGap(36, 36, 36)
                .addComponent(jBtnSupprimer)
                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLblTitre1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLblTitre2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtNomResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtPrenomResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnModifier)
                            .addComponent(jBtnSupprimer))
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addContainerGap(15, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelActionPerformed

    private void cbCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCivilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCivilActionPerformed

    private void jBtnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModifierActionPerformed
        // TODO add your handling code here:
        byte varTemp = 0;

        String sReq = "FROM Etablissement where ETA_ID  = ?";
        Query q = JFrameFestival.getSession().createQuery(sReq);
        q.setParameter(0, lblID.getText());

        Etablissement unEtablissement = (Etablissement)q.uniqueResult();
        Object idEtab = lblID.getText();
        
        if (unEtablissement!=null){
            unEtablissement.setEtaNom(txtNom.getText());
            unEtablissement.setEtaRue(txtAdresse.getText());
            unEtablissement.setEtaCp(txtCP.getText());
            unEtablissement.setEtaVille(txtVille.getText());
            unEtablissement.setEtaTel(txtTel.getText());
            unEtablissement.setEtaCivilresp(cbCivil.getSelectedItem().toString());
            unEtablissement.setEtaNomresp(txtNomResp.getText());
            unEtablissement.setEtaPrenomresp(txtPrenomResp.getText());
            Transaction tx = JFrameFestival.getSession().beginTransaction();
            JFrameFestival.getSession().update(unEtablissement);
            tx.commit();

            JOptionPane.showMessageDialog(null, "Etablissement modifié avec succés");
        }
        
        viderChamps();

        chargerChamps(idEtab);
    }//GEN-LAST:event_jBtnModifierActionPerformed

    private void chargerChamps(Object objet){
        
        JFrameFestival.getSession().beginTransaction();
        String sReq = "FROM Etablissement where ETA_ID = ?";
        Query q = JFrameFestival.getSession().createQuery(sReq);
        q.setParameter(0, objet.toString());

        Etablissement unEtablissement = (Etablissement)q.uniqueResult();
        
        cbCivil.removeAllItems();
        //permet de remplir la combobox selon la civilité du responsable de l'établissement
        switch (unEtablissement.getEtaCivilresp()) {
            case "Monsieur":
                cbCivil.addItem(unEtablissement.getEtaCivilresp());
                cbCivil.addItem("Madame");
                cbCivil.addItem("Mademoiselle");
                break;
            case "Madame":
                cbCivil.addItem(unEtablissement.getEtaCivilresp());
                cbCivil.addItem("Mademoiselle");
                cbCivil.addItem("Monsieur");
                break;
            case "Mademoiselle":
                cbCivil.addItem(unEtablissement.getEtaCivilresp());
                cbCivil.addItem("Madame");
                cbCivil.addItem("Monsieur");
                break;
            default:
                cbCivil.addItem("Mademoiselle");
                cbCivil.addItem("Madame");
                cbCivil.addItem("Monsieur");
                break;
        }
        
        //remplit les champs selon l'établissement séléctionné dans le tableau
        lblID.setText(unEtablissement.getEtaId());
        txtNom.setText(unEtablissement.getEtaNom());
        txtAdresse.setText(unEtablissement.getEtaRue());
        txtCP.setText(unEtablissement.getEtaCp());
        txtVille.setText(unEtablissement.getEtaVille());
        txtTel.setText(unEtablissement.getEtaTel());
        txtNomResp.setText(unEtablissement.getEtaNomresp());
        txtPrenomResp.setText(unEtablissement.getEtaPrenomresp());
    }
    private void jTableEtabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEtabMouseClicked
        // TODO add your handling code here:
        //lorsqu'on clique sur une des lignes du tableau, ça charge les champs
        int ligne = jTableEtab.getSelectedRow();
        Object idEtab = jTableEtab.getValueAt(ligne, 0);
        chargerChamps(idEtab);
    }//GEN-LAST:event_jTableEtabMouseClicked

    private void jBtnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSupprimerActionPerformed
        // TODO add your handling code here:
        byte varTemp = 0;

        String sReq = "from Etablissement where id = ?";
        Query q = JFrameFestival.getSession().createQuery(sReq);
        q.setParameter(0, lblID.getText());
        
        Etablissement unEtablissement = (Etablissement)q.uniqueResult();
        
        if (unEtablissement!=null){
            Transaction tx = JFrameFestival.getSession().beginTransaction();
            JFrameFestival.getSession().delete(unEtablissement);
            tx.commit();
            
            JOptionPane.showMessageDialog(null, "Etablissement supprimé avec succés");
        }
        
        viderChamps();
    }//GEN-LAST:event_jBtnSupprimerActionPerformed

    public void viderTableau(){
        DefaultTableModel modele = (DefaultTableModel)jTableEtab.getModel();
        modele.setRowCount(0);
        jTableEtab.setModel(modele);
        jTableEtab.repaint();
    }
    
    public void viderChamps(){
        lblID.setText("");
        txtNom.setText("");
        txtAdresse.setText("");
        txtCP.setText("");
        txtVille.setText("");
        txtTel.setText("");
        txtNomResp.setText("");
        txtPrenomResp.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbCivil;
    private javax.swing.JButton jBtnModifier;
    private javax.swing.JButton jBtnSupprimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLblTitre1;
    private javax.swing.JLabel jLblTitre2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEtab;
    private javax.swing.JLabel lblID;
    private javax.swing.JTextField txtAdresse;
    private javax.swing.JTextField txtCP;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtNomResp;
    private javax.swing.JTextField txtPrenomResp;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtVille;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgVue;

import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import pkgEntite.Etablissement;
import pkgEntite.Offre;

/**
 *
 * @author Olivier
 */
public class JPanelAttCh extends javax.swing.JPanel {

    /**
     * Creates new form JPanelAttCh
     */
    public JPanelAttCh() {
        initComponents();
       chargerListeEtablissement();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCBoxEtab = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEtabAtt = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Etablissements");

        jCBoxEtab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxEtabActionPerformed(evt);
            }
        });

        jTableEtabAtt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Disponibilité", "", "", "", "", ""
            }
        ));
        jScrollPane1.setViewportView(jTableEtabAtt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jCBoxEtab, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(231, 231, 231))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(94, 94, 94)
                .addComponent(jCBoxEtab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCBoxEtabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxEtabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBoxEtabActionPerformed
public void chargerListeEtablissement(){
        
        String sQuery ;
        
        sQuery = "from Etablissement "; //regarde ce n'est pas forcement les bon etablissements
        JFrameFestival.getSession().beginTransaction();
        Query qm = JFrameFestival.getSession().createQuery(sQuery);
        Iterator etab= qm.iterate();
        while (etab.hasNext()){
            Etablissement unEtablissement = (Etablissement)etab.next();
           jCBoxEtab.addItem(unEtablissement.getEtaNom());
           }
        
        String sReq = "from Etablissement where Eta_Nom = ?";
        Query q = JFrameFestival.getSession().createQuery(sReq);
        q.setParameter(0, jCBoxEtab.getSelectedItem());
        
        Etablissement unEtalissement2 = (Etablissement) q.uniqueResult();
        
        //System.out.println(jCbOffHeber.getSelectedItem());
        
        //chargerTabEtab(unEtalissement2);
        
    }
    /*
    public void chargerTabEtab(Etablissement pEtab){

        String idEtab = pEtab.getId();
        JFrameFestival.getSession().beginTransaction();
        String sReq2 = "from Offre, Typechambre where idEtab = ? and idTypeChambre = id";
        Query qm = JFrameFestival.getSession().createQuery(sReq2);
        qm.setParameter(0, idEtab);
        
        Iterator offre = qm.iterate();
        while (offre.hasNext()){
            Offre uneOffre = (Offre)offre.next();
            uneOffre.setEtablissement(pEtab);
            ((DefaultTableModel) jTableEtabAtt.getModel()).addRow(new Object[]
            {uneOffre.getId(), uneOffre.getEtablissement(), uneOffre.getNombreChambres()});
        }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jCBoxEtab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEtabAtt;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgVue;

import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Transaction;
import pkgEntite.Etablissement;
import pkgEntite.Typechambre;

/**
 *
 * @author Olivier
 */
public class JPanelTypeChAjout extends javax.swing.JPanel {

    /**
     * Creates new form JPanelTypeChAjout
     */
    public JPanelTypeChAjout() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        intitule = new javax.swing.JLabel();
        idIntitule = new javax.swing.JLabel();
        libIntitul = new javax.swing.JLabel();
        buttonValider = new javax.swing.JButton();
        buttonRetour = new javax.swing.JButton();
        txtTypeCh = new javax.swing.JTextField();
        txtLibCh = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(700, 520));

        intitule.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        intitule.setText("Nouveau type de chambre");

        idIntitule.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idIntitule.setText("Id :");

        libIntitul.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        libIntitul.setText("Libelle : ");

        buttonValider.setText("Valider");
        buttonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValiderActionPerformed(evt);
            }
        });

        buttonRetour.setText("Retour");
        buttonRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRetourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonValider)
                .addGap(54, 54, 54)
                .addComponent(buttonRetour)
                .addGap(268, 268, 268))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(intitule)
                .addContainerGap(329, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idIntitule)
                    .addComponent(libIntitul))
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtLibCh, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTypeCh, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(intitule)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idIntitule)
                    .addComponent(txtTypeCh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(libIntitul)
                    .addComponent(txtLibCh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonValider)
                    .addComponent(buttonRetour))
                .addGap(86, 86, 86))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValiderActionPerformed
        // TODO add your handling code here:
        byte varTemp = 0;
        Transaction tx = JFrameFestival.getSession().beginTransaction();//recupere la session
         
        String sReq = "from Typechambre where TCh_Id = ?";//requete sql
        Query q = JFrameFestival.getSession().createQuery(sReq);//execute la requete
        q.setParameter(0, txtTypeCh.getText());//recupere la valuer tapée et la met dans la requete
        
        if (q.uniqueResult()==null){
            Typechambre unChambre = new Typechambre(txtTypeCh.getText(), txtLibCh.getText());//crée l'objet
            JFrameFestival.getSession().save(unChambre);//enregistre l'objet
            tx.commit();
            JOptionPane.showMessageDialog(null, "Type de chambre ajouté avec succès");//
        }
        
        txtTypeCh.setText("");//remet les champs a vide
        txtLibCh.setText("");
    }//GEN-LAST:event_buttonValiderActionPerformed

    private void buttonRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRetourActionPerformed
        txtTypeCh.setText("");
        txtLibCh.setText("");
    }//GEN-LAST:event_buttonRetourActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRetour;
    private javax.swing.JButton buttonValider;
    private javax.swing.JLabel idIntitule;
    private javax.swing.JLabel intitule;
    private javax.swing.JLabel libIntitul;
    private javax.swing.JTextField txtLibCh;
    private javax.swing.JTextField txtTypeCh;
    // End of variables declaration//GEN-END:variables
}
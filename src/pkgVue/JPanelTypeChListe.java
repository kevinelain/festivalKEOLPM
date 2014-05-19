/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgVue;

import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pkgEntite.HibernateUtil;
import pkgEntite.Typechambre;
/**
 *
 * @author Olivier
 */
public class JPanelTypeChListe extends javax.swing.JPanel {

    /**
     * Creates new form JpanelTypeChListe
     */
    
    public JPanelTypeChListe() {
        initComponents();
    }
    
     public void listTypeCh()
    {
        
       String sReqm = "from Typechambre";                           //Methode qui permet d'afficher les types de chambre dans le tableau
       Query qm = JFrameFestival.getSession().createQuery(sReqm);   //Execution de la requete
       Iterator chambre = qm.iterate();                             //Parcours
        
       while (chambre.hasNext()){                                  //Tant qu'il a un suivant
            Typechambre unChambre = (Typechambre) chambre.next();  //Aller au suivant
            ((DefaultTableModel) jTableChambre.getModel()).addRow(new Object[]//Ajouter une ligne
            {unChambre.getTchId(),unChambre.getTchLibelle()});                      //Recupere l'id du libelle
            }
       }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableChambre = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtLibChMS = new javax.swing.JTextField();
        jButtonModifTypeCh = new javax.swing.JButton();
        jButtonSuppTypeCh = new javax.swing.JButton();
        idTypeCH = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(700, 520));

        jTableChambre.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTableChambre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type de chambre", "Libelle"
            }
        ));
        jTableChambre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableChambreMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableChambre);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("Liste des types de chambres");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel2.setText("Informations");

        jLabel3.setText("Type de chambre:");

        jLabel4.setText("Libelle:");

        jButtonModifTypeCh.setText("Modifier");
        jButtonModifTypeCh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifTypeChActionPerformed(evt);
            }
        });

        jButtonSuppTypeCh.setText("Supprimer");
        jButtonSuppTypeCh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuppTypeChActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(jLabel2)
                        .addGap(117, 117, 117)))
                .addContainerGap(228, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtLibChMS, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(96, 96, 96)
                                .addComponent(idTypeCH, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(271, 271, 271))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonModifTypeCh)
                        .addGap(89, 89, 89)
                        .addComponent(jButtonSuppTypeCh)
                        .addGap(262, 262, 262))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(idTypeCH, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLibChMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModifTypeCh)
                    .addComponent(jButtonSuppTypeCh))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonModifTypeChActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifTypeChActionPerformed
        // Methode pour modifier
        byte varTemp = 0;
        Transaction tx = JFrameFestival.getSession().beginTransaction();//Récupere la session
         
        String sReq = "from Typechambre where TCh_Id  = ?";//requete SQL
        Query q = JFrameFestival.getSession().createQuery(sReq); //execute la requete
        q.setParameter(0, idTypeCH.getText() );
        Typechambre unTypechambre = (Typechambre)q.uniqueResult();
        unTypechambre.setTchId(idTypeCH.getText());
        unTypechambre.setTchLibelle(txtLibChMS.getText());
            if (unTypechambre!=null){
            JFrameFestival.getSession().update(unTypechambre);
            tx.commit();
            JOptionPane.showMessageDialog(null, "Modification effectuée avec succès");
            }
        idTypeCH.setText("");
        txtLibChMS.setText("");
        ((DefaultTableModel)jTableChambre.getModel()).removeRow(0);
        
    }//GEN-LAST:event_jButtonModifTypeChActionPerformed

    private void jTableChambreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableChambreMouseClicked
     int ligne = jTableChambre.getSelectedRow();//recupere la ligne cliquée
     Object cellule = jTableChambre.getValueAt(ligne,0);
     
     chargerChamps(cellule);                    //Appelle la fonction de chargement des champs
    }//GEN-LAST:event_jTableChambreMouseClicked

    private void jButtonSuppTypeChActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuppTypeChActionPerformed
        // TODO add your handling code here:
        byte varTemp = 0;
        Transaction tx = JFrameFestival.getSession().beginTransaction();
         
        String sReq = "from Typechambre where TCh_Id  = ?";
        Query q = JFrameFestival.getSession().createQuery(sReq);
        q.setParameter(0, idTypeCH.getText());
        Typechambre unTypechambre = (Typechambre)q.uniqueResult();
        
        if (unTypechambre!=null){

            JFrameFestival.getSession().delete(unTypechambre);

            tx.commit();

            JOptionPane.showMessageDialog(null, "Suppression efféctué avec succès");
        }
        
        idTypeCH.setText("");
        txtLibChMS.setText("");
        
    }//GEN-LAST:event_jButtonSuppTypeChActionPerformed
    
    private void chargerChamps(Object cellule){ //Fonction de chargement des champs
        JFrameFestival.getSession().beginTransaction();//ouvrir la session
        String sReq = "from Typechambre where id = ?";  //Recupere tout les types de chambre
        Query q = JFrameFestival.getSession().createQuery(sReq);//execute la requete
        q.setParameter(0, cellule.toString());                  //La valeur que prend le "?" recuperé avant (ici l'id)
        Typechambre unTypechambre = (Typechambre)q.uniqueResult();//Resulta de la requete
        
        idTypeCH.setText(unTypechambre.getTchId());             //Rempli les champs
        txtLibChMS.setText(unTypechambre.getTchLibelle());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel idTypeCH;
    private javax.swing.JButton jButtonModifTypeCh;
    private javax.swing.JButton jButtonSuppTypeCh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableChambre;
    private javax.swing.JTextField txtLibChMS;
    // End of variables declaration//GEN-END:variables
}

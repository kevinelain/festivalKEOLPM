/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgVue;

import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import pkgEntite.Attribution;
import pkgEntite.Etablissement;
import pkgEntite.Groupe;
import pkgEntite.Typechambre;

/**
 *
 * @author Olivier
 */
public class JPanelAttCham extends javax.swing.JPanel {

    /**
     * Creates new form JPanelAttCham
     */
    public JPanelAttCham() {
        initComponents();
    }

     public void listEtablissement()
    {
       viderTableau(); 
        
       String sReqm = "from Etablissement";                           //Methode qui permet d'afficher les etablissements dans le tableau
       Query qm = JFrameFestival.getSession().createQuery(sReqm);   //Execution de la requete
       Iterator etablissement = qm.iterate();                             //Parcours
        
       while (etablissement.hasNext()){                                  //Tant qu'il a un suivant
            Etablissement unEtablissement = ( Etablissement) etablissement.next();  //Aller au suivant
            ((DefaultTableModel) jTableEtabListAtt.getModel()).addRow(new Object[]//Ajouter une ligne
            {unEtablissement.getEtaId(),unEtablissement.getEtaNom()});                      //Recupere l'id du libelle
            }
       }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEtabListAtt = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableAffiAtt = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 800));

        jTableEtabListAtt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code de l'établissement", "Nom de l'établissement"
            }
        ));
        jTableEtabListAtt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEtabListAttMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEtabListAtt);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Liste des etablissements:");

        jTableAffiAtt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Groupe", "Type de chambre", "Chambre attribuées"
            }
        ));
        jScrollPane3.setViewportView(jTableAffiAtt);
        jTableAffiAtt.getColumnModel().getColumn(0).setMaxWidth(500);
        jTableAffiAtt.getColumnModel().getColumn(1).setMaxWidth(300);
        jTableAffiAtt.getColumnModel().getColumn(2).setMaxWidth(300);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Chambres attribuées par groupe pour chaque type de chambre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 550, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel2)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableEtabListAttMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEtabListAttMouseClicked
        int ligne = jTableEtabListAtt.getSelectedRow();//recupere la ligne cliquée
     Object cellule = jTableEtabListAtt.getValueAt(ligne,0);
     
    DefaultTableModel modele = (DefaultTableModel)jTableAffiAtt.getModel(); //vider le tableau a chaque clique
    modele.setRowCount(0);
    jTableAffiAtt.setModel(modele);
    jTableAffiAtt.repaint(); 
    
     listAttrib(cellule);
    }//GEN-LAST:event_jTableEtabListAttMouseClicked

         public void listAttrib(Object cellule) // tableau d'affichage des attribution en fonction du groupe
     {
         JFrameFestival.getSession().beginTransaction();
         String sReqa="from Attribution where ATT_ETABLISSEMENT = ?";//selectionne les etablissements qui possendent une attribution
         Query q = JFrameFestival.getSession().createQuery(sReqa); //execute la requete
         q.setParameter(0, cellule.toString()); 
         Iterator attribution = q.iterate();
        
           while (attribution.hasNext()){                                  //Tant qu'il a un suivant
            Attribution unAttribution = ( Attribution) attribution.next(); 

            
            String sReqg="from Groupe where GP_ID = ?";                 //recupere le nom du groupe qui a un a effectué une attribution
            Query qg = JFrameFestival.getSession().createQuery(sReqg); //execute la requete
            qg.setParameter(0, unAttribution.getGroupe());              //recupere le nom du groupe correspondant a l'id trouvé plus haut
            Iterator groupe = qg.iterate();//Aller au suivant
            
                 while (groupe.hasNext()){                                  //Tant qu'il a un suivant
                 Groupe unGroupe = ( Groupe) groupe.next(); 
                 
                 String sReqt="from Typechambre where TCh_Id  = ?";            //Recupere l'id du type chambre qui a ete reservé par un certain groupe
                 Query qt = JFrameFestival.getSession().createQuery(sReqt); //execute la requete
                 qt.setParameter(0, unAttribution.getId().getAttTypechambre());
                 
                 Typechambre unTypeChambre = (Typechambre)qt.uniqueResult();
                 
            ((DefaultTableModel) jTableAffiAtt.getModel()).addRow(new Object[]
               {unGroupe.getGpNom(),unTypeChambre.getTchLibelle() , unAttribution.getAttNbchambres()});                      //affichage dans le tableau
           }
           }
           
     }
        public void viderTableau(){
        
        DefaultTableModel modele = (DefaultTableModel)jTableEtabListAtt.getModel();
        modele.setRowCount(0);
        jTableEtabListAtt.setModel(modele);
        jTableEtabListAtt.repaint();
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableAffiAtt;
    private javax.swing.JTable jTableEtabListAtt;
    // End of variables declaration//GEN-END:variables
}

package pkgEntite;
// Generated 24 avr. 2014 14:53:42 by Hibernate Tools 3.2.1.GA



/**
 * Typechambre generated by hbm2java
 */
public class Typechambre  implements java.io.Serializable {


     private String tchId;
     private String tchLibelle;

    public Typechambre() {
    }

    public Typechambre(String tchId, String tchLibelle) {
       this.tchId = tchId;
       this.tchLibelle = tchLibelle;
    }
   
    public String getTchId() {
        return this.tchId;
    }
    
    public void setTchId(String tchId) {
        this.tchId = tchId;
    }
    public String getTchLibelle() {
        return this.tchLibelle;
    }
    
    public void setTchLibelle(String tchLibelle) {
        this.tchLibelle = tchLibelle;
    }




}



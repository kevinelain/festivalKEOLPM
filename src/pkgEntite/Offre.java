package pkgEntite;
// Generated 24 avr. 2014 14:53:42 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Offre generated by hbm2java
 */
public class Offre  implements java.io.Serializable {


     private OffreId id;
     private Etablissement etablissement;
     private byte offNbchambres;
     private Set attributions = new HashSet(0);

    public Offre() {
    }

	
    public Offre(OffreId id, Etablissement etablissement, byte offNbchambres) {
        this.id = id;
        this.etablissement = etablissement;
        this.offNbchambres = offNbchambres;
    }
    public Offre(OffreId id, Etablissement etablissement, byte offNbchambres, Set attributions) {
       this.id = id;
       this.etablissement = etablissement;
       this.offNbchambres = offNbchambres;
       this.attributions = attributions;
    }
   
    public OffreId getId() {
        return this.id;
    }
    
    public void setId(OffreId id) {
        this.id = id;
    }
    public Etablissement getEtablissement() {
        return this.etablissement;
    }
    
    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }
    public byte getOffNbchambres() {
        return this.offNbchambres;
    }
    
    public void setOffNbchambres(byte offNbchambres) {
        this.offNbchambres = offNbchambres;
    }
    public Set getAttributions() {
        return this.attributions;
    }
    
    public void setAttributions(Set attributions) {
        this.attributions = attributions;
    }




}



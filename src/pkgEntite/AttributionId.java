package pkgEntite;
// Generated 24 avr. 2014 14:53:42 by Hibernate Tools 3.2.1.GA



/**
 * AttributionId generated by hbm2java
 */
public class AttributionId  implements java.io.Serializable {


     private String attEtablissement;
     private String attTypechambre;
     private String attGroupe;

    public AttributionId() {
    }

    public AttributionId(String attEtablissement, String attTypechambre, String attGroupe) {
       this.attEtablissement = attEtablissement;
       this.attTypechambre = attTypechambre;
       this.attGroupe = attGroupe;
    }
   
    public String getAttEtablissement() {
        return this.attEtablissement;
    }
    
    public void setAttEtablissement(String attEtablissement) {
        this.attEtablissement = attEtablissement;
    }
    public String getAttTypechambre() {
        return this.attTypechambre;
    }
    
    public void setAttTypechambre(String attTypechambre) {
        this.attTypechambre = attTypechambre;
    }
    public String getAttGroupe() {
        return this.attGroupe;
    }
    
    public void setAttGroupe(String attGroupe) {
        this.attGroupe = attGroupe;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AttributionId) ) return false;
		 AttributionId castOther = ( AttributionId ) other; 
         
		 return ( (this.getAttEtablissement()==castOther.getAttEtablissement()) || ( this.getAttEtablissement()!=null && castOther.getAttEtablissement()!=null && this.getAttEtablissement().equals(castOther.getAttEtablissement()) ) )
 && ( (this.getAttTypechambre()==castOther.getAttTypechambre()) || ( this.getAttTypechambre()!=null && castOther.getAttTypechambre()!=null && this.getAttTypechambre().equals(castOther.getAttTypechambre()) ) )
 && ( (this.getAttGroupe()==castOther.getAttGroupe()) || ( this.getAttGroupe()!=null && castOther.getAttGroupe()!=null && this.getAttGroupe().equals(castOther.getAttGroupe()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAttEtablissement() == null ? 0 : this.getAttEtablissement().hashCode() );
         result = 37 * result + ( getAttTypechambre() == null ? 0 : this.getAttTypechambre().hashCode() );
         result = 37 * result + ( getAttGroupe() == null ? 0 : this.getAttGroupe().hashCode() );
         return result;
   }   


}



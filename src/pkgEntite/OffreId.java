package pkgEntite;
// Generated 24 avr. 2014 14:53:42 by Hibernate Tools 3.2.1.GA



/**
 * OffreId generated by hbm2java
 */
public class OffreId  implements java.io.Serializable {


     private String offEtablissement;
     private String offTypechambre;

    public OffreId() {
    }

    public OffreId(String offEtablissement, String offTypechambre) {
       this.offEtablissement = offEtablissement;
       this.offTypechambre = offTypechambre;
    }
   
    public String getOffEtablissement() {
        return this.offEtablissement;
    }
    
    public void setOffEtablissement(String offEtablissement) {
        this.offEtablissement = offEtablissement;
    }
    public String getOffTypechambre() {
        return this.offTypechambre;
    }
    
    public void setOffTypechambre(String offTypechambre) {
        this.offTypechambre = offTypechambre;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof OffreId) ) return false;
		 OffreId castOther = ( OffreId ) other; 
         
		 return ( (this.getOffEtablissement()==castOther.getOffEtablissement()) || ( this.getOffEtablissement()!=null && castOther.getOffEtablissement()!=null && this.getOffEtablissement().equals(castOther.getOffEtablissement()) ) )
 && ( (this.getOffTypechambre()==castOther.getOffTypechambre()) || ( this.getOffTypechambre()!=null && castOther.getOffTypechambre()!=null && this.getOffTypechambre().equals(castOther.getOffTypechambre()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getOffEtablissement() == null ? 0 : this.getOffEtablissement().hashCode() );
         result = 37 * result + ( getOffTypechambre() == null ? 0 : this.getOffTypechambre().hashCode() );
         return result;
   }   


}



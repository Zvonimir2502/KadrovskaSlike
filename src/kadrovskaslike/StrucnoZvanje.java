package kadrovskaslike;
// Generated Sep 30, 2014 11:09:10 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * StrucnoZvanje generated by hbm2java
 */
public class StrucnoZvanje  implements java.io.Serializable {


     private long szvPid;
     private String naziv;
     private Set djelatniks = new HashSet(0);

    public StrucnoZvanje() {
    }

	
    public StrucnoZvanje(long szvPid, String naziv) {
        this.szvPid = szvPid;
        this.naziv = naziv;
    }
    public StrucnoZvanje(long szvPid, String naziv, Set djelatniks) {
       this.szvPid = szvPid;
       this.naziv = naziv;
       this.djelatniks = djelatniks;
    }
   
    public long getSzvPid() {
        return this.szvPid;
    }
    
    public void setSzvPid(long szvPid) {
        this.szvPid = szvPid;
    }
    public String getNaziv() {
        return this.naziv;
    }
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    public Set getDjelatniks() {
        return this.djelatniks;
    }
    
    public void setDjelatniks(Set djelatniks) {
        this.djelatniks = djelatniks;
    }




}


package kadrovskaslike;
// Generated Sep 30, 2014 11:09:10 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Posao generated by hbm2java
 */
public class Posao  implements java.io.Serializable {


     private long posPid;
     private StrucnaSprema strucnaSprema;
     private String naziv;
     private Boolean ovlastenikZnr;
     private String nazivNkz;
     private Set djelatniks = new HashSet(0);

    public Posao() {
    }

	
    public Posao(long posPid, String naziv) {
        this.posPid = posPid;
        this.naziv = naziv;
    }
    public Posao(long posPid, StrucnaSprema strucnaSprema, String naziv, Boolean ovlastenikZnr, String nazivNkz, Set djelatniks) {
       this.posPid = posPid;
       this.strucnaSprema = strucnaSprema;
       this.naziv = naziv;
       this.ovlastenikZnr = ovlastenikZnr;
       this.nazivNkz = nazivNkz;
       this.djelatniks = djelatniks;
    }
   
    public long getPosPid() {
        return this.posPid;
    }
    
    public void setPosPid(long posPid) {
        this.posPid = posPid;
    }
    public StrucnaSprema getStrucnaSprema() {
        return this.strucnaSprema;
    }
    
    public void setStrucnaSprema(StrucnaSprema strucnaSprema) {
        this.strucnaSprema = strucnaSprema;
    }
    public String getNaziv() {
        return this.naziv;
    }
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    public Boolean getOvlastenikZnr() {
        return this.ovlastenikZnr;
    }
    
    public void setOvlastenikZnr(Boolean ovlastenikZnr) {
        this.ovlastenikZnr = ovlastenikZnr;
    }
    public String getNazivNkz() {
        return this.nazivNkz;
    }
    
    public void setNazivNkz(String nazivNkz) {
        this.nazivNkz = nazivNkz;
    }
    public Set getDjelatniks() {
        return this.djelatniks;
    }
    
    public void setDjelatniks(Set djelatniks) {
        this.djelatniks = djelatniks;
    }




}



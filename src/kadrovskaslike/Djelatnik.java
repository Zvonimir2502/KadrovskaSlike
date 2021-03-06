package kadrovskaslike;
// Generated Sep 30, 2014 11:09:10 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Djelatnik generated by hbm2java
 */
public class Djelatnik  implements java.io.Serializable {


     private long djePid;
     private Posao posao;
     private StrucnaSprema strucnaSprema;
     private StrucnoZvanje strucnoZvanje;
     private RadnaJedinica radnaJedinica;
     private BracnoStanje bracnoStanje;
     private Vjera vjera;
     private VrstaRada vrstaRada;
     private VrstaZaposlenja vrstaZaposlenja;
     private String imeOca;
     private String imeMajke;
     private String jmbg;
     private Long mjePidPrebivanja;
     private String spol;
     private Date datumZaposlenja;
     private Date datumOdlaska;
     private Long mjePidRodjenja;
     private String adresa;
     private String prezimeIme;
     private Date datumRodjenja;
     private Date datumUpisa;
     private Long korPid;
     private Blob fotografija;
     private String brojOsIskaznice;
     private String radniStaz;
     private String brojHzzo;
     private int brojIskaznice;
     private Short brojFotografije;
     private Long nacPid;
     private Boolean vrstaRada_1;
     private Boolean satiRada;
     private String oib;
     private Boolean pravilnikRacunalo;
     private String prekidStaza;
     private String vrstaZaposlenja_1;
     private Long purPid;
     private String brojOsiguranja;
     private String mirovinskiStup;
     private BigDecimal bod;
     private Long uzdrzavaneOsobe;
     private BigDecimal uzdrzavaneOsobeKoef;
     private Long djeca;
     private BigDecimal djecaKoef;
     private String vrstaInvalidnosti;
     private BigDecimal iznosInvalidnosti;
     private String telefon;
     private Long djeDopPid;
     private Long djePorPid;
     private Long rsOsoPid;
     private Long rsOziPid;
     private Long rsOzsPid;
     private Long rsOzoPid;
     private BigDecimal invalidnostKoef;
     private Date datumNaOdredjeno;
     private Long rodPid;
     private Byte brojDanaGo;
     private Byte trajanjePoticaja;
     private Byte brojDanaGoStarog;
     private Long mjePidRada;
     private Date oiDatumIzdavanja;
     private Date oiVrijediDo;
     private String oiIzdao;
     private String napomena;
     private Date datumNaNeodredjeno;
     private Date probniRadOd;
     private Date probniRadDo;
     private Date pripravStazOd;
     private Date pripravStazDo;
     private String strucniIspitBroj;
     private Date strucniIspitDatum;
     private Byte tjednoRadnoVrijeme;
     private Date mirovanjeOd;
     private Date mirovanjeDo;
     private String mirovanjeRazlog;
     private String zabranaNatjecanja;
     private String drugiPoslodavac;
     private Byte tjednoPunoRadnoVrijeme;
     private Byte tjednoNepunoRadnoVrijeme;
     private Byte dnevnoRadnoVrijeme;
     private String dnevniRasporedPonPet;
     private String dnevniRasporedSub;
     private String smjenskiRadI;
     private String smjenskiRadIi;
     private String nocniRad;
     private Date trudnickoOd;
     private Date trudnickoDo;
     private String nesposobnostUvjeti;
     private String drzavljanstvo;
     private String radnaDozvola;
     private String invalidnostUvjeti;
     private Date invalidnostOd;
     private Date nesposobnostOd;
     private String bivsePrezime;
     private String dojenje;
     private Long mjePidPu;
     private String radInozemstvo;
     private Boolean produzenoMo;
     private String razlogPovecaniStaz;
     private Set radnaJedinicas = new HashSet(0);

    public Djelatnik() {
    }

	
    public Djelatnik(long djePid, String spol, String prezimeIme, int brojIskaznice, String oib) {
        this.djePid = djePid;
        this.spol = spol;
        this.prezimeIme = prezimeIme;
        this.brojIskaznice = brojIskaznice;
        this.oib = oib;
        
        
    }
    public Djelatnik(long djePid, Posao posao, StrucnaSprema strucnaSprema, StrucnoZvanje strucnoZvanje, RadnaJedinica radnaJedinica, BracnoStanje bracnoStanje, Vjera vjera, VrstaRada vrstaRada, VrstaZaposlenja vrstaZaposlenja, String imeOca, String imeMajke, String jmbg, Long mjePidPrebivanja, String spol, Date datumZaposlenja, Date datumOdlaska, Long mjePidRodjenja, String adresa, String prezimeIme, Date datumRodjenja, Date datumUpisa, Long korPid, Blob fotografija, String brojOsIskaznice, String radniStaz, String brojHzzo, int brojIskaznice, Short brojFotografije, Long nacPid, Boolean vrstaRada_1, Boolean satiRada, String oib, Boolean pravilnikRacunalo, String prekidStaza, String vrstaZaposlenja_1, Long purPid, String brojOsiguranja, String mirovinskiStup, BigDecimal bod, Long uzdrzavaneOsobe, BigDecimal uzdrzavaneOsobeKoef, Long djeca, BigDecimal djecaKoef, String vrstaInvalidnosti, BigDecimal iznosInvalidnosti, String telefon, Long djeDopPid, Long djePorPid, Long rsOsoPid, Long rsOziPid, Long rsOzsPid, Long rsOzoPid, BigDecimal invalidnostKoef, Date datumNaOdredjeno, Long rodPid, Byte brojDanaGo, Byte trajanjePoticaja, Byte brojDanaGoStarog, Long mjePidRada, Date oiDatumIzdavanja, Date oiVrijediDo, String oiIzdao, String napomena, Date datumNaNeodredjeno, Date probniRadOd, Date probniRadDo, Date pripravStazOd, Date pripravStazDo, String strucniIspitBroj, Date strucniIspitDatum, Byte tjednoRadnoVrijeme, Date mirovanjeOd, Date mirovanjeDo, String mirovanjeRazlog, String zabranaNatjecanja, String drugiPoslodavac, Byte tjednoPunoRadnoVrijeme, Byte tjednoNepunoRadnoVrijeme, Byte dnevnoRadnoVrijeme, String dnevniRasporedPonPet, String dnevniRasporedSub, String smjenskiRadI, String smjenskiRadIi, String nocniRad, Date trudnickoOd, Date trudnickoDo, String nesposobnostUvjeti, String drzavljanstvo, String radnaDozvola, String invalidnostUvjeti, Date invalidnostOd, Date nesposobnostOd, String bivsePrezime, String dojenje, Long mjePidPu, String radInozemstvo, Boolean produzenoMo, String razlogPovecaniStaz, Set radnaJedinicas) {
       this.djePid = djePid;
       this.posao = posao;
       this.strucnaSprema = strucnaSprema;
       this.strucnoZvanje = strucnoZvanje;
       this.radnaJedinica = radnaJedinica;
       this.bracnoStanje = bracnoStanje;
       this.vjera = vjera;
       this.vrstaRada = vrstaRada;
       this.vrstaZaposlenja = vrstaZaposlenja;
       this.imeOca = imeOca;
       this.imeMajke = imeMajke;
       this.jmbg = jmbg;
       this.mjePidPrebivanja = mjePidPrebivanja;
       this.spol = spol;
       this.datumZaposlenja = datumZaposlenja;
       this.datumOdlaska = datumOdlaska;
       this.mjePidRodjenja = mjePidRodjenja;
       this.adresa = adresa;
       this.prezimeIme = prezimeIme;
       this.datumRodjenja = datumRodjenja;
       this.datumUpisa = datumUpisa;
       this.korPid = korPid;
       this.fotografija = fotografija;
       this.brojOsIskaznice = brojOsIskaznice;
       this.radniStaz = radniStaz;
       this.brojHzzo = brojHzzo;
       this.brojIskaznice = brojIskaznice;
       this.brojFotografije = brojFotografije;
       this.nacPid = nacPid;
       this.vrstaRada_1 = vrstaRada_1;
       this.satiRada = satiRada;
       this.oib = oib;
       this.pravilnikRacunalo = pravilnikRacunalo;
       this.prekidStaza = prekidStaza;
       this.vrstaZaposlenja_1 = vrstaZaposlenja_1;
       this.purPid = purPid;
       this.brojOsiguranja = brojOsiguranja;
       this.mirovinskiStup = mirovinskiStup;
       this.bod = bod;
       this.uzdrzavaneOsobe = uzdrzavaneOsobe;
       this.uzdrzavaneOsobeKoef = uzdrzavaneOsobeKoef;
       this.djeca = djeca;
       this.djecaKoef = djecaKoef;
       this.vrstaInvalidnosti = vrstaInvalidnosti;
       this.iznosInvalidnosti = iznosInvalidnosti;
       this.telefon = telefon;
       this.djeDopPid = djeDopPid;
       this.djePorPid = djePorPid;
       this.rsOsoPid = rsOsoPid;
       this.rsOziPid = rsOziPid;
       this.rsOzsPid = rsOzsPid;
       this.rsOzoPid = rsOzoPid;
       this.invalidnostKoef = invalidnostKoef;
       this.datumNaOdredjeno = datumNaOdredjeno;
       this.rodPid = rodPid;
       this.brojDanaGo = brojDanaGo;
       this.trajanjePoticaja = trajanjePoticaja;
       this.brojDanaGoStarog = brojDanaGoStarog;
       this.mjePidRada = mjePidRada;
       this.oiDatumIzdavanja = oiDatumIzdavanja;
       this.oiVrijediDo = oiVrijediDo;
       this.oiIzdao = oiIzdao;
       this.napomena = napomena;
       this.datumNaNeodredjeno = datumNaNeodredjeno;
       this.probniRadOd = probniRadOd;
       this.probniRadDo = probniRadDo;
       this.pripravStazOd = pripravStazOd;
       this.pripravStazDo = pripravStazDo;
       this.strucniIspitBroj = strucniIspitBroj;
       this.strucniIspitDatum = strucniIspitDatum;
       this.tjednoRadnoVrijeme = tjednoRadnoVrijeme;
       this.mirovanjeOd = mirovanjeOd;
       this.mirovanjeDo = mirovanjeDo;
       this.mirovanjeRazlog = mirovanjeRazlog;
       this.zabranaNatjecanja = zabranaNatjecanja;
       this.drugiPoslodavac = drugiPoslodavac;
       this.tjednoPunoRadnoVrijeme = tjednoPunoRadnoVrijeme;
       this.tjednoNepunoRadnoVrijeme = tjednoNepunoRadnoVrijeme;
       this.dnevnoRadnoVrijeme = dnevnoRadnoVrijeme;
       this.dnevniRasporedPonPet = dnevniRasporedPonPet;
       this.dnevniRasporedSub = dnevniRasporedSub;
       this.smjenskiRadI = smjenskiRadI;
       this.smjenskiRadIi = smjenskiRadIi;
       this.nocniRad = nocniRad;
       this.trudnickoOd = trudnickoOd;
       this.trudnickoDo = trudnickoDo;
       this.nesposobnostUvjeti = nesposobnostUvjeti;
       this.drzavljanstvo = drzavljanstvo;
       this.radnaDozvola = radnaDozvola;
       this.invalidnostUvjeti = invalidnostUvjeti;
       this.invalidnostOd = invalidnostOd;
       this.nesposobnostOd = nesposobnostOd;
       this.bivsePrezime = bivsePrezime;
       this.dojenje = dojenje;
       this.mjePidPu = mjePidPu;
       this.radInozemstvo = radInozemstvo;
       this.produzenoMo = produzenoMo;
       this.razlogPovecaniStaz = razlogPovecaniStaz;
       this.radnaJedinicas = radnaJedinicas;
    }
   
    public long getDjePid() {
        return this.djePid;
    }
    
    public void setDjePid(long djePid) {
        this.djePid = djePid;
    }
    public Posao getPosao() {
        return this.posao;
    }
    
    public void setPosao(Posao posao) {
        this.posao = posao;
    }
    public StrucnaSprema getStrucnaSprema() {
        return this.strucnaSprema;
    }
    
    public void setStrucnaSprema(StrucnaSprema strucnaSprema) {
        this.strucnaSprema = strucnaSprema;
    }
    public StrucnoZvanje getStrucnoZvanje() {
        return this.strucnoZvanje;
    }
    
    public void setStrucnoZvanje(StrucnoZvanje strucnoZvanje) {
        this.strucnoZvanje = strucnoZvanje;
    }
    public RadnaJedinica getRadnaJedinica() {
        return this.radnaJedinica;
    }
    
    public void setRadnaJedinica(RadnaJedinica radnaJedinica) {
        this.radnaJedinica = radnaJedinica;
    }
    public BracnoStanje getBracnoStanje() {
        return this.bracnoStanje;
    }
    
    public void setBracnoStanje(BracnoStanje bracnoStanje) {
        this.bracnoStanje = bracnoStanje;
    }
    public Vjera getVjera() {
        return this.vjera;
    }
    
    public void setVjera(Vjera vjera) {
        this.vjera = vjera;
    }
    public VrstaRada getVrstaRada() {
        return this.vrstaRada;
    }
    
    public void setVrstaRada(VrstaRada vrstaRada) {
        this.vrstaRada = vrstaRada;
    }
    public VrstaZaposlenja getVrstaZaposlenja() {
        return this.vrstaZaposlenja;
    }
    
    public void setVrstaZaposlenja(VrstaZaposlenja vrstaZaposlenja) {
        this.vrstaZaposlenja = vrstaZaposlenja;
    }
    public String getImeOca() {
        return this.imeOca;
    }
    
    public void setImeOca(String imeOca) {
        this.imeOca = imeOca;
    }
    public String getImeMajke() {
        return this.imeMajke;
    }
    
    public void setImeMajke(String imeMajke) {
        this.imeMajke = imeMajke;
    }
    public String getJmbg() {
        return this.jmbg;
    }
    
    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
    public Long getMjePidPrebivanja() {
        return this.mjePidPrebivanja;
    }
    
    public void setMjePidPrebivanja(Long mjePidPrebivanja) {
        this.mjePidPrebivanja = mjePidPrebivanja;
    }
    public String getSpol() {
        return this.spol;
    }
    
    public void setSpol(String spol) {
        this.spol = spol;
    }
    public Date getDatumZaposlenja() {
        return this.datumZaposlenja;
    }
    
    public void setDatumZaposlenja(Date datumZaposlenja) {
        this.datumZaposlenja = datumZaposlenja;
    }
    public Date getDatumOdlaska() {
        return this.datumOdlaska;
    }
    
    public void setDatumOdlaska(Date datumOdlaska) {
        this.datumOdlaska = datumOdlaska;
    }
    public Long getMjePidRodjenja() {
        return this.mjePidRodjenja;
    }
    
    public void setMjePidRodjenja(Long mjePidRodjenja) {
        this.mjePidRodjenja = mjePidRodjenja;
    }
    public String getAdresa() {
        return this.adresa;
    }
    
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    public String getPrezimeIme() {
        return this.prezimeIme;
    }
    
    public void setPrezimeIme(String prezimeIme) {
        this.prezimeIme = prezimeIme;
    }
    public Date getDatumRodjenja() {
        return this.datumRodjenja;
    }
    
    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }
    public Date getDatumUpisa() {
        return this.datumUpisa;
    }
    
    public void setDatumUpisa(Date datumUpisa) {
        this.datumUpisa = datumUpisa;
    }
    public Long getKorPid() {
        return this.korPid;
    }
    
    public void setKorPid(Long korPid) {
        this.korPid = korPid;
    }
    public Blob getFotografija() {
        return this.fotografija;
    }
    
    public void setFotografija(Blob fotografija) {
        this.fotografija = fotografija;
    }
    public String getBrojOsIskaznice() {
        return this.brojOsIskaznice;
    }
    
    public void setBrojOsIskaznice(String brojOsIskaznice) {
        this.brojOsIskaznice = brojOsIskaznice;
    }
    public String getRadniStaz() {
        return this.radniStaz;
    }
    
    public void setRadniStaz(String radniStaz) {
        this.radniStaz = radniStaz;
    }
    public String getBrojHzzo() {
        return this.brojHzzo;
    }
    
    public void setBrojHzzo(String brojHzzo) {
        this.brojHzzo = brojHzzo;
    }
    public int getBrojIskaznice() {
        return this.brojIskaznice;
    }
    
    public void setBrojIskaznice(int brojIskaznice) {
        this.brojIskaznice = brojIskaznice;
    }
    public Short getBrojFotografije() {
        return this.brojFotografije;
    }
    
    public void setBrojFotografije(Short brojFotografije) {
        this.brojFotografije = brojFotografije;
    }
    public Long getNacPid() {
        return this.nacPid;
    }
    
    public void setNacPid(Long nacPid) {
        this.nacPid = nacPid;
    }
    public Boolean getVrstaRada_1() {
        return this.vrstaRada_1;
    }
    
    public void setVrstaRada_1(Boolean vrstaRada_1) {
        this.vrstaRada_1 = vrstaRada_1;
    }
    public Boolean getSatiRada() {
        return this.satiRada;
    }
    
    public void setSatiRada(Boolean satiRada) {
        this.satiRada = satiRada;
    }
    public String getOib() {
        return this.oib;
    }
    
    public void setOib(String oib) {
        this.oib = oib;
    }
    public Boolean getPravilnikRacunalo() {
        return this.pravilnikRacunalo;
    }
    
    public void setPravilnikRacunalo(Boolean pravilnikRacunalo) {
        this.pravilnikRacunalo = pravilnikRacunalo;
    }
    public String getPrekidStaza() {
        return this.prekidStaza;
    }
    
    public void setPrekidStaza(String prekidStaza) {
        this.prekidStaza = prekidStaza;
    }
    public String getVrstaZaposlenja_1() {
        return this.vrstaZaposlenja_1;
    }
    
    public void setVrstaZaposlenja_1(String vrstaZaposlenja_1) {
        this.vrstaZaposlenja_1 = vrstaZaposlenja_1;
    }
    public Long getPurPid() {
        return this.purPid;
    }
    
    public void setPurPid(Long purPid) {
        this.purPid = purPid;
    }
    public String getBrojOsiguranja() {
        return this.brojOsiguranja;
    }
    
    public void setBrojOsiguranja(String brojOsiguranja) {
        this.brojOsiguranja = brojOsiguranja;
    }
    public String getMirovinskiStup() {
        return this.mirovinskiStup;
    }
    
    public void setMirovinskiStup(String mirovinskiStup) {
        this.mirovinskiStup = mirovinskiStup;
    }
    public BigDecimal getBod() {
        return this.bod;
    }
    
    public void setBod(BigDecimal bod) {
        this.bod = bod;
    }
    public Long getUzdrzavaneOsobe() {
        return this.uzdrzavaneOsobe;
    }
    
    public void setUzdrzavaneOsobe(Long uzdrzavaneOsobe) {
        this.uzdrzavaneOsobe = uzdrzavaneOsobe;
    }
    public BigDecimal getUzdrzavaneOsobeKoef() {
        return this.uzdrzavaneOsobeKoef;
    }
    
    public void setUzdrzavaneOsobeKoef(BigDecimal uzdrzavaneOsobeKoef) {
        this.uzdrzavaneOsobeKoef = uzdrzavaneOsobeKoef;
    }
    public Long getDjeca() {
        return this.djeca;
    }
    
    public void setDjeca(Long djeca) {
        this.djeca = djeca;
    }
    public BigDecimal getDjecaKoef() {
        return this.djecaKoef;
    }
    
    public void setDjecaKoef(BigDecimal djecaKoef) {
        this.djecaKoef = djecaKoef;
    }
    public String getVrstaInvalidnosti() {
        return this.vrstaInvalidnosti;
    }
    
    public void setVrstaInvalidnosti(String vrstaInvalidnosti) {
        this.vrstaInvalidnosti = vrstaInvalidnosti;
    }
    public BigDecimal getIznosInvalidnosti() {
        return this.iznosInvalidnosti;
    }
    
    public void setIznosInvalidnosti(BigDecimal iznosInvalidnosti) {
        this.iznosInvalidnosti = iznosInvalidnosti;
    }
    public String getTelefon() {
        return this.telefon;
    }
    
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public Long getDjeDopPid() {
        return this.djeDopPid;
    }
    
    public void setDjeDopPid(Long djeDopPid) {
        this.djeDopPid = djeDopPid;
    }
    public Long getDjePorPid() {
        return this.djePorPid;
    }
    
    public void setDjePorPid(Long djePorPid) {
        this.djePorPid = djePorPid;
    }
    public Long getRsOsoPid() {
        return this.rsOsoPid;
    }
    
    public void setRsOsoPid(Long rsOsoPid) {
        this.rsOsoPid = rsOsoPid;
    }
    public Long getRsOziPid() {
        return this.rsOziPid;
    }
    
    public void setRsOziPid(Long rsOziPid) {
        this.rsOziPid = rsOziPid;
    }
    public Long getRsOzsPid() {
        return this.rsOzsPid;
    }
    
    public void setRsOzsPid(Long rsOzsPid) {
        this.rsOzsPid = rsOzsPid;
    }
    public Long getRsOzoPid() {
        return this.rsOzoPid;
    }
    
    public void setRsOzoPid(Long rsOzoPid) {
        this.rsOzoPid = rsOzoPid;
    }
    public BigDecimal getInvalidnostKoef() {
        return this.invalidnostKoef;
    }
    
    public void setInvalidnostKoef(BigDecimal invalidnostKoef) {
        this.invalidnostKoef = invalidnostKoef;
    }
    public Date getDatumNaOdredjeno() {
        return this.datumNaOdredjeno;
    }
    
    public void setDatumNaOdredjeno(Date datumNaOdredjeno) {
        this.datumNaOdredjeno = datumNaOdredjeno;
    }
    public Long getRodPid() {
        return this.rodPid;
    }
    
    public void setRodPid(Long rodPid) {
        this.rodPid = rodPid;
    }
    public Byte getBrojDanaGo() {
        return this.brojDanaGo;
    }
    
    public void setBrojDanaGo(Byte brojDanaGo) {
        this.brojDanaGo = brojDanaGo;
    }
    public Byte getTrajanjePoticaja() {
        return this.trajanjePoticaja;
    }
    
    public void setTrajanjePoticaja(Byte trajanjePoticaja) {
        this.trajanjePoticaja = trajanjePoticaja;
    }
    public Byte getBrojDanaGoStarog() {
        return this.brojDanaGoStarog;
    }
    
    public void setBrojDanaGoStarog(Byte brojDanaGoStarog) {
        this.brojDanaGoStarog = brojDanaGoStarog;
    }
    public Long getMjePidRada() {
        return this.mjePidRada;
    }
    
    public void setMjePidRada(Long mjePidRada) {
        this.mjePidRada = mjePidRada;
    }
    public Date getOiDatumIzdavanja() {
        return this.oiDatumIzdavanja;
    }
    
    public void setOiDatumIzdavanja(Date oiDatumIzdavanja) {
        this.oiDatumIzdavanja = oiDatumIzdavanja;
    }
    public Date getOiVrijediDo() {
        return this.oiVrijediDo;
    }
    
    public void setOiVrijediDo(Date oiVrijediDo) {
        this.oiVrijediDo = oiVrijediDo;
    }
    public String getOiIzdao() {
        return this.oiIzdao;
    }
    
    public void setOiIzdao(String oiIzdao) {
        this.oiIzdao = oiIzdao;
    }
    public String getNapomena() {
        return this.napomena;
    }
    
    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }
    public Date getDatumNaNeodredjeno() {
        return this.datumNaNeodredjeno;
    }
    
    public void setDatumNaNeodredjeno(Date datumNaNeodredjeno) {
        this.datumNaNeodredjeno = datumNaNeodredjeno;
    }
    public Date getProbniRadOd() {
        return this.probniRadOd;
    }
    
    public void setProbniRadOd(Date probniRadOd) {
        this.probniRadOd = probniRadOd;
    }
    public Date getProbniRadDo() {
        return this.probniRadDo;
    }
    
    public void setProbniRadDo(Date probniRadDo) {
        this.probniRadDo = probniRadDo;
    }
    public Date getPripravStazOd() {
        return this.pripravStazOd;
    }
    
    public void setPripravStazOd(Date pripravStazOd) {
        this.pripravStazOd = pripravStazOd;
    }
    public Date getPripravStazDo() {
        return this.pripravStazDo;
    }
    
    public void setPripravStazDo(Date pripravStazDo) {
        this.pripravStazDo = pripravStazDo;
    }
    public String getStrucniIspitBroj() {
        return this.strucniIspitBroj;
    }
    
    public void setStrucniIspitBroj(String strucniIspitBroj) {
        this.strucniIspitBroj = strucniIspitBroj;
    }
    public Date getStrucniIspitDatum() {
        return this.strucniIspitDatum;
    }
    
    public void setStrucniIspitDatum(Date strucniIspitDatum) {
        this.strucniIspitDatum = strucniIspitDatum;
    }
    public Byte getTjednoRadnoVrijeme() {
        return this.tjednoRadnoVrijeme;
    }
    
    public void setTjednoRadnoVrijeme(Byte tjednoRadnoVrijeme) {
        this.tjednoRadnoVrijeme = tjednoRadnoVrijeme;
    }
    public Date getMirovanjeOd() {
        return this.mirovanjeOd;
    }
    
    public void setMirovanjeOd(Date mirovanjeOd) {
        this.mirovanjeOd = mirovanjeOd;
    }
    public Date getMirovanjeDo() {
        return this.mirovanjeDo;
    }
    
    public void setMirovanjeDo(Date mirovanjeDo) {
        this.mirovanjeDo = mirovanjeDo;
    }
    public String getMirovanjeRazlog() {
        return this.mirovanjeRazlog;
    }
    
    public void setMirovanjeRazlog(String mirovanjeRazlog) {
        this.mirovanjeRazlog = mirovanjeRazlog;
    }
    public String getZabranaNatjecanja() {
        return this.zabranaNatjecanja;
    }
    
    public void setZabranaNatjecanja(String zabranaNatjecanja) {
        this.zabranaNatjecanja = zabranaNatjecanja;
    }
    public String getDrugiPoslodavac() {
        return this.drugiPoslodavac;
    }
    
    public void setDrugiPoslodavac(String drugiPoslodavac) {
        this.drugiPoslodavac = drugiPoslodavac;
    }
    public Byte getTjednoPunoRadnoVrijeme() {
        return this.tjednoPunoRadnoVrijeme;
    }
    
    public void setTjednoPunoRadnoVrijeme(Byte tjednoPunoRadnoVrijeme) {
        this.tjednoPunoRadnoVrijeme = tjednoPunoRadnoVrijeme;
    }
    public Byte getTjednoNepunoRadnoVrijeme() {
        return this.tjednoNepunoRadnoVrijeme;
    }
    
    public void setTjednoNepunoRadnoVrijeme(Byte tjednoNepunoRadnoVrijeme) {
        this.tjednoNepunoRadnoVrijeme = tjednoNepunoRadnoVrijeme;
    }
    public Byte getDnevnoRadnoVrijeme() {
        return this.dnevnoRadnoVrijeme;
    }
    
    public void setDnevnoRadnoVrijeme(Byte dnevnoRadnoVrijeme) {
        this.dnevnoRadnoVrijeme = dnevnoRadnoVrijeme;
    }
    public String getDnevniRasporedPonPet() {
        return this.dnevniRasporedPonPet;
    }
    
    public void setDnevniRasporedPonPet(String dnevniRasporedPonPet) {
        this.dnevniRasporedPonPet = dnevniRasporedPonPet;
    }
    public String getDnevniRasporedSub() {
        return this.dnevniRasporedSub;
    }
    
    public void setDnevniRasporedSub(String dnevniRasporedSub) {
        this.dnevniRasporedSub = dnevniRasporedSub;
    }
    public String getSmjenskiRadI() {
        return this.smjenskiRadI;
    }
    
    public void setSmjenskiRadI(String smjenskiRadI) {
        this.smjenskiRadI = smjenskiRadI;
    }
    public String getSmjenskiRadIi() {
        return this.smjenskiRadIi;
    }
    
    public void setSmjenskiRadIi(String smjenskiRadIi) {
        this.smjenskiRadIi = smjenskiRadIi;
    }
    public String getNocniRad() {
        return this.nocniRad;
    }
    
    public void setNocniRad(String nocniRad) {
        this.nocniRad = nocniRad;
    }
    public Date getTrudnickoOd() {
        return this.trudnickoOd;
    }
    
    public void setTrudnickoOd(Date trudnickoOd) {
        this.trudnickoOd = trudnickoOd;
    }
    public Date getTrudnickoDo() {
        return this.trudnickoDo;
    }
    
    public void setTrudnickoDo(Date trudnickoDo) {
        this.trudnickoDo = trudnickoDo;
    }
    public String getNesposobnostUvjeti() {
        return this.nesposobnostUvjeti;
    }
    
    public void setNesposobnostUvjeti(String nesposobnostUvjeti) {
        this.nesposobnostUvjeti = nesposobnostUvjeti;
    }
    public String getDrzavljanstvo() {
        return this.drzavljanstvo;
    }
    
    public void setDrzavljanstvo(String drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }
    public String getRadnaDozvola() {
        return this.radnaDozvola;
    }
    
    public void setRadnaDozvola(String radnaDozvola) {
        this.radnaDozvola = radnaDozvola;
    }
    public String getInvalidnostUvjeti() {
        return this.invalidnostUvjeti;
    }
    
    public void setInvalidnostUvjeti(String invalidnostUvjeti) {
        this.invalidnostUvjeti = invalidnostUvjeti;
    }
    public Date getInvalidnostOd() {
        return this.invalidnostOd;
    }
    
    public void setInvalidnostOd(Date invalidnostOd) {
        this.invalidnostOd = invalidnostOd;
    }
    public Date getNesposobnostOd() {
        return this.nesposobnostOd;
    }
    
    public void setNesposobnostOd(Date nesposobnostOd) {
        this.nesposobnostOd = nesposobnostOd;
    }
    public String getBivsePrezime() {
        return this.bivsePrezime;
    }
    
    public void setBivsePrezime(String bivsePrezime) {
        this.bivsePrezime = bivsePrezime;
    }
    public String getDojenje() {
        return this.dojenje;
    }
    
    public void setDojenje(String dojenje) {
        this.dojenje = dojenje;
    }
    public Long getMjePidPu() {
        return this.mjePidPu;
    }
    
    public void setMjePidPu(Long mjePidPu) {
        this.mjePidPu = mjePidPu;
    }
    public String getRadInozemstvo() {
        return this.radInozemstvo;
    }
    
    public void setRadInozemstvo(String radInozemstvo) {
        this.radInozemstvo = radInozemstvo;
    }
    public Boolean getProduzenoMo() {
        return this.produzenoMo;
    }
    
    public void setProduzenoMo(Boolean produzenoMo) {
        this.produzenoMo = produzenoMo;
    }
    public String getRazlogPovecaniStaz() {
        return this.razlogPovecaniStaz;
    }
    
    public void setRazlogPovecaniStaz(String razlogPovecaniStaz) {
        this.razlogPovecaniStaz = razlogPovecaniStaz;
    }
    public Set getRadnaJedinicas() {
        return this.radnaJedinicas;
    }
    
    public void setRadnaJedinicas(Set radnaJedinicas) {
        this.radnaJedinicas = radnaJedinicas;
    }




}



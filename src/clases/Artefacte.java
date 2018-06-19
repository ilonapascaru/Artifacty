package clases;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Artefacte {


    private String denumire;
    private String loc;
    private  String tip;
    private String rol;
    private int valoare;
    private String descriere;
    private String perioada_datata;


    public String getLoc() {
        return loc;
    }
    @XmlElement
    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getTip() {
        return tip;
    }
    @XmlElement
    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getRol() {
        return rol;
    }
    @XmlElement
    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPerioada_datata() {
        return perioada_datata;
    }
    @XmlElement
    public void setPerioada_datata(String perioada_datata) {
        this.perioada_datata = perioada_datata;
    }

    public String getDenumire() {
        return denumire;
    }
    @XmlElement
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }


    public int getValoare() {
        return valoare;
    }
    @XmlElement
    public void setValoare(int valoare) {
        this.valoare = valoare;
    }



    public String getDescriere() {
        return descriere;
    }
    @XmlElement
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }


}

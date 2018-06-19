package clases;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Localizari {
    private int id_loc;
    private String detalii;
    private String denumire;
    private String longitudine;
    private  String latitudine;

    public String getLongitudine() {
        return longitudine;
    }
    @XmlElement
    public void setLongitudine(String longitudine) {
        this.longitudine = longitudine;
    }

    public String getLatitudine() {
        return latitudine;
    }
    @XmlElement
    public void setLatitudine(String latitudine) {
        this.latitudine = latitudine;
    }

    public int getId_loc() {
        return id_loc;
    }
    @XmlElement
    public void setId_loc(int id_loc) {
        this.id_loc = id_loc;
    }

    public String getDetalii() {
        return detalii;
    }
    @XmlElement
    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }

    public String getDenumire() {
        return denumire;
    }
    @XmlElement
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    @Override
    public String toString() {
        return "Localizari{" +
                "id_loc=" + id_loc +
                ", detalii='" + detalii + '\'' +
                ", denumire='" + denumire + '\'' +
                '}';
    }
}

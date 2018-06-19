package clases;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tip {
    private int id_tip;
    private String detalii;
    private String denumire;

    public int getId_tip() {
        return id_tip;
    }
    @XmlElement
    public void setId_tip(int id_tip) {
        this.id_tip = id_tip;
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
        return "Tip{" +
                "id_rol=" + id_tip +
                ", detalii='" + detalii + '\'' +
                ", denumire='" + denumire + '\'' +
                '}';
    }
}

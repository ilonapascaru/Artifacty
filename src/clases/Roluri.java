package clases;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Roluri {

    private int id_rol;
    private String detalii;
    private String denumire;

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id_rol=" + id_rol +
                ", detalii='" + detalii + '\'' +
                ", denumire='" + denumire + '\'' +
                '}';
    }

}

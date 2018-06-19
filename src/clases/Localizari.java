package clases;

public class Localizari {
    private int id_loc;
    private String detalii;
    private String denumire;

    public int getId_loc() {
        return id_loc;
    }

    public void setId_loc(int id_loc) {
        this.id_loc = id_loc;
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
        return "Localizari{" +
                "id_loc=" + id_loc +
                ", detalii='" + detalii + '\'' +
                ", denumire='" + denumire + '\'' +
                '}';
    }
}

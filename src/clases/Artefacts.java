package clases;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Artefacts
{
    @XmlElement(name = "employee")
    private List<Artefacte> artefacte = new ArrayList<Artefacte>();

    public List<Artefacte> getArtefacte() {
        return artefacte;
    }

    public void setArtefacte(List<Artefacte> artefacte) {
        this.artefacte = artefacte;
    }
}

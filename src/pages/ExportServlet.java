package pages;

import clases.*;
import function.LogFunction;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static function.DatabaseFunction.*;
import static function.DatabaseFunction.closeConn;

import static function.DatabaseFunction.getConnection;

@WebServlet("/export")
public class ExportServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out= response.getWriter();
        Connection conn1 = null;
        try {
            String id1,id2,id3;
            id1=request.getParameter("getVal1");
            id2=request.getParameter("getVal2");
            id3=request.getParameter("getVal3");


            ArrayList<Artefacte> artefacts= new ArrayList<Artefacte>();

            conn1 = getConnection("artifacty");
            PreparedStatement statement = null;
            ResultSet rs;
            String sql = " select a.denumire, a.valoare, a.descriere, a.perioada_datata, b.denumire,c.denumire,d.denumire from `artifacty`.`artefacte` a \n" +
                    "         join `artifacty`.`localizari` b on a.id_loc=b.id_loc\n" +
                    "          join `artifacty`.`roluri` c on a.id_rol=c.id_rol\n" +
                    "           join `artifacty`.`tip` d on a.id_tip=d.id_tip\n" +
                    "where a.id_loc=? or a.id_rol=? or a.id_tip=?";
            statement = conn1.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(id1));
            statement.setInt(2, Integer.parseInt(id2));
            statement.setInt(3, Integer.parseInt(id3));
            rs = statement.executeQuery();

            File file = new File("C:\\Users\\ilona\\Desktop\\tw\\tw\\Artifacty\\fisier.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Artefacts.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            String xmlString=null;
            StringWriter sw = new StringWriter();

           //Artefacts artefacts1=new Artefacts();
           Artefacts artefacts1=new Artefacts();
            while (rs.next()) {
                Artefacte artefact=new Artefacte();
               artefact.setDenumire(rs.getString("a.denumire"));
            artefact.setLoc(rs.getString("b.denumire"));
            artefact.setRol(rs.getString("c.denumire"));
            artefact.setTip(rs.getString("d.denumire"));
            artefact.setValoare(rs.getInt("a.valoare"));
            artefact.setDescriere(rs.getString("a.descriere"));
            artefact.setPerioada_datata(rs.getString("a.perioada_datata"));

                jaxbMarshaller.marshal(artefact, file);
                jaxbMarshaller.marshal(artefact, sw);
                 xmlString = sw.toString();
            artefacts.add(artefact);
            }
        String ceva=request.getParameter("export");
            if(request.getParameter("export").equals("xml")) {
                out.println(xmlString);
            }


            if(request.getParameter("export").equals("json")) {
            //scriere obiect in json
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("C:\\Users\\ilona\\Desktop\\tw\\tw\\Artifacty\\fisier.json"), artefacts);
            String jsonInString = mapper.writeValueAsString(artefacts);
            System.out.println(jsonInString);
out.print(jsonInString);
           /* //citire obiect din json
            ObjectMapper mapper1 = new ObjectMapper();
            Artefacte ui2 = mapper.readValue(new File("C:\\Users\\ilona\\Desktop\\tw\\tw\\Artifacty\\fisier.xml"), Artefacte.class);
*/}

        } catch (Exception e) {
            e.printStackTrace();
        }


    closeConn(conn1);

}}


<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<!DOCTYPE html>
<html>
<head>
	<title>Artifacty</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script src="js/functions.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>



<!-- navbar -->
<div class="topnav" id="myTopnav">
  <a href="home.html" >Home</a>
  <a href="colectii.jsp"class="active">Colectii</a>
   <a href="import.jsp">Import</a>
  <a href="statistici.jsp">Statistici</a>
  <a href="contact.jsp">Contact</a>
  <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>

	

	<a class="topbar" href="login.jsp">Log in</a>
	<a class="topbar" href="register.jsp">Register</a>

</div>


<!-- Gallery -->


<div class="header">
  <h1>Colectii</h1>
</div>

<div class="row">

<div class="col-3 menu">
    <form action="/colectii" method="POST">
        <select name="localiz">
            <option value="Grecia Antica">Grecia Antica</option>
            <option value="Nepal">Nepal</option>
            <option value="Egipt">Egipt</option>
        </select>
        <input type="submit" name = "localizare" value="Dupa localizare" />
    </form>
    <form action="/colectii" method="POST">
        <select name="tip1">
            <option value="Arheologice">Arheologice</option>
            <option value="Preistorice">Preistorice</option>
            <option value="Obeliscuri">Obeliscuri</option>
        </select>
        <input type="submit" name = "tip" value="Dupa tip" />
    </form>
    <form action="/colectii" method="POST">
        <select name="rol1">
            <option value="Tehnic">Tehnic</option>
            <option value="Social">Social</option>
            <option value="Estetic">Estetic</option>
        </select>
        <input type="submit" name = "rol" value="Dupa rol" />
    </form>

    <h2>HTML Table</h2>

    <table>
        <tr>
            <th>DENUMIRE</th>
            <th>LOCALIZARE</th>
            <th>ROL</th>
            <th>TIP</th>
            <th>VALOARE</th>
            <th>DESCRIERE</th>
            <th>PERIOADA DATATA</th>
            <th>VEZI ARTEFACT</th>
        </tr>

<%
   session = request.getSession(true);
    Connection dbc = null;
    Class.forName("com.mysql.jdbc.Driver");
    dbc = DriverManager.getConnection("jdbc:mysql://localhost:3306/artifacty", "root", "root");

  int id1 =0,id2=0,id3=0;
    try {
        String colectii1=(String)request.getAttribute("localizare");
        if(colectii1!=null){
            PreparedStatement statement = null;
            ResultSet rs;
            String sql=" select id_loc ID from `artifacty`.`localizari` where denumire=?";
            statement= dbc.prepareStatement(sql);
            statement.setString(1, colectii1);
            rs=statement.executeQuery();
            while(rs.next()) {
                 id1 = rs.getInt("ID");
            }
            session.setAttribute("rol", id1);
        }

    String colectii2=(String)request.getAttribute("rol");
    if(colectii2!=null){
        PreparedStatement statement = null;
        ResultSet rs;
        String sql=" select id_rol ID from `artifacty`.`roluri` where denumire=?";
        statement= dbc.prepareStatement(sql);
        statement.setString(1, colectii2);
        rs=statement.executeQuery();
        while(rs.next()) {
            id2 = rs.getInt("ID");
            session.setAttribute("rol", id2);
        }

    }
    String colectii3=(String)request.getAttribute("tip");
    if(colectii3!=null){
        PreparedStatement statement = null;
        ResultSet rs;
        String sql=" select id_tip ID from `artifacty`.`tip` where denumire=?";
        statement= dbc.prepareStatement(sql);
        statement.setString(1, colectii3);
        rs=statement.executeQuery();
        while(rs.next()) {
            id3 = rs.getInt("ID");
            session.setAttribute("tip", id3);
        }
    }


    if (dbc != null)
    {
    System.out.println("Connection successful");
    }

        PreparedStatement statement = null;
        ResultSet rs;
        String sql = " select a.denumire, a.valoare, a.descriere, a.perioada_datata, b.denumire,c.denumire,d.denumire from `artifacty`.`artefacte` a \n" +
"         join `artifacty`.`localizari` b on a.id_loc=b.id_loc\n" +
"          join `artifacty`.`roluri` c on a.id_rol=c.id_rol\n" +
"           join `artifacty`.`tip` d on a.id_tip=d.id_tip\n" +
"where a.id_loc=? or a.id_rol=? or a.id_tip=?";
        statement = dbc.prepareStatement(sql);
        statement.setInt(1, id1);
        statement.setInt(2, id2);
        statement.setInt(3, id3);
        rs = statement.executeQuery();

    while (rs.next())
    {
    %>

        <tr>
            <td><%=rs.getString("a.denumire")%></td>
            <td><%=rs.getString("b.denumire")%></td>
            <td><%=rs.getString("c.denumire")%></td>
            <td><%=rs.getString("d.denumire")%></td>
            <td><%=rs.getInt("a.valoare")%></td>
            <td><%=rs.getString("a.descriere")%></td>
            <td><%=rs.getString("a.perioada_datata")%></td>
            <td><form action="/artefact" method="POST">
                <input type="hidden" name="getVal" value="<%=rs.getString("a.denumire")%>"/>
                <input type="submit"  value="GO" />
            </form></td>
        </tr>

    <% }
   %> <form action="/export" method="POST">



    <select name="export">
        <option value="xml">XML</option>
        <option value="json">JSON</option>
        <option value="csv">CSV</option>
    </select>
    <input type="hidden" name="getVal1" value="<%=id1%>"/>
    <input type="hidden" name="getVal2" value="<%=id2%>"/>
    <input type="hidden" name="getVal3" value="<%=id3%>"/>
    <input type="submit" name = "exp" value="Export" />
</form>
<% }catch (Exception e){
    e.printStackTrace();
}%>
</div>
</div>
</table>
</body>
</html>

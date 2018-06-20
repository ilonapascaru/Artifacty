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
  <a href="homeLI.jsp" >Home</a>
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

</div>
</div>


</body>
</html>

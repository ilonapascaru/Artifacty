<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.sql.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>

<%
    Gson gsonObj = new Gson();
    Map<Object,Object> map = null;
    List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
    //String dataPoints = null;

    try{
            Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/artifacty", "root", "root");
        Statement statement = connection.createStatement();
        String xVal, yVal;

        ResultSet resultSet = statement.executeQuery("select * from statistica where x='Egipt' or x='GreciaAntica' or x='Nepal'");

        while(resultSet.next()){
            xVal = resultSet.getString("x");
            yVal = resultSet.getString("y");


            map = new HashMap<Object,Object>();
            map.put("label", xVal);
            map.put("y", Double.parseDouble(yVal));
           // map.put("exploded", true);
            list.add(map);


        }
        connection.close();
    }
    catch(SQLException e){
        out.println("<div  style='width: 50%; margin-left: auto; margin-right: auto; margin-top: 200px;'>Could not connect to the database. Please check if you have mySQL Connector installed on the machine - if not, try installing the same.</div>");
        //dataPoints = null;
    }catch(Exception e) {
    e.printStackTrace();
    }
    String dataPoints = gsonObj.toJson(list);
%>



<!DOCTYPE html>
<html>


<head>

    <title>Artifacty</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script src="js/functions.js"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
        window.onload = function() {

            <% if(dataPoints != null) { %>
            var chart = new CanvasJS.Chart("chartContainer", {
                animationEnabled: true,
                exportEnabled: true,
                title: {
                    text: "Statistica dupa localizare: "
                },
                data: [{
                    type: "pie", //change type to bar, line, area, pie, etc
                    dataPoints: <%out.print(dataPoints);%>
                }]
            });
            chart.render();
            <% } %>

        }
    </script>




</head>
<body>



<!-- navbar -->
<div class="topnav" id="myTopnav">
    <a href="home.html" >Home</a>
    <a href="colectii.jsp">Colectii</a>
    <a href="import.jsp">Import</a>
    <a href="statistici.jsp" class="active">Statistici</a>
    <a href="contact.jsp">Contact</a>
    <a href="cauta.html">Cauta</a>
    <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>



    <a class="topbar" href="login.html">Log in</a>
    <a class="topbar" href="register.html">Register</a>

</div>

<div class="header">
    <h1>Statistici</h1>
</div>

<div class="col-3 menu">
    <ul>
        <a class="categorii" href="statistici.jsp"><li>Statistica dupa localizare</li></a>
        <a class="categorii" href="statistici2.jsp"><li>Statistica dupa tip</li></a>
        <a class="categorii" href="statistici3.jsp"><li>Statistica dupa rol</li></a>
    </ul>
</div>

<br><br><br>




<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>


</body>
</html>
<!DOCTYPE html>
<html>

<head>
    <title>Artifacty</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script src="js/functions.js"></script>
</head>
<body>



<!-- navbar -->
<div class="topnav" id="myTopnav">
    <a href="homeLI.jsp" >Home</a>
    <a href="colectii.jsp">Colectii</a>
    <a href="import.jsp">Import</a>
    <a href="statistici.jsp">Statistici</a>
    <a href="contact.jsp"class="active">Contact</a>
    <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>



    <a class="topbar" href="login.jsp">Log in</a>
    <a class="topbar" href="register.jsp">Register</a>

</div>

<div class="header">
    <h1>Contact</h1>
</div>

<form action="/contact" method="POST">

    <table class="register_table" align="center">

        <tr>
            <td colspan=2>
                <span><b>Trimite mesaj</b></span>
            </td>
        </tr>

        <tr>
            <td>Nume</td>
            <td>
                <input type="text" name="name" id="name" size="30">
            </td>
        </tr>

        <tr>
            <td>Email</td>
            <td>
                <input type="email" name="emailid" id="emailid" size="30">
            </td>

        </tr>

        <tr>
            <td>Mesaj</td>
            <td>
                <input type="text" name="mesaj" id="mesaj" size="30">
            </td>

            <td colspan="2">
                <input type="submit" value="Trimite" />
            </td>
        </tr>
    </table>
</form>

</article>






</body>
</html>
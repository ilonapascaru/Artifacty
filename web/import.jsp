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
    <a href="home.html" >Home</a>
    <a href="colectii.jsp">Colectii</a>
    <a href="import.jsp"class="active">Import</a>
    <a href="statistici.jsp">Statistici</a>
    <a href="contact.jsp">Contact</a>
    <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>



    <a class="topbar" href="login.html">Log in</a>
    <a class="topbar" href="register.html">Register</a>

</div>

<div class="header">
    <h1>Import</h1>
</div>

<div>
    <legend><em>Importa artefact:</em></legend>

    <form action="/insert" method="POST">

        <p>Localizare:</p>
        <ul><select name="localiz">
            <option value="Grecia Antica">Grecia Antica</option>
            <option value="Nepal">Nepal</option>
            <option value="Egipt">Egipt</option>
        </select>
        </ul>
        <p>Tip:</p>
        <ul><select name="tip1">
            <option value="Arheologice">Arheologice</option>
            <option value="Preistorice">Preistorice</option>
            <option value="Obeliscuri">Obeliscuri</option>
        </select>
        </ul>

        <p>Rol:</p>
        <ul><select name="rol">
            <option value="Tehnic">Tehnic</option>
            <option value="Social">Social</option>
            <option value="Estetic">Estetic</option>
        </select>
        </ul>

        <p>Tip datare:</p>
        <ul>
            <li><label for="dated">Datat</label> <input type="radio" name="tip" id="dated" value="dated"></li>
            <li><label for="undated">Nedatat</label> <input type="radio" name="tip" id="undated" value="undated"></li>
        </ul>

        <p>Secol:</p>
        <ul>
            <li><label for="ac">i.Hr.</label> <input type="radio" name="secol" id="ac" value="ac"></li>
            <li><label for="bc">d.Hr.</label> <input type="radio" name="secol" id="bc" value="bc"></li>
        </ul>
        <ul>
            <li><p>Valoare : </p> <input type="text" name="valoare" id="valoare" size="30"></li>
            <li><p>Denumire: </p> <input type="text" name="denumire" id="denumireid" size="30"></li>
            <li><p>Descriere: </p> <input type="text" name="descriere" id="descriereid" size="30"></li>
            <li><p>Link Imagine: </p> <input type="text" name="link" id="link" size="30"></li>
        </ul>




        <input class="browse" type="file" id="myFile"><br>
        <input type="submit" value="Submit" />




    </form>



</div>





</body>
</html>
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
    <a href="colectii.html">Colectii</a>
    <a href="import.jsp">Import</a>
    <a href="statistici.jsp" class="active">Statistici</a>
    <a href="contact.html">Contact</a>
    <a href="cauta.html">Cauta</a>
    <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>



    <a class="topbar" href="login.html">Log in</a>
    <a class="topbar" href="register.html">Register</a>

</div>

<div class="header">
    <h1>Statistici</h1>
</div>

<fieldset>
    <legend><em>Cauta artefact:</em></legend>

    <form action="/help1" method="POST">
        <p>Categorie:</p>
        <ul>
            <li><label for="parch">Localizare</label> <input type="radio" name="archeology" id="parch" value="parch"><select>
                <option value="volvo">Grecia Antica</option>
                <option value="saab">Nepal</option>
                <option value="mercedes">Egipt</option>
            </select></li>
            <li><label for="harch">Tip</label> <input type="radio" name="archeology" id="harch" value="harch"><select>
                <option value="volvo">Arheologice</option>
                <option value="saab">Preistorice</option>
                <option value="mercedes">Obeliscuri</option>
            </select></li>
            <li><label for="carch">Rol</label> <input type="radio" name="archeology" id="carch" value="carch"><select>
                <option value="volvo">Tehnic</option>
                <option value="saab">Social</option>
                <option value="mercedes">Estetic</option>
            </select></li>

        </ul>

        <p>Tip:</p>
        <ul>
            <li><label for="dated">Datat</label> <input type="radio" name="archeology" id="dated" value="dated"></li>
            <li><label for="undated">Nedatat</label> <input type="radio" name="archeology" id="undated" value="undated"></li>
        </ul>

        <p>Secol:</p>
        <ul>
            <li><label for="ac">i.Hr.</label> <input type="radio" name="year" id="ac" value="ac"></li>
            <li><label for="bc">d.Hr.</label> <input type="radio" name="year" id="bc" value="bc"></li>
        </ul>




        
        <input type="button" value="Export XML" />
		<br><br>
		<input type="button" value="Export JSON" />
        </select></li> </br>

        </ul>

    </form>
</fieldset>


</div>





</body>
</html>
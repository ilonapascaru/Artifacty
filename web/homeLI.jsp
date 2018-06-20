
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
  <a href="homeLI.jsp" class="active">Home</a>
  <a href="colectii.jsp">Colectii</a>
  <a href="import.jsp">Import</a>
  <a href="statistici.jsp">Statistici</a>
  <a href="contact.jsp">Contact</a>

  <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>

  <p align="right" style="color:white">Hello <%=request.getParameter("nume") %>!</p>


</div>

<div class="header">
  <h1>Home</h1>
</div>


<div id="demo">
  <h2>Welcome to our wonderful website!</h2>
  <button type="button" onclick="loadDoc()">More Info</button>
</div>

<script>

    function loadDoc() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("demo").innerHTML = this.responseText;
            }
        };
        xhttp.open("GET", "ajax_info.txt", true);
        xhttp.send();
    }

</script>






<footer>Copyright &copy; Proiect TW</footer>

</body>
</html>

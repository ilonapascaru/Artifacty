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
  <a href="home.html" class="active">Home</a>
  <a href="colectii.jsp">Colectii</a>
 <a href="import.jsp">Import</a>
  <a href="statistici.jsp">Statistici</a>
  <a href="contact.jsp">Contact</a>
  <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>

	

	<a class="topbar" href="login.jsp">Log in</a>
	<a class="topbar" href="register.jsp">Register</a>

</div>


<br><br>

<article>
          <form action="/register" method="POST">

              <table class="register_table" align="center">

                  <tr>
                      <td colspan=2>
                          <span><b>Registration Form</b></span>
                      </td>
                  </tr>
                  <tr>
                      <td>Username</td>
                      <td>
                          <input type="text" name="username" id="firstname" size="30">
                      </td>
                  </tr>

                  <tr>
                      <td>Password</td>
                      <td>
                          <input type="password" name="password" id="password" size="30">
                      </td>

                  </tr>

                  <tr>
                      <td>Repeat password</td>
                      <td>
                          <input type="password" name="password2" id="password2" size="30">
                      </td>
                  </tr>




                  <tr>
                      <td>Email</td>
                      <td>
                          <input type="text" name="email" id="emailid" size="30">
                      </td>
                  </tr>

				  
				  <tr>
                      <td>Interese</td>
                      <td>
                          <select name="interese">
							<option value="int1">Int1</option>
							<option value="int2">Int2</option>
							<option value="int3">Int3</option>
							<option value="int4">Int4</option>
						  </select>
                      </td>
                  </tr>
				  
                  <tr>
                      <td>
                          <input type="reset">
                      </td>
                      <td colspan="2">
                          <input type="submit" value="Submit Form" />
                      </td>
                  </tr>
              </table>
          </form>

        </article>

<br><br>
<br><br>
<br><br>
<%
    String register_msg1=(String)request.getAttribute("errorPass");
    if(register_msg1!=null)
        out.println("<font color=red size=3px>"+register_msg1+"</font>");
%>
<br><br>
<%
    String register_msg2=(String)request.getAttribute("errorEmail");
    if(register_msg2!=null)
        out.println("<font color=red size=3px>"+register_msg2+"</font>");
%>
<br><br>
<%
    String register_msg3=(String)request.getAttribute("errorUser");
    if(register_msg3!=null)
        out.println("<font color=red size=3px>"+register_msg3+"</font>");
%>

<br><br>
<%
    String register_msg4=(String)request.getAttribute("campGol");
    if(register_msg4!=null)
        out.println("<font color=red size=3px>"+register_msg4+"</font>");
%>



<footer>Copyright &copy; Proiect TW</footer>

</body>
</html>

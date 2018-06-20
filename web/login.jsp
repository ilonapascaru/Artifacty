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

	

	<a class="topbar" href="login.jsp">Log in</a>
	<a class="topbar" href="register.jsp">Register</a>
	
	





</div>
<article style="margin-top: 30px;">
          <form action="/login" method="POST">

              <table class="register_table" align="center">

                  <tr>
                      <td colspan=2>
                          <span><b>Log In</b></span>
                      </td>
                  </tr>

                  <tr>
                      <td>Email</td>
                      <td>
                          <input type="text" name="username" id="emailid" size="30">
                      </td>
                  </tr>

                  <tr>
                      <td>Password</td>
                      <td>
                          <input type="password" name="password" id="password" size="30">
                      </td>

                  </tr>

                  <tr>
                      <td>
                          <input type="reset">
                      </td>
                      <td colspan="2">
                          <input type="submit" value="Login">
                      </td>
                  </tr>
              </table>
          </form>

        </article>



<%
    String login_msg1=(String)request.getAttribute("error");
    if(login_msg1!=null)
        out.println("<font color=red size=3px>"+login_msg1+"</font>");
%>



</body>
</html>
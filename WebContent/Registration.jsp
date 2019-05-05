<style type="text/css">
tr
{
height: 40px;
}

</style>
<body>

<jsp:include page="Header.jsp"></jsp:include>



<center>
<h3>Registration</h3>

<font color='red'>
<%
String status=request.getParameter("status");
if(status!=null)
{
out.println(status);
}
 %>
<br/>
</font>
                <form action="RegistrationServlet" method="post">
                <table width="407" border="0" align="center">
                      <tr><td><font color='black'><b>First Name</b></font></td><td><font color='black'><input type="text" name="firstName" required></font></td></tr>
                      <tr><td><font color='black'><b>Last Name</b></font></td><td><font color='black'><input type="text" name="lastName" required></font></td></tr>
                      <tr><td><font color='black'><b>User Name</b></font></td><td><font color='black'><input type="text" name="userName" required></font></td></tr>
                      <tr><td><font color='black'><b>Password</b></font></td><td><font color='black'><input type="password" name="password" required></font></td></tr>
                      <tr><td><font color='black'><b>Confirm Password</b></font></td><td><font color='black'><input type="password" name="confirmPassword" required></td></tr>
                     <tr><td><input type="reset" value="Clear"></td><<td><input type="submit" value="Register"></td></tr>
                  </table>
   
   	</form>

    </body>
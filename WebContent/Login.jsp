<style type="text/css">
tr
{
height: 40px;
}

</style>
<jsp:include page="Header.jsp"></jsp:include>
<center>

<h3>&nbsp;&nbsp;Login Here</h3>		
<%
String status=request.getParameter("status");
if(status!=null)
{
	out.println("<font color='red' size='4'>"+status+"</font>");
}
%>

				
<form action="./LoginServlet" method="post">
							
						 <table width="407" border="0" align="center">
                      <tr><td><font color='black'><b>User Name</b></font></td><td><font color='black'><input type="text" name="userName" required></font></td></tr>
                      <tr><td><font color='black'><b>Password</b></font></td><td><font color='black'><input type="password" name="password" required></font></td></tr>
                     <tr><td><input type="reset" value="Clear"></td><<td><input type="submit" value="Login"></td></tr>
                  </table>	
							
							
						</form>
   
   
   </center>

</body>
</html>

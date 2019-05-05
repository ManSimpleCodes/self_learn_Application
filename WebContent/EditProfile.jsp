
<style type="text/css">
tr
{
height:40px;
}

td
{
width:120px;
color:black;
}

</style>

<jsp:include page="Header.jsp"></jsp:include>


<%@page import="com.sehw.beans.*" %>
<%@page import="java.util.*" %>
<%

HttpServletResponse httpResponse = (HttpServletResponse)response;

httpResponse.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
response.addHeader("Cache-Control", "post-check=0, pre-check=0");
httpResponse.setHeader("Pragma","no-cache"); 
httpResponse.setDateHeader ("Expires", 0); 

String uid=(String)session.getAttribute("uid");
if(uid==null)
{
	
	response.sendRedirect("Login.jsp?status=Please Enter UserName and Password");
	return ;
}

RegistrationBean rb=(RegistrationBean)session.getAttribute("profile");


%>

<center>
<form action="UpdateAction">
<h3 style="padding-left: 500px;"><a href="ChangePassword.jsp">Change Password</a></h3>

<font color='red' size='4'><b>
<%
String status=request.getParameter("status");
if(!status.equals("null"))
{
	out.println(status);
}
%>
</b></font>
<br>

<table>

<tr><td>User Name</td><td><input type="text" value="<%=rb.getUserName() %>" name="username" readonly></td></tr>
<tr><td>Current Password</td><td><input type="password" name="password" required></td></tr>

<tr><td>First Name</td><td><input type="text" value="<%=rb.getFirstName() %>" name="firstname" required></td></tr>
<tr><td>Last Name</td><td><input type="text" value="<%=rb.getLastName() %>" name="lastname" required ></td></tr>
<tr><td></td><td><input type="submit" value="Update"></td></tr>
</table>
</form>
</center>
  </body>
</html>

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
<script type="text/javascript">
function valid()
{
	if(document.myForm.newpass.value!=document.myForm.confirm.value)
		{
		alert("NewPassword and Confirm Password didn't Match");
		return false;
		}
	
	}

</script>
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


%>

<center>
<form action="ChangePasswordAction" onsubmit="return valid();" name="myForm">
<%
if(request.getParameter("status")!=null)
{
	out.println("<font color='red' size='4'>"+request.getParameter("status")+"</fotn>");
}

%>
<table style="width: 500px;">

<tr><td>Old Password</td><td><input type="password"  name="old" required></td></tr>
<tr><td>New Password</td><td><input type="password" name="newpass" required></td></tr>
<tr><td>Confirm Password</td><td><input type="password"  name="confirm" required ></td></tr>
<tr><td></td><td><input type="submit" value="Update"></td></tr>
</table>
</form>
</center>
  </body>
</html>
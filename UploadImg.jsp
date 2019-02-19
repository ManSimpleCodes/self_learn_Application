
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


%>

<center>
<form method="post" action="<%=request.getContextPath()%>/UploadImgServlet" enctype="multipart/form-data">
<%
if(request.getParameter("status")!=null)
{
	out.println("<font color='red' size='4'>"+request.getParameter("status")+"</fotn>");
}

%>
<table>
  <tr><td>Portrait Photo: </td>
                    <td><input type="file" name="photo" size="50"/></td></tr>
                    <tr><td><input type="submit" value="upload"></td></tr>
</table>
</form>
</center>
</body>
</html>
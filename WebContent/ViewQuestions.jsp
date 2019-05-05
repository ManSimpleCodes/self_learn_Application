<%@page import="java.util.*" %>
<%@page import="com.sehw.beans.*" %>
<%@page import="com.sehw.dao.*" %>
 <script type="text/javascript">
	
	function preventBack()
	{
	window.history.forward();
	}
	setTimeout("preventBack()",0);
	
	window.onload=function()
	{
	null
	};
	</script>
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


<style type="text/css">
tr
{
height:40px; 
}
th
{
	
color:orange;
background-color: lightyellow;
}
td
{
text-align:left;
color:black;

}

</style>

<jsp:include page="Header.jsp"></jsp:include>
<center>
<%
UserDAO dao=new UserDAO();
HashMap hm=(HashMap)session.getAttribute("hm");
if(hm.isEmpty())
{
	out.println("<font color='red'>Questions Not Uploaded</font>");
	
}
else
{
	%>
	<h3 style="padding-left: 400px; color: blue"><a href="ClearHistory">Clear History</a></h3>
	<table width="600"><tr><th>Question Id</th><th>Question</th><th>Status</th>
<%

for(int i=1;i<=hm.size();i++)
{
	Questions q=(Questions)hm.get(i);
	%>
	
	<tr><Td><%=q.getId() %></Td><td><%=q.getQuestion() %></td>
	<%
	String status=dao.checkQ(q.getId(),uid);
	if(status.equals("true"))
	{
	%>
	<td><input type="checkbox" onclick="return false;"  checked></td>
		
		<%
	}
	else
	{
%>
		<td><input type="checkbox" onclick="return false;"></td>
		<%
		
	}
	%>
	
	</tr>
	<%
}
%>
<tr>
</tr>
<form action="QuestionShow.jsp">
<tr><td>Select Question ID:</td><td><input type="number" name="qid" placeholder="Enter QuestionId" required></td></tr>
<tr><td></td><td><input type="submit" value="Submit"></td></tr>
</form>
</table>	
	<%
}
%>	
	
	</center>	
  </body>
</html>
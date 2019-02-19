<jsp:include page="Header.jsp"></jsp:include>
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
  </body>
</html>
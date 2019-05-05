<style type="text/css">
tr
{
height: 40px;
}

</style>
<jsp:include page="Header.jsp"></jsp:include>
<center>
<style type="text/css">
td
{
color: black;
width: 120px;
}
tr
{
height:100px;
}


</style>

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

String status=request.getParameter("status");
if(status!=null)
{
	out.println("<font color='red' size='4'>"+status+"</font>");
}


%>
<table width="500">
<form action="./UploadQuestions.jsp">
<tr><td>Select Type of Question</td><td><select name="type">
<option>Select Type of Question</option>
<option value="1">Create Numeric</option>
<option value="2">Create Multiple</option>
</select></td></tr>
<tr><td></td><td><input type="submit" value="Select"></td></tr>
</form>
</table>

<%
if(request.getParameter("type")!=null)
{
if(request.getParameter("type").equals("1"))
{
		
	%>
	<form action="UploadServlet">
	<table>
	<tr><Td>Question</Td><td><textarea rows="3" cols="30" name="question" required></textarea></td></tr>
	<tr><Td>Hint</Td><td><textarea rows="2" cols="30" name="hint" required></textarea></td></tr>
	<tr><Td>Answer</Td><td><textarea rows="2" cols="30" name="answer" required></textarea></td></tr>
	<tr><Td></Td><td><input type="submit" value="Upload"></td></tr>
	
	</table>
	
	</form>
		
	<%
	
}
else if(request.getParameter("type").equals("2"))
{
	%>
	
		%>
	<form action="UploadServlet1">
	<table>
	<tr><Td>Question</Td><td><textarea rows="3" cols="30" name="question" required></textarea></td></tr>
	<tr><Td>Hint</Td><td><textarea rows="2" cols="20" name="hint" required></textarea></td></tr>
	
	
	<tr><td>Option 1:</td><Td><input type="text" name="option1" required></Td></tr>
	<tr><td>Option 2:</td><Td><input type="text" name="option2" required></Td></tr>
	<tr><td>Option 3:</td><Td><input type="text" name="option3" required></Td></tr>
	<tr><td>Option 4:</td><Td><input type="text" name="option4" required></Td></tr>
	<tr><td>Answer</td><Td><select name="answer">
	<option>1</option>
	<option>2</option>
	<option>3</option>
	<option>4</option>
	</select>
	</Td></tr>
	<tr><Td></Td><td><input type="submit" value="Upload"></td></tr>
	</table>
	
	</form>
		
	<%
}
}
%>   
   </center>
</body>
</html>

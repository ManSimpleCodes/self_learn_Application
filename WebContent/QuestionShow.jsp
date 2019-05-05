<%@page import="com.sehw.dao.*" %>
<%@page import="com.sehw.beans.*" %>
<%@page import="java.util.*" %>
<jsp:include page="Header.jsp"></jsp:include>
<center>
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
<style type="text/css">
td
{
color:black;
}

tr
{
height: 40px;
}
</style>
		<script language="JavaScript"
			src="<%=request.getContextPath() + "/js/gen_validatorv4.js"%>"
			type="text/javascript">
		</script> 
<script type="text/javascript">
function valid()
{
	
	if(document.myForm.answer.value=="")
		{
		alert("Please Select Answer");
		return false;
		}
	
	}

</script>

	<%
	String hint="";

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

int id=Integer.parseInt(request.getParameter("qid"));

UserDAO dao=new UserDAO();
boolean id1 = dao.checkIDExisted(id);

if (id1 == false) {

	 out.println("<script type=\"text/javascript\">");
     out.println("alert('iPlease select id from above only');");
  	out.println("location='ViewQuestions.jsp';");
  	out.println("</script>");
}
else {
Questions q=dao.getQuestion(id);

	
if(q.getType().equals("N"))
{
%>
<table style="width: 500px;">
<%
if(request.getParameter("status")!=null)
{
String status=request.getParameter("status");
if(status.equals("true"))
{
	out.println("<font color='red' size='5'>Contragtulations  <a href='ViewQuestions.jsp'><button type='button' >Click here</button></a> to View Questions</font></br></br></br>");

}
else
{
	hint="hint";
	out.println("<font color='red' size='5'>You Entered Wrong answer check below Hint</font>");
}

}
%>

<form action="AnswerSubmit">
<input type="hidden" name="qid" value="<%=q.getId() %>">
<tr><td><font color='blue'><b>Question :</b></font></td><td><%=q.getQuestion() %></td></tr>
<tr><td>Answer :</td><td><textarea rows="3" cols="30" name="answer" required></textarea></td></tr>
<tr><td></td><td><input type="submit" value="Submit"></td></tr>
<%
if(hint.equals("hint"))
{
%>
<tr></tr>
<tr><td><font color='blue'>Hint:</font></td><td><%=q.getHint() %></td></tr>

<%
}
%>

</form>
</table>	
	<%
}
else if(q.getType().equals("M"))
{
	%>
	<table>
	<%
	if(request.getParameter("status")!=null)
	{
	String status=request.getParameter("status");
	if(status.equals("true"))
	{
		out.println("<font color='red' size='5'>Congratulations <a href='ViewQuestions.jsp'><button type='button' >Click here</button></a> to View Questions</font><br><br><br>");
	}
	else
	{
		hint="hint";
		out.println("<font color='red' size='5'>You Entered Wrong answer check below Hint</font>");
	}

	}
	%>
	<form action="AnswerSubmit" name="myForm" onsubmit="return valid();">
	<input type="hidden" name="qid" value="<%=q.getId() %>">
	<tr><td><font color='blue'><b>Question :</b></font></td><td><%=q.getQuestion() %></td></tr>
	<tr><td><input type="radio" name="answer" value="<%=q.getOption1()%>">&nbsp;&nbsp;&nbsp;&nbsp;Option 1 :</td><td><%=q.getOption1() %></td></tr>
	<tr><td><input type="radio" name="answer" value="<%=q.getOption2()%>">&nbsp;&nbsp;&nbsp;&nbsp;Option 2 :</td><td><%=q.getOption2() %></td></tr>
	<tr><td><input type="radio" name="answer" value="<%=q.getOption3()%>">&nbsp;&nbsp;&nbsp;&nbsp;Option 3 :</td><td><%=q.getOption3() %></td></tr>
	<tr><td><input type="radio" name="answer" value="<%=q.getOption4()%>">&nbsp;&nbsp;&nbsp;&nbsp;Option 4 :</td><td><%=q.getOption4() %></td></tr>
	<tr><td></td><td><input type="submit" value="Submit"></td></tr>
	<%
if(hint.equals("hint"))
{
%>
<tr></tr>
<tr><td><font color='blue'>Hint:</font></td><td><%=q.getHint() %></td></tr>
<%
}
%>
	
	</form>
	<script language="JavaScript" type="text/javascript">
		var regvalidator = new Validator("myForm");
		regvalidator.addValidation("answer","selone","Please select an option");
		</script>
	</table>	
		<%	
}
}
	%>
		
	</center>

  </body>
</html>
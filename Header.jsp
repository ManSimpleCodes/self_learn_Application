<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Self Learning Application</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet" />	
  </head>
  <body>
	<header>		
		<nav class="navbar navbar-default navbar-static-top" role="navigation">
			<div class="navigation">
				<div class="container">					
					<div class="navbar-header">
						<div class="navbar-brand">
							<a style="pointer-events: none; cursor: default;" href="index.jsp" ><h1><span>Self &nbsp;</span>Learning Application</h1></a>
						</div>
					</div>
					
					<div class="navbar-collapse collapse">							
						<div class="menu">
		<c:choose>
			<c:when test="${sessionScope.role=='USER'}">
				<jsp:include page="./UserMenu.jsp" />
			</c:when>
			
			<c:when test="${sessionScope.role eq null}">
				<jsp:include page="./Menu.jsp" />
			</c:when>
		</c:choose>
							
							
						</div>
					</div>						
				</div>
			</div>	
		</nav>		
	</header>
   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${department}</title>
</head>
<body>
	 <c:if test="${error}">
		<script >
		  alert("${errorStatement}");        
		</script>
		</c:if>

	<div id="wrapper">
			
		<div id="header">
		
			<!-- <h2>Welcome ${userName} to ${department}</h2> -->
		
		</div>
	</div>
		
	<div id="container">
		
		<h3>Insert Query:</h3>
	
		<form:form action="queryDatabase" modelAttribute="queryResult" method="POST">
			<textarea name="queryStatement" rows="10" cols="110" placeholder="End Queries with semicolon ';'"></textarea>
			<input type="submit" name="query" value="Query">
			<input type="submit" name="update" value="Update">
		</form:form>
		<form:form  method="GET">
			<div id="table" style="overflow-x:auto;">
				<table border="2">
				  <thead>
				    <tr>
				      <c:forEach items="${rows[0]}" var="column">
				        <td><c:out value="${column.key}" /></td>
				      </c:forEach>
				    </tr>
				  </thead>
				  <tbody>
				    <c:forEach items="${rows}" var="columns">
				      <tr>
				        <c:forEach items="${columns}" var="column">
				          <td><c:out value="${column.value}" /></td>
				        </c:forEach>
				      </tr>
				    </c:forEach>
				  </tbody>
				</table>
			</div>
		</form:form>
		<br>
		
		
	
		<a href="${pageContext.request.contextPath}">Return to login</a>
	</div>
</body>
</html>
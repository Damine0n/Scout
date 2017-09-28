<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MIF Dev Log-in</title>
</head>
<body>
		
		<div id = "wrapper">
		
			<div id = "header">
		
				<h2>MIF - Log-in</h2>
		
			</div>
		
		</div>
		
		<div id = "container">
		
			<div id= "content">

				<form action="processLogin" method="POST">
					Username:
					<input type="text" name="userName"
					placeholder="Enter UserName" />
					
					<br><br>
					
					Password:
					<input type="password" name="passWord"
					placeholder="Enter Password" />
					
					<br><br>
					
					Department:
					<select name="department">
						<option value = "QA/DEV" label="QA/DEV"/>
						<option value = "PROD" label="PROD"/>
					</select>
						
					<br><br>
					
					<input type="submit" />
				</form>
				
			</div>
		</div>

</body>
</html>
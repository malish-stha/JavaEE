<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World!!</h1>
	<form action="FirstServlet" method="POST">
	<label>Name:</label><br/>
	<input type="text" name="text1"/><br/>
	<label>Password:</label><br/>
	<input type="password" name="password1"/><br/>
	<input type="submit" value="submit"/>
	
	</form>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stylish Form</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .form-container {
        background-color: #fff;
        padding: 40px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
    }

    h1 {
        text-align: center;
        color: #333;
        margin-bottom: 24px;
        font-size: 24px;
    }

    label {
        font-size: 16px;
        color: #555;
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 8px 0 16px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 14px;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    .form-container p {
        text-align: center;
        margin-top: 16px;
        color: #777;
        font-size: 14px;
    }
</style>
</head>
<body>
	<div class="form-container">
		<h1>Hello World!!</h1>
		<form action="FirstServlet" method="POST">
			<label for="name">Name:</label><br/>
			<input type="text" id="name" name="text1" placeholder="Enter your name"/><br/>
			
			<label for="password">Password:</label><br/>
			<input type="password" id="password" name="password1" placeholder="Enter your password"/><br/>
			
			<input type="submit" value="Submit"/>
		</form>
	</div>
</body>
</html>

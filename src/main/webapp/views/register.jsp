<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
      
        background-size: cover;
        background-position: center;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .container {
        width: 400px;
        padding: 20px;
        background-color: rgba(255, 255, 255, 0.8);
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    h1 {
        text-align: center;
        margin-bottom: 20px;
    }
    form {
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    input[type="text"],
    input[type="password"],
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        background-color: #007bff;
        color: #fff;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Registration Form</h1>
        <form action="/register" method="post">
            Enter your name : <input type="text" name="name"><br>
            Enter your username : <input type="text" name="username"><br>
            Enter your password : <input type="password" name="password"><br>
            Enter your address : <input type="text" name="address"><br>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>

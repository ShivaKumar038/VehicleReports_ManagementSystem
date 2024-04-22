<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>File Upload Form</title>
</head>
<body>
    <h1>Upload a File</h1>
    <form method="POST" action="/upload" enctype="multipart/form-data">
        <input type="file" name="file" />
        <br/><br/>
        <input type="submit" value="Upload" />
    </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>index</title>
</head>
<body>
    <form action="/file/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="uploadFile" />
        <button type="submit">파일업로드</button>
    </form>
</body>
</html>
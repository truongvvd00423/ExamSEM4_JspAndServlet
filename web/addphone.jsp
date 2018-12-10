<%-- 
    Document   : addphone
    Created on : Dec 10, 2018, 9:07:40 AM
    Author     : badan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Phone</title>
    </head>
    <body>
        <h1>Add Phone</h1>
        <form action="PhoneServlet" method="post">
            Name: <input type="text" name="Name"><br>
            Brand: 
            <select name="Brand">
                <option value="Apple">Apple</option>
                <option value="Apple">SamSung</option>
                <option value="Apple">Nokia</option>
                <option value="Apple">Others</option>
            </select><br>
            Price: <input type="text" name="Price"><br>
            Description: <input type="text" name="Description"><br>
            <input type="submit" value="Add"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>

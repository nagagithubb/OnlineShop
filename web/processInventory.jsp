<%-- 
    Document   : processInventory
    Created on : Nov 10, 2019, 8:32:44 PM
    Author     : holah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Inventory Page!</h1>
        <%
            String loggedinUser = (String)request.getAttribute("user");
            out.println("Welcome User:  " + loggedinUser);            
        %>
        <form action="inventory_processServlet" method="post">
            Enter Search Text: <input type="text" name="searchtxt" value="" /><br/><br/>
            <input type="submit" value="Get" />
        </form>
    </body>
</html>

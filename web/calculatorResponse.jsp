<%-- 
    Document   : calculatorResponse
    Created on : Jan 31, 2016, 1:54:49 PM
    Author     : mcendrowski
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Response Page</title>
    </head>
    <body>
        <h1>Area of rectangle</h1>
        <p><h1><b>
            <%
                Object responseObj = request.getAttribute("myMsg");
                Object errObj = request.getAttribute("errorMsg");
                
                if(responseObj !=null){
                    out.println(responseObj.toString());
                }
                if(errObj !=null){
                    out.println(errObj.toString());
                }
                %>
                <b></h1></p>
    </body>
</html>

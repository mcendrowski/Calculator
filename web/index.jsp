<%-- 
    Document   : calculatorResponse
    Created on : Jan 31, 2016, 1:54:49 PM
    Author     : mcendrowski
--%>

<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Response Page</title>
    </head>
    <body>
        <%

            // Object responseObj = request.getAttribute("myMsg");
            // Object errObj = request.getAttribute("errorMsg");
            Object area = request.getAttribute("area");
            String length = ""+(Double)request.getAttribute("length");
            if (length==null || length.equals("null")){
                length="''";
            }
             String width = ""+(Double)request.getAttribute("width");
            if (width==null || width.equals("null")){
                width="''";
            }
           
            Object errObj = request.getAttribute("errorMsg");        

        %>

       
        <h1> Rectangle </h1>
        <form id="rectangleForm2" name="rectangleForm" method="POST" action="CalculatorController" >
             <input type="hidden" name="form" value="rectangle"/>
            <label> length: </label>            
            <input type='text' name='length' value=<%=length%> placeholder='input length'/> 
                   <p></p>
            <label> width: </label>            
            <input type="text" name="width" value=<%=width%> placeholder="input width"/> 
            <p></p>   
            <input type="submit" name="submit" value="Calculate rectangle area"/>
        </form>
        <h1>Area of rectangle: 
        
                <%
                    if (area != null) {
                        out.println(area.toString());
                    }
                    if (errObj != null) {
                        out.println(errObj.toString());
                    }
                %>
                </h1>
                <hr/>
           <%

            // Object responseObj = request.getAttribute("myMsg");
            // Object errObj = request.getAttribute("errorMsg");
            Object circleArea = request.getAttribute("circleArea");
            String radius = ""+(Double)request.getAttribute("radius");
            if (radius==null || radius.equals("null")){
                radius="''";
            }
           
           
            Object circleErrObj = request.getAttribute("circleErrorMsg");        

        %>

       
        <h1> Circle </h1>
        <form id="circleForm" name="circleForm" method="POST" action="CalculatorController" >
             <input type="hidden" name="form" value="circle"/>
            <label> radius: </label>            
            <input type='text' name='radius' value=<%=radius%> placeholder='input radius'/> 
                   <p></p>
             
            <input type="submit" name="submit" value="Calculate circle area"/>
        </form>
        <h1>Area of circle: 
        
                <%
                    if (circleArea != null) {
                        out.println(circleArea.toString());
                    }
                    if (errObj != null) {
                        out.println(circleErrObj.toString());
                    }
                %>
                </h1>
                <hr/>           
                
                
                    </body>
                    </html>

<%-- 
    Document   : calculate
    Created on : Nov. 4, 2020, 6:09:53 p.m.
    Author     : Mustafa Shubbar
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="beans.Grade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Grades</h1>
        <hr>
        <%
            // Getting the grades array list from the session
            ArrayList<Grade> grades = 
                (ArrayList<Grade>) session.getAttribute("grades-list");
            // Checking if the grade is null or 0
            if(grades==null || grades.size()==0) {
        %>
        <p>You did not select grades</p>
        <% } else { 
        %>
        <ul>
        <%
            // Looping through every object in the link list
            for(Grade g : grades) {
        %>
        <!-- Listing all the selected grades -->
        <li><%= g.getLetterDescription()%></li>
        <% } %>
        </ul>
        <% } %>
        
        <%
            // Declaring gpa as a DOuble and cast it from the session
            Double gpa = (Double)session.getAttribute("gpa");
            // Empty string
            String academicStanding = "";
            if(gpa<0) {
                gpa = 0.0;
            } else {
                if(gpa <4.00 && gpa >= 3.80){
                    academicStanding = "Sheridan Scholar";
                } else if(gpa < 3.79 && gpa > 3.50) {
                    academicStanding = "Honours";
                } else if(gpa <3.49 && gpa >= 2.00) {
                    academicStanding = "Good";
                } else if(gpa < 1.99 && gpa >=1.80) {
                    academicStanding = "Conditional Pass";
                } else if(gpa <1.79 && gpa >=1.20) {
                    academicStanding = "Academic Problem";
                } else if(gpa < 1.1 && gpa >=0.00) {
                    academicStanding = "Cannot Continue";
                }
            }
        %>
        
        <h3>GPA is <%= gpa.doubleValue() %></h3>
        <h3>Your Academic Standing is: <%= academicStanding %></h3>
        <a href="index.jsp">Start over</a>
        <!-- Clearing the session after showing the result -->
        <% session.invalidate(); %>
    </body>
</html>

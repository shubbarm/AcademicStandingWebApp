<%-- 
    Document   : index
    Created on : Nov. 4, 2020
    Author     : Mustafa Shubbar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sheridan Academic Standing Calculator</title>
    </head>
    <body>
        <h1>Sheridan Academic Standing Calculator</h1>
        <p>Progress through our program and eligibility for the diploma is
        dependent upon successful completion of ALL required program courses 
        in good Academic Standing. This calculator will let you know your
        Academic Standing based on the grades of your courses. You will need 
        to enter the grades for all the courses you took.</p>
        <p>Click Start to begin.</p>
        <form action="selectGrades.jsp" method="GET">
            <input type="submit" value="Start">
        </form>
        <p>See 
            <a href="http://trantor.sheridanc.on.ca/webct/general/archdept_policies/academic_guidelines.html" target="_blank">Academic guidelines</a>
         for details.</p>
    </body>
</html>

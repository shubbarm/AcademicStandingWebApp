<%-- 
    Document   : selectGrades
    Created on : Nov. 4, 2020
    Author     : Mustafa Shubbar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select Your Grades</title>
    </head>
    <body>
        <h1>Select your grades</h1>
        <hr><br>
        <form action="CalculateGradesServlet" method="GET">
            Course Grade: 
            <select name="grade">
                <option value="aPlus">A+ (90-100%)</option>
                <option value="a">A (80-89%)</option>
                <option value="bPlus">B+ (75-79%)</option>
                <option value="b">B (70-74%)</option>
                <option value="cPlus">C+ (65-69%)</option>
                <option value="c">C (60-64%)</option>
                <option value="d">D (50-59%)</option>
                <option value="f">F (0-49%)</option>
            </select>
            <br><br>
            <input type="submit" name="btnAction" value="Next">
            <input type="submit" name="btnAction" value="Done">
        </form>
        
    </body>
</html>

/*
 * Mustafa Shubbar
 * Assignment #2
 * A Servlet that serve the dynamic .jps pages
 */

import beans.Grade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mustafa Shubbar
 */

@WebServlet(urlPatterns = {"/CalculateGradesServlet"})
public class CalculateGradesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Getting the action from the submit button
        String btnAction = request.getParameter("btnAction");
        // New session
        HttpSession session = request.getSession();
        // A counter to use later that represents how many entiries from user's input
        int count = 0;
        // Declaring a new array list that take a session list after casting it
        ArrayList<Grade> grades = 
            (ArrayList<Grade>) session.getAttribute("grades-list");
        // Checking if the array list is null 
        if(grades==null) {
            grades = new ArrayList<Grade>();
        }
        // The user clicks on Next button
        if(btnAction.equals("Next")) {
            // New object of type Grade
            Grade grade = new Grade();
            // Deciding what to do with the option's value
            switch(request.getParameter("grade")){
                case "aPlus":
                    grade.setGradePoint(4.0);
                    grade.setLetterDescription("A+ (90-100%)");
                    break;
                case "a":
                    grade.setGradePoint(4.0);
                    grade.setLetterDescription("A (80-89%)");
                    break;
                case "bPlus":
                    grade.setGradePoint(3.5);
                    grade.setLetterDescription("B+ (75-79%)");
                    break;
                case "b":
                    grade.setGradePoint(3.0);
                    grade.setLetterDescription("B (70-74%)");
                    break;
                case "cPlus":
                    grade.setGradePoint(2.0);
                    grade.setLetterDescription("C+ (65-69%)");
                    break;
                case "c":
                    grade.setGradePoint(2.0);
                    grade.setLetterDescription("C (60-64%)");
                    break;
                case "d":
                    grade.setGradePoint(1.0);
                    grade.setLetterDescription("D (50-59%)");
                    break;
                case "f":
                    grade.setGradePoint(0.0);
                    grade.setLetterDescription("F (0-49%)");
                    break;
            }
            // Adding the new object to the arraylist
            grades.add(grade);
            // Adding the array list to the session
            session.setAttribute("grades-list", grades);
            // Redirect the user to the grades selection page again
            response.sendRedirect("selectGrades.jsp");
        // The user clicks on the Done button
        } else if(btnAction.equals("Done")){
            // Declaring and initializing the gpa as a starting point
            double gpa = 0;
            // looping through every object in the array list
            for(Grade g : grades) {
                // Calculating the total points 
                gpa+= g.getGradePoint();
                // Each loop means new count 
                count++;
            }
            // The GPA will be divided by the count of user's entries
            gpa/=count;
            // Rounding the result
            gpa = Math.round(gpa*100.0)/100.0;
            // Sending the resulted GPA to the session
            session.setAttribute("gpa", gpa);
            // Redirect the user to the result.jsp page
            response.sendRedirect("result.jsp");
        // Wrong entry    
        } else {
            // Redirect the user to the index page
            response.sendRedirect("index.jsp");
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

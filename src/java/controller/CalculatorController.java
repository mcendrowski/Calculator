/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CalculatorService;
import model.Rectangle;

/**
 *
 * @author mcendrowski
 */
@WebServlet(name = "CalculatorController", urlPatterns = {"/CalculatorController"})
public class CalculatorController extends HttpServlet {
private static final String RESULT_PAGE = "/index.jsp";
//private static final String RESULT_PAGE = "/index.jsp";
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
        response.setContentType("text/html;charset=UTF-8");
        
        
        try (PrintWriter out = response.getWriter()) {
            Double length = Double.parseDouble(request.getParameter("length"));
            Double width = Double.parseDouble(request.getParameter("width"));
            CalculatorService calc = new CalculatorService(new Rectangle(length,width));
            String area = ""+calc.calculateArea();
            
//            String responseMsg = "Hello " + name + ", isn't Java great!";
//            Map<String,Object> requestMap = new HashMap<>();
//            requestMap.put("myMsg", responseMsg);
//            requestMap.put("length", length);
//            requestMap.put("width", width);
            
//            request.setAttribute("myResponse",requestMap);
            
            
            request.setAttribute("length", length);
            request.setAttribute("width", width);
            request.setAttribute("area", area);

            RequestDispatcher view
                    = request.getRequestDispatcher(RESULT_PAGE);
            view.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMsg", e.getMessage());
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

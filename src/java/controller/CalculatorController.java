/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AreaStrategy;
import model.CalculatorService;
import model.Circle;
import model.MapOfFields;
import model.Rectangle;
import model.Triangle;

/**
 *
 * @author mcendrowski
 */
@WebServlet(name = "CalculatorController", urlPatterns = {"/CalculatorController"})
public class CalculatorController extends HttpServlet {

    private static final String RESULT_PAGE = "/index.jsp";
//    private Map<String,String> mapOfFields;

    public CalculatorController() {
        super();
        Map<String, Object> requestMap = new HashMap<>();
    }

    private Double length;
    private Double width;
    private Double area;
    private Double radius;
    private Double circleArea;
    private Double sideA;
    private Double sideB;
    private Double sideC;
    private Double triangleArea;

//    private Map<String, Double> requestMap = new HashMap<>();
//    
//    private  void updateRequestMap(){
//        this.requestMap.put("length",null);
//        this.requestMap.put("width",null);
//        this.requestMap.put("area",null);
//        this.requestMap.put("radius",null);
//        this.requestMap.put("circleArea",null);
//        this.requestMap.put("sideA",null);
//        this.requestMap.put("sideB",null);
//        this.requestMap.put("sideC",null);
//        this.requestMap.put("triangleArea",null);        
//        
//    }
    public static String getRESULT_PAGE() {
        return RESULT_PAGE;
    }



//private static final String RESULT_PAGE = "/index.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @param formName
     * @param areaStrategy
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    private void updateRectangleFields(HttpServletRequest request) {
        Double length = Double.parseDouble(request.getParameter("length"));
        this.length = length;
        Double width = Double.parseDouble(request.getParameter("width"));
        this.width = width;
        CalculatorService calc = new CalculatorService(new Rectangle(length, width));

        this.area = calc.calculateArea();
//        String area = "" + this.area;
    }

    private void updateCircleFields(HttpServletRequest request) {
        Double radius = Double.parseDouble(request.getParameter("radius"));
        this.radius = radius;
        CalculatorService calc = new CalculatorService(new Circle(radius));
        this.circleArea = calc.calculateArea();
//        String circleArea = "" + this.circleArea;
    }

    private void updateTriangleFields(HttpServletRequest request) {
        Double sideA = Double.parseDouble(request.getParameter("sideA"));
        this.sideA = sideA;
        Double sideB = Double.parseDouble(request.getParameter("sideB"));
        this.sideB = sideB;
        Double sideC = Double.parseDouble(request.getParameter("sideC"));
        this.sideC = sideC;
        CalculatorService calc = new CalculatorService(new Triangle(sideA, sideB, sideC));

        this.triangleArea = calc.calculateArea();
//        String triangleArea = "" + this.triangleArea;
    }

    private void updateRequest(HttpServletRequest request) {
        request.setAttribute("length", length);
        request.setAttribute("width", width);
        request.setAttribute("area", area);

        request.setAttribute("radius", radius);
        request.setAttribute("circleArea", circleArea);

        request.setAttribute("sideA", sideA);
        request.setAttribute("sideB", sideB);
        request.setAttribute("sideC", sideC);
        request.setAttribute("triangleArea", triangleArea);
    }



    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            switch (request.getParameter("form")) {
                case "rectangle":                    
                    updateRectangleFields(request);
                    break;
                case "circle":
                    updateCircleFields(request);
                    break;
                case "triangle":
                    updateTriangleFields(request);
                    break;
                default:
                    break;
            }
            updateRequest(request);
 

        } catch (Exception e) {
            request.setAttribute("errorMsg", e.getMessage());
        }
         RequestDispatcher view
                = request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
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

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
import model.AreaStrategy;
import model.CalculatorService;
import model.Circle;
import model.Rectangle;
import model.Triangle;

/**
 *
 * @author mcendrowski
 */
@WebServlet(name = "CalculatorController", urlPatterns = {"/CalculatorController"})
public class CalculatorController extends HttpServlet {

    private static final String RESULT_PAGE = "/index.jsp";
    private Double length;
    private Double width;
    private Double area;
    private Double radius;
    private Double circleArea;
    private Double sideA;
    private Double sideB;
    private Double sideC;
    private Double triangleArea;

    public static String getRESULT_PAGE() {
        return RESULT_PAGE;
    }

    public Double getLength() {
        return length;
    }

    public Double getWidth() {
        return width;
    }

    public Double getArea() {
        return area;
    }

    public Double getRadius() {
        return radius;
    }

    public Double getCircleArea() {
        return circleArea;
    }

    public Double getSideA() {
        return sideA;
    }

    public Double getSideB() {
        return sideB;
    }

    public Double getSideC() {
        return sideC;
    }

    public Double getTriangleArea() {
        return triangleArea;
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
//    public CalculatorController(){
//        super();
////        Rectangle r = new Rectangle();
////        CalculatorService calc = new CalculatorService();
////        calc.setAreaObject(r);
//    }
    public void processRectangleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Double length = Double.parseDouble(request.getParameter("length"));
        this.length = length;
        Double width = Double.parseDouble(request.getParameter("width"));
        this.width = width;
        CalculatorService calc = new CalculatorService(new Rectangle(length, width));

        this.area = calc.calculateArea();
        String area = "" + this.area;

        request.setAttribute("length", length);
        request.setAttribute("width", width);
        request.setAttribute("area", area);

        request.setAttribute("radius", this.radius);
         if (this.getCircleArea() == null) {
            request.setAttribute("circleArea", "");
        } else {
            request.setAttribute("circleArea", "" + this.getCircleArea());
        } 
         
        request.setAttribute("sideA", this.sideA);
        request.setAttribute("sideB", this.sideB);
        request.setAttribute("sideC", this.sideC);
        if (this.getTriangleArea() == null) {
            request.setAttribute("triangleArea", "");
        } else {
            request.setAttribute("triangleArea", "" + this.getTriangleArea());
        }
        

        RequestDispatcher view
                = request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }

    public void processCircleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Double radius = Double.parseDouble(request.getParameter("radius"));
        this.radius = radius;
        CalculatorService calc = new CalculatorService(new Circle(radius));
        this.circleArea = calc.calculateArea();

        request.setAttribute("radius", radius);

        request.setAttribute("circleArea", "" + circleArea);

        request.setAttribute("length", this.length);
        request.setAttribute("width", this.width);
        if (this.getArea() == null) {
            request.setAttribute("area", "");
        } else {
            request.setAttribute("area", "" + this.getArea());
        }
        
        request.setAttribute("sideA", this.sideA);
        request.setAttribute("sideB", this.sideB);
        request.setAttribute("sideC", this.sideC);
        if (this.getTriangleArea() == null) {
            request.setAttribute("triangleArea", "");
        } else {
            request.setAttribute("triangleArea", "" + this.getTriangleArea());
        }

        RequestDispatcher view
                = request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }
    
    public void processTriangleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Double sideA = Double.parseDouble(request.getParameter("sideA"));
        this.sideA = sideA;
        Double sideB = Double.parseDouble(request.getParameter("sideB"));
        this.sideB = sideB;
        Double sideC = Double.parseDouble(request.getParameter("sideC"));
        this.sideC = sideC;
        CalculatorService calc = new CalculatorService(new Triangle(sideA,sideB,sideC));

        this.triangleArea = calc.calculateArea();
        String triangleArea = "" + this.triangleArea;

        request.setAttribute("sideA", sideA);
        request.setAttribute("sideB", sideB);
        request.setAttribute("sideC", sideC);
        request.setAttribute("triangleArea", ""+this.triangleArea);
        
        request.setAttribute("length", this.length);
        request.setAttribute("width", this.width);
        if (this.getArea() == null) {
            request.setAttribute("area", "");
        } else {
            request.setAttribute("area", "" + this.getArea());
        }

        request.setAttribute("radius", this.radius);
         if (this.getCircleArea() == null) {
            request.setAttribute("circleArea", "");
        } else {
            request.setAttribute("circleArea", "" + this.getCircleArea());
        }    
         
         
        

        RequestDispatcher view
                = request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            if (request.getParameter("form").equals("rectangle")) {
                processRectangleRequest(request, response);
            } else if (request.getParameter("form").equals("circle")) {
                processCircleRequest(request, response);
            } else if (request.getParameter("form").equals("triangle")) {
                processTriangleRequest(request, response);
            }

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

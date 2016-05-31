/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Store.Item;
import service.ProductAdminService.ProductManager;

/**
 *
 * @author megha_000
 */
@WebServlet(name = "GetProductDetails", urlPatterns = {"/GetProductDetails"})
public class GetProductDetails extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetProductDeatils</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Get Product Details  </h1>");
            out.println("<form action=\"GetProductDetails\" method=\"post\">");
            out.println("<p>Item id : <input type=\"text\" name=\"itemid\"</p>");
            out.println("<p><input type=\"submit\" value=\"get Item\"</p>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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
        if(request.getParameter("productid") != null)
        {
            doPost(request,response);
        }
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
       // processRequest(request, response);
        String id=request.getParameter("itemid");
        if(id==null)
        {
            id=request.getParameter("productid");
        }
        Item myProduct = ProductManager.getProductByID(Integer.parseInt(id));
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ProductDeatils</title>");
            out.println("<link href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            
            out.println("");
            
            out.println("<h4> Product Name :"+myProduct.getProductName()+ "</h4>");
            out.println("<h1><img src=\"GetItemImage?id="+id +"\" width=\"300\" height =\"300\"  border=\"1\">  </h1>");
            out.println("<p> Details :"+myProduct.getProductDetails()+ "</p>");
            out.println("<p> Price :"+myProduct.getPrice()+ " Rs.</p>");
            out.println("<p> Quatity Available :"+myProduct.getProductQuantity()+ "</p>");
            out.println("<form action=\"index.jsp\" method=\"post\">");
            out.println("<input type=\"submit\" class=\"btn btn-success\" value=\"Go Back\"");
            out.println("</body>");
            out.println("</html>");
        }
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

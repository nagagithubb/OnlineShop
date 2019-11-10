
package com.servlet;

import com.service.Inventory;
import com.service.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class inventory_processServlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         PrintWriter out = response.getWriter();
         String searchtxt = request.getParameter("searchtxt");
         //Client code for consuming webservice will be written here
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/OnlineShop/online/shop")
                .path("searchInventory")
                .queryParam("searchtxt", searchtxt);                
        
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        Response res = invocationBuilder.get();
        
        if (res.getStatus() == 200) {        
            ArrayList<Inventory> data = res.readEntity(new GenericType<ArrayList<Inventory>>() {  });            
            out.println("--------Inventory Data--------");
            out.println("<br/>");            
            for(Inventory inv : data)
            {
            out.println(inv.getId());                
            out.println(inv.getBrand());
            out.println(inv.getModel());
            out.println(inv.getFunctions());
            out.println(inv.getQuantity());
            out.println("<br/>");
            out.println("<br/>");
            }
            
        } else {
            out.println("No Inventory data found!, Please check again!");
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

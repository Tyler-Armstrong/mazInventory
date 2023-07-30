/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Customer;
import service.CustomerService;

/**
 *
 * @author Tyler
 */
public class addWorkorderServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CustomerService cs = new CustomerService();
        
        List <Customer> customerList2 = cs.getAll(0, 0);
                
        request.setAttribute("allCustomersWorkorder", customerList2);
        
        getServletContext().getRequestDispatcher("/WEB-INF/addWorkorder.jsp").forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/addWorkorder.jsp").forward(request, response);
    }

    

}

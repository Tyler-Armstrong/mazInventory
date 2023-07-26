/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CustomerService;

/**
 *
 * @author Tyler
 */
public class addCustomerServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("addMessage", "");
        getServletContext().getRequestDispatcher("/WEB-INF/addCustomer.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CustomerService cs = new CustomerService();
        
        String action = request.getParameter("action");
        
        if (action.equals("addCustomer")) {
            String company = request.getParameter("addCompany");
            String IsVendor = request.getParameter("isVendorAdd");
            String address1 = request.getParameter("addAddress1");
            String address2 = request.getParameter("addAddress2");
            String city = request.getParameter("addCity");
            String province = request.getParameter("addProvince");
            String country = request.getParameter("addCountry");
            String postal = request.getParameter("addPostal");
            String email = request.getParameter("addEmail");
            String contact = request.getParameter("addContact");
            String phone = request.getParameter("addPhone");
            String extension = request.getParameter("addExtension");
            
            try {
                cs.add(company, address1, address2 , city, province, country, postal, email, contact, phone, extension, IsVendor);
                request.setAttribute("addMessage", "Customer Added");
            } catch (Exception ex) {
                request.setAttribute("addMessage", "Unable to add Customer");
            }
            
            
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/addCustomer.jsp").forward(request, response);
    }



}

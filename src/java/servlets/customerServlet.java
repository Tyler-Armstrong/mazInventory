/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import models.Customer;
import service.CustomerService;

/**
 *
 * @author Tyler
 */
public class customerServlet extends HttpServlet {

    //probably find a different way for pagenation 
    private final int pageSize = 40;
    int pageCustomer = 1;
    //int edit = 0;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //this is the value needed to check if display table or edit parameters 
        request.setAttribute("edit", 0);
        
        //pageCustomer = Integer.parseInt(request.getParameter("pageCustomer"));
        
        CustomerService cs = new CustomerService();
        
        List<Customer> allCustomers = cs.getAll(pageCustomer, pageSize);
        
        request.setAttribute("customers", allCustomers);
        
        
        System.out.println(allCustomers.toString());
        
        getServletContext().getRequestDispatcher("/WEB-INF/customer.jsp").forward(request, response);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CustomerService cs = new CustomerService();
        request.setAttribute("edit", 0);
        
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        
        
        
         List<Customer> allCustomers = cs.getAll(pageCustomer, pageSize);
         request.setAttribute("customers", allCustomers);
        
        if(action.equals("editCustomer") ) {
            request.setAttribute("edit", 1);
            
            String customerId = request.getParameter("pkValue");
            Customer updateCustomer = cs.findCustomer(customerId);
            request.setAttribute("updateCustomer", updateCustomer);
            
            allCustomers = cs.getAll(pageCustomer, pageSize);
            request.setAttribute("customers", allCustomers);
            
            
        }else if(action.equals("deleteCustomer")) {
            
            
            String pkValue = request.getParameter("pkValue");
            
            request.setAttribute("deleteMessage", "");
            try {
                cs.deleteCustomer(pkValue);
            } catch (Exception ex) {
                //Logger.getLogger(customerServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("deleteMessage", "Cannot delete user, has saved rental data");
            }
            allCustomers = cs.getAll(pageCustomer, pageSize);
            request.setAttribute("customers", allCustomers);
            
            
        } else if (action.equals("updateCustomer")) {
            String pkValue = request.getParameter("pkValue");
            String companyUpdate = request.getParameter("companyUpdate");
            String address1Update = request.getParameter("address1Update");
            String isVendorUpdate = request.getParameter("isVendorUpdate");
            String address2Update = request.getParameter("address2Update");
            String cityUpdate = request.getParameter("cityUpdate");
            String countryUpdate = request.getParameter("countryUpdate");
            String provinceUpdate = request.getParameter("provinceUpdate");
            String postalUpdate = request.getParameter("postalUpdate");
            String emailUpdate = request.getParameter("emailUpdate");
            String contactUpdate = request.getParameter("contactUpdate");
            String phoneUpdate = request.getParameter("phoneUpdate");
            String extensionUpdate = request.getParameter("extensionUpdate");
            
            //inventory.update(status, pkValue, description, od, pinCon, boxCon, id, length, location);
            
            cs.update(pkValue, companyUpdate, address1Update, address2Update, cityUpdate, provinceUpdate,
                    countryUpdate , postalUpdate, emailUpdate, contactUpdate, phoneUpdate, extensionUpdate, isVendorUpdate);
            
            request.setAttribute("edit", 0);
            
            allCustomers = cs.getAll(pageCustomer, pageSize);
            request.setAttribute("customers", allCustomers);
            
        } else if (action.equals("showCustomerVendor")) {
         
            String searchValue = request.getParameter("showType");
           // String showType = request.getParameter("showType");
           
           
            List<Customer> typeList =  cs.showCustomersAndVendors(searchValue);
            request.setAttribute("customers", typeList);
            
        }
        
        
        
        
        
        
        //these need to be placed there to reload the tables.
        
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/customer.jsp").forward(request, response);
    }




}

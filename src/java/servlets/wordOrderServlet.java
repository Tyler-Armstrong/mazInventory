
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Customer;
import models.Workorder;
import service.CustomerService;
import service.WorkorderItemService;
import service.WorkorderService;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate; 
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.WorkorderItem;

/**
 *
 * @author Tyler
 */
public class wordOrderServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        WorkorderService ws = new WorkorderService();
        request.setAttribute("editWorkorder", 0);
        WorkorderItemService items= new WorkorderItemService();
      
        List<Workorder> workorder = ws.getAll();
        
        //List<WorkorderItem> workorderItem = items.getAll();
        
        
                
        request.setAttribute("workorder", workorder);
        
        getServletContext().getRequestDispatcher("/WEB-INF/workorder.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("editWorkorder", 0);
        String action = request.getParameter("action");
        
        WorkorderService ws = new WorkorderService();
        
        CustomerService cs = new CustomerService();
        
        WorkorderItemService items= new WorkorderItemService();
      
        //may have to move
        
        
        if(action == null) {
            action = "";
        }
        
        switch (action) {
            
            
            case"createWorkorder":
                
                String customerAdd = request.getParameter("allCustomers");
                String dateOutAdd = request.getParameter("date_out");
                String dateDueAdd = request.getParameter("date_due");
                String authorizedByAdd = request.getParameter("authorizedBy");              
                String shippedCustomAdd = request.getParameter("shippedCustomAdd");
                String shippedWhereAdd = request.getParameter("shippedWhere");
                String commentAdd = request.getParameter("commentAdd");
                
                
                
       
           try {
               Workorder newWorkorder = ws.newWorkorder(customerAdd, dateOutAdd, dateDueAdd, authorizedByAdd, shippedCustomAdd, shippedWhereAdd, commentAdd);
               
           } catch (ParseException ex) {
               Logger.getLogger(addWorkorderServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
       
           
           
           List<Workorder> workorderCreate = ws.getAll();
        
        request.setAttribute("workorder", workorderCreate);
                
                getServletContext().getRequestDispatcher("/WEB-INF/workorder.jsp").forward(request, response);
              
            return;
            
            case"deleteItem":
                
                
                String itemPrimaryKey = request.getParameter("itemPrimaryKey");
                String workorderId = request.getParameter("workorderPrimaryKey");
                String anotherKey = request.getParameter("keys");
                Workorder deleteWorkorder = ws.findWorkorder(workorderId);
                //String test = request.getParameter("testing");
                items.deleteItemPk(anotherKey);
                
                //WorkorderItem removingItem =
        
            try {
                items.deleteItem(itemPrimaryKey, deleteWorkorder);
            } catch (Exception ex) {
                Logger.getLogger(wordOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                List <Customer> customerList2 = cs.getAll(0, 0);
                
                request.setAttribute("allCustomersWorkorder", customerList2);
                
                request.setAttribute("editWorkorder", 1);	
                
            request.setAttribute("editWorkorder", 1);
                String workorderPrimaryKey = request.getParameter("pkWorkorder");
                //Workorder deleteWorkorder = ws.findWorkorder(workorderPrimaryKey);
                
                Date date2 = deleteWorkorder.getDateOut();
                
                DateFormat date_format2 = new SimpleDateFormat("yyyy-MM-dd");
                
                String dateString2 = date_format2.format(date2);
                
                boolean greyed2 = deleteWorkorder.getShippedCustom();
                
                request.setAttribute("greyed", greyed2);
                
                request.setAttribute("dateString", dateString2);
                
                request.setAttribute("updateWorkorder", deleteWorkorder);
             
            getServletContext().getRequestDispatcher("/WEB-INF/workorder.jsp").forward(request, response);
             
            
                
            break;
            
            
            
            case"updateWorkorder":
                String editPkvalue = request.getParameter("EditpkValue");
                String customerId = request.getParameter("allCustomers");
                String editDateOut = request.getParameter("date_out");
                String editDateDue = request.getParameter("date_due");
                String editAuthorized = request.getParameter("authorizedUpdate");
                //needs to be converted to Boolean
                String shippedCustom = request.getParameter("shippedCustom");
                //if boolean true us this, else use the companies address.
                String shippedWhere = request.getParameter("shippedText");
                String revision = request.getParameter("revisionUpdate");
                String editComments = request.getParameter("commentsUpdate");
                String statusOpenUpdate = request.getParameter("revisionUpdate");
                //Workorder editWork = ws.findWorkorder(editPkvalue);
                
                Customer editCustomer = cs.findCustomer(customerId);
                boolean shipped;
                boolean status;
                
        
            
                /*
                if(shippedCustom.equals("customTrue")){
                boolean shippedTrue = true;    
                }else if (shippedCustom.equals("customFalse")) {
                shipped = false;
                }
                
                if(statusOpenUpdate.equals("open")) {
                status = true;
                }else if (statusOpenUpdate.equals("close")){
                status = false;
                }
                */
             try {   
                ws.update(editPkvalue, editDateOut, editDateDue, editAuthorized, shippedCustom, shippedWhere, revision, editComments, statusOpenUpdate, editCustomer);
            } catch (ParseException ex) {
                Logger.getLogger(wordOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
             List<Workorder> workorder = ws.getAll();
        
            request.setAttribute("workorder", workorder);
             
            getServletContext().getRequestDispatcher("/WEB-INF/workorder.jsp").forward(request, response);
                
                
            break;
  
            //has a edit page on the workorder.jsp that is hidden until clicked.
            case"editWorkorder":
                
                
                //the numbers are for paging on another page not needed here.
                List <Customer> customerList = cs.getAll(0, 0);
                
                request.setAttribute("allCustomersWorkorder", customerList);
                
                // Playing with some date stuffs probably wont need
                //////////////////////////////////////////////////
                //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                //LocalDateTime now = LocalDateTime.now();
                //request.setAttribute("todayDate", now);
                //////////////////////////////////////////////////
                request.setAttribute("editWorkorder", 1);
                workorderPrimaryKey = request.getParameter("pkWorkorder");
                Workorder updateWorkorder = ws.findWorkorder(workorderPrimaryKey);
                
                Date date = updateWorkorder.getDateOut();
                
                DateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
                
                String dateString = date_format.format(date);
                
                boolean greyed = updateWorkorder.getShippedCustom();
                
                request.setAttribute("greyed", greyed);
                
                request.setAttribute("dateString", dateString);
                
                request.setAttribute("updateWorkorder", updateWorkorder);
                
                getServletContext().getRequestDispatcher("/WEB-INF/workorder.jsp").forward(request, response);
            break;
            
            
            case"searchCompany":
      
                String searchCompany = request.getParameter("companySearch");
              
                List<Workorder> searchList = new ArrayList<>();
                
                List<Workorder> fullList = ws.getAll();
                
                for(int i = 0; i < fullList.size(); i++) {
                    
                    if(fullList.get(i).getCustomerId().getCompany().toUpperCase().startsWith(searchCompany.toUpperCase())) {
                        searchList.add(fullList.get(i));
                    }                   
                }
             request.setAttribute("workorder", searchList);
             
            getServletContext().getRequestDispatcher("/WEB-INF/workorder.jsp").forward(request, response);
            
            break;
            
            
        }
        List<Workorder> workorder = ws.getAll();
        
        request.setAttribute("workorder", workorder);
        getServletContext().getRequestDispatcher("/WEB-INF/workorder.jsp").forward(request, response);
    }
    
}

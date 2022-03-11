package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Inventory;
import service.InventoryService;


public class adminServlet extends HttpServlet {

    private final int pageSize = 20;
    int page = 1;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
            try {
                page = Integer.parseInt(request.getParameter("page"));
            } catch (Exception ex) {
                // not necessary to log exception since it is not important
            }
            
            InventoryService is = new InventoryService();
            
            List<Inventory> wholeInventory = is.getAll(page, pageSize);
            request.setAttribute("inventory", wholeInventory);
            
            
            double end = wholeInventory.size();
            request.setAttribute("end", end);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(adminServlet.class.getName()).log(Level.SEVERE, null, ex);
            // not necessary to log exception since it is not important
        }
        getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
            return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InventoryService inventory = new InventoryService();
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
            
    
            switch (action) {
                case "deleteItem":
                    String pkValueDel = request.getParameter("pkValue");
                    int keyValue = Integer.parseInt(pkValueDel);
                    inventory.delete(keyValue);
                    
                    request.setAttribute("message", "Item Deleted");
                    
                
                    
                    break;
                    
                case "editItem":
                    String status = request.getParameter("editStatus");
                    String pkValue = request.getParameter("pkValue");
                    //Inventory updateItem = new Inventory();
                    inventory.update(status, pkValue);
                    
                    
                    break;
                    
                case "searchSerial":
                    String serialSearch = request.getParameter("serialSearch");
                    List<Inventory> newList = new ArrayList<>();
                    
                    
                    List<Inventory> listy;
                    try {
                        listy = inventory.getAll(page, pageSize);
                        
                        for (int  i = 0; i < listy.size(); i++) {
                            
                            if(listy.get(i).getSerialNumber().toUpperCase().startsWith(serialSearch.toUpperCase()) ) {
                                newList.add(listy.get(i));
                            }
                            
                        }
                        
                        
                        request.setAttribute("inventory", newList);
                        
                        
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(adminServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
                    return;
                    
                    
                    
                case "reportAvailable":
                    List<Inventory> reportList = inventory.itemReport();
                    
                    response.setHeader("Content-Disposition","attachment;filename=Item_report.csv");
                    PrintWriter outItem = response.getWriter();
                    
                    outItem.write("Serial Number," + "Description ," + "OD    ," + "Pin Connection ," + 
                                  "Box Connection ," + "Id     ," + "Length ," + "Status " + "\n");
                    
                    for (Inventory reportInv : reportList) {
                        if(reportInv.getStatusName().equals("Available")) {
                            String serialReport = reportInv.getSerialNumber();
                            String descriptionReport = reportInv.getDescription();
                            String odReport = reportInv.getOd();
                            String pinReport = reportInv.getPinConnect();
                            String boxReport = reportInv.getBoxConnect();
                            String idReport = reportInv.getId();
                            String lengthReport = reportInv.getLength();
                            String statusReport = reportInv.getStatusName();
                            
                            outItem.write(serialReport + "," + descriptionReport + "," + odReport + "," + pinReport + "," 
                                          + boxReport + "," + idReport + "," + lengthReport + "," + statusReport + "\n" );
                            
                        }
                        
                    }
                    outItem.close();
                    
                    
                    break;
                    
            }
        
            
            try {
                List<Inventory> wholeInventory = inventory.getAll(page, pageSize);
                request.setAttribute("inventory", wholeInventory);
                double end = wholeInventory.size();
                request.setAttribute("end", end);
                getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
                return;
                
                
            } catch (SQLException ex) {
                Logger.getLogger(adminServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }

    
}


package servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.InventoryService;

public class addServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        getServletContext().getRequestDispatcher("/WEB-INF/addInventory.jsp").forward(request, response);
        return;
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        InventoryService inventory = new InventoryService();
        String serialNum = request.getParameter("serialNumberAdd");
        String description = request.getParameter("descriptionAdd");
        String od = request.getParameter("ODAdd");
        String pin = request.getParameter("pinAdd");
        String box = request.getParameter("boxAdd");
        String id = request.getParameter("idAdd");
        String length = request.getParameter("lengthAdd");
        String status = request.getParameter("statusAdd");
        String action = request.getParameter("action");
        
         
        try {    
        inventory.insert(serialNum, description, od, pin, box, id, length, status);
        request.setAttribute("message", "add Successful");
        }catch (Exception ex) {
            Logger.getLogger(addServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "Serial Number already Exists");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/addInventory.jsp").forward(request, response);
        return;
         
        
    }

    

}

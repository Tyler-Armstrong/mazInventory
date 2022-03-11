
package servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import service.AccountService;


public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            AccountService as = new AccountService();
            
            User user = as.login(username, password);
            
            if (user == null) {
                request.setAttribute("message", "Invalid login - Please Try Again.");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }
            
            HttpSession session = request.getSession();       
            session.setAttribute("username", username);
            response.sendRedirect("maz_admin");
            return;
        } catch (NoSuchAlgorithmException ex) {
            request.setAttribute("message", "Invalid login - Please Try Again.");
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

  

}

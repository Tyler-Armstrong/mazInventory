
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
        <link rel="stylesheet" href="style/styleLogin.css">
        <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
        <title>Admin Inventory</title>
    </head>
    <body>
        
        
        
        <h1>Inventory Manager</h1>
        
        <div class="whole">
            
        <div class ="butts">
        <a href="addInventory" class="btn btn-primary btn-lg">Add Item</a><br><br>
        </div>
        
        
        
            
            
        <div class="aboveTable">
               
        
            <header>
                <ul>
                <form method="POST" action="maz_admin">
                    <li> Serial Number : <input type="text" size="20" name="serialSearch" placeholder="Search Serial">
                    <input type="submit" value="Search"> <input type="hidden" name="action" value="searchSerial">
                    </li>
                </form>
            
                   <form method="POST" action="maz_admin">
                    <li>
                    <input type="submit" value ="RESET">
                    </li>
                </form> 
                    
                <form method="POST" action="maz_admin">
                    <li>
                    <input type="submit" value="Report Available"> <input type="hidden" name="action" value="reportAvailable">
                    </li>
                </form>
            
              
                    
                
               </ul>
          </header>                      
           </div>
           
            
            <div class="theTable">
            <table  style="width: 95%" cellpadding="5" cellwidth="9%" border="1" class="formtable"> 
                <tr>
                    <th>Serial Number</th>
                    <th>Description</th>
                    <th>OD</th>
                    <th>Pin Connection</th>
                    <th>Box Connection</th>
                    <th>ID</th>
                    <th>Length</th>
                    <th>Status</th>
                    <th>Edit Status</th>
                    <th>Delete</th>
                </tr>    
                
            <c:forEach var="inventory" items="${inventory}">
                <tr>
                    <td><c:out value="${inventory.serialNumber}"></c:out> </td>
                    <td><c:out value="${inventory.description}"></c:out> </td>
                    <td><c:out value="${inventory.od}"></c:out> </td>
                    <td><c:out value="${inventory.pinConnect}"></c:out> </td>
                    <td><c:out value="${inventory.boxConnect}"></c:out> </td>
                    <td><c:out value="${inventory.id}"></c:out> </td>
                    <td><c:out value="${inventory.length}"></c:out> </td>
                    
               <form method="POST" action ="maz_admin">    
                    <td><select name="editStatus" id="editStatus">
                    <option value="${inventory.statusName}" selected>${inventory.statusName}</option>
                <option value="Available">Available</option>
                <option value="Rented">Rented</option>
                <option value="Deactivated">Deactivated</option>
                    </select></td>
                        
                        
                  
                    
                
                    <td><button class="edt"><i class="fa fa-edit"></i></button></td>
                        <input type="hidden" name="action" value="editItem">
                        <input type="hidden" name="pkValue" value="${inventory.itemId}">
                </form>
                
                <form method="POST" action ="maz_admin">
                    <td><button class="del"><i class="fa fa-trash"></i></button></td>
                        <input type="hidden" name="action" value="deleteItem">
                        <input type="hidden" name="pkValue" value="${inventory.itemId}">
                </form>
                </tr>
            </c:forEach>
             </div>     
        </table>
        </div> 
        
        
    </body>
</html>

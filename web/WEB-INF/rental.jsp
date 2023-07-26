<%-- 
    Document   : rental
    Created on : May 14, 2023, 3:09:09 PM
    Author     : Tyler
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/navStyle.css">
        <link rel="stylesheet" href="style/styleRental.css">
        <title>Rental</title>
    </head>
    <body>
        <div class="nav">
  <input type="checkbox" id="nav-check">
  <div class="nav-header">
    <div class="nav-title">
      Mazz &emsp;&emsp;&emsp;&emsp; Rental
    </div>
      
  </div>
  
  <div class="nav-btn">
    <label for="nav-check">
      <span></span>
      <span></span>
      <span></span>
    </label>
  </div>
  
  <div class="nav-links">
    <a class="active" href="maz_admin"> Inventory</a>
  <a href="addInventory"> Add Inventory</a>
  <a href="customer"> Customer</a>
  <a href="addCustomer"> Add Customer</a>
  <a href="rental"> Rental</a>
  </div>
</div>
        
        
<div class="whole-table"> 
        
    
    
    
    <table  style="width: 95%" cellpadding="5" cellwidth="7%" border="1" class="formtable">
    
    <tr>
        <td><b>Serial Number</b></td>
        <td><b>Company</b></td>
        <td><b>Date Out</b></td>
        <td><b>Date Due</b></td>
        <td><b>Actual return Date</b></td>
    </tr>
<c:forEach var="rental" items="${rental}">
    <tr>
        <td><c:out value="${rental.inventory.serialNumber}"></c:out>   </td>
        <td><c:out value="${rental.customer.company}"></c:out>   </td>
        <td><c:out value="${rental.rentalPK.dateOut}"></c:out>   </td>
        <td><c:out value="${rental.dateDue}">.Date();</c:out></td>
        <td><c:out value="${rental.actualReturnDate}"></c:out></td>        
    </tr>    
</c:forEach>
            
    
    
    
    </table>     
        
        
        
</div>
      
        
    </body>
</html>

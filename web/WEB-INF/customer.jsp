
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <!DOCTYPE html>
<html lang="en">

<head> 
  <link rel="stylesheet" href="style/navStyle.css">
  <link rel="stylesheet" href="style/styleCustomer.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">        
        
  <title>Document</title>
</head>

<body>
    
  <div class="nav">
  <input type="checkbox" id="nav-check">
  <div class="nav-header">
    <div class="nav-title">
      Mazz &emsp;&emsp;&emsp;&emsp; Customer
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
  </div>
</div>
    <br><br><br><br> 
    
    

    <c:if test="${edit == 0}">
   
<div class="table-whole">
    <b>${deleteMessage}</b>
    
    <div class="submit-btn">
    <form action="customer" method="POST">
        <input type="radio" id="customer" value="customer" name="showType">
        <label for="customer">Customer</label>
        <input type="radio" id="vendor" value="vendor" name="showType">
        <label for="vendor">Vendor</label>
        <input type ="submit" value="Show">  
        <input type="hidden" name="action" value="showCustomerVendor">
    
    <div class ="reset-btn">
    </form> 
    <form action="customer" method="POST">
        <input type="submit" value="Reset">
        <input type="hidden" name="action" value="showAll">
    </form>
    </div>
    </div>
    <table  style="width: 95%" cellpadding="5" cellwidth="7%" border="1" class="formtable"> 
        <tr>
            <td><b>Company</b></td>
            <td><b>Customer/Vendor</b></td>
            <td><b>Address 1</b></td>
            <td><b>Address 2</b></td>
            <td><b>City</b></td>
            <td><b>Province</b></td>
            <td><b>Country</b></td>
            <td><b>Postal Code</b></td>
            <td><b>Email</b></td>
            <td><b>Contact</b></td>
            <td><b>Phone</b></td>
            <td><b>Extension</b></td>
            <td><b>Edit</b></td>
            <td><b>Delete</b></td>
               
        </tr>
        
        
        
<c:forEach var="customers" items="${customers}">
    
<tr>
    
    <td><c:out value="${customers.company}"></c:out> </td>
    
    <td><c:if test="${customers.isVendor == true}">
            Vendor           
        </c:if> 
            <c:if test="${customers.isVendor == false}">
            Customer         
        </c:if> 
    </td>
    
    
    <td><c:out value="${customers.address1}"></c:out> </td>
    <td><c:out value="${customers.address2}"></c:out> </td>
    <td><c:out value="${customers.city}"></c:out> </td>
    <td><c:out value="${customers.province}"></c:out> </td>
    <td><c:out value="${customers.country}"></c:out> </td>
    <td><c:out value="${customers.postalCode}"></c:out> </td>
    <td><c:out value="${customers.email}"></c:out> </td>
    <td><c:out value="${customers.contactList}"></c:out> </td>
    <td><c:out value="${customers.phone}"></c:out> </td>
    <td><c:out value="${customers.extension}"></c:out> </td>
    
<form method="POST" action="customer">
    <td><button class="edt"><i class="fa fa-edit"></i></button></td>
        <input type="hidden" name="action" value="editCustomer">
        <input type="hidden" name="pkValue" value="${customers.customerId}">
</form>
    
<form method="POST" action ="customer">
    <td><button class="del"><i class="fa fa-trash"></i></button></td>
        <input type="hidden" name="action" value="deleteCustomer">
        <input type="hidden" name="pkValue" value="${customers.customerId}">
</form>   
    
</tr>          
</c:forEach>   
</table>
  </div>
    </c:if>
    
    <c:if test="${edit == 1}">
        <h2> Edit </h2>
        <div class="edit">
            
        <form method="POST" action="customer">
            Company:
             <br>
            <input type="text" id="companyUpdate" name="companyUpdate" value="${updateCustomer.company}">
            <br>
            Customer / Vendor:
             <br>
            <input type="radio" id="vendor" name="isVendorUpdate" value="vendor" required <c:if test="${updateCustomer.isVendor == true}"> checked</c:if> >
        <label for="vendor">Vendor</label>
        <input type="radio" id="customer" name="isVendorUpdate" value="customer" <c:if test="${updateCustomer.isVendor == false}"> checked</c:if> >
        <label for="customer">Customer</label>
            <br>
            Address 1:
             <br>
            <input type="text" id="address1Update" name="address1Update" value="${updateCustomer.address1}">
            <br>
            Address 2:
             <br>
            <input type="text" id="address2Update" name="address2Update" value="${updateCustomer.address2}">
            <br>
            City:
             <br>
            <input type="text" id="cityUpdate" name="cityUpdate" value="${updateCustomer.city}">
            <br>
            Province:
             <br>
            <input type="text" id="provinceUpdate" name="provinceUpdate" value="${updateCustomer.province}">
            <br>
            Country:
             <br>
            <input type="text" id="provinceUpdate" name="countryUpdate" value="${updateCustomer.country}">
            <br>
            Postal Code:
             <br>
            <input type="text" id="postalUpdate" name="postalUpdate" value="${updateCustomer.postalCode}">
            <br>
            Email:
             <br>
            <input type="text" id="emailUpdate" name="emailUpdate" value="${updateCustomer.email}">
            <br>
            Contact Name:
             <br>
            <input type="text" id="contactUpdate" name="contactUpdate" value="${updateCustomer.contactList}">
            <br>
            Phone:
             <br>
            <input type="text" id="phoneUpdate" name="phoneUpdate" value="${updateCustomer.phone}" >
            <br>
            Extension:
             <br>
            <input type="text" id="extensionUpdate" name="extensionUpdate" value="${updateCustomer.extension}">        
            <br><br>
            
            <button class="button button1">Update</button>
            
            <input type="hidden" name="action" value="updateCustomer">
            <input type="hidden" name="pkValue" value="${updateCustomer.customerId}">
            
            
        </form>     
        </div>
    </c:if>
    
    
</body>

</html>

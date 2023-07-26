<%-- 
    Document   : addCustomer
    Created on : May 7, 2023, 5:15:18 AM
    Author     : Tyler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/navStyle.css">
        <link rel="stylesheet" href="style/styleAddCustomer.css">
        
        <title>Add customer</title>
    </head>
    <body>
    <div class="nav">
  <input type="checkbox" id="nav-check">
  <div class="nav-header">
    <div class="nav-title">
      Mazz &emsp;&emsp;&emsp;&emsp; Add Customer
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
        <div class="message"><b>${addMessage}</b></div>
        
<div class="container">
    
    <form method="POST" action="addCustomer">
        
        <label for="addCompany">Company:</label>
        <input type="text" name="addCompany" id="addCompany" required><br><br>
        
        <input type="radio" id="vendor" name="isVendorAdd" value="vendor" required>
        <label for="vendor">Vendor</label>
        <input type="radio" id="customer" name="isVendorAdd" value="customer">
        <label for="customer">Customer</label>
        <br><br>
               
        <label for="addAddress1">Address 1:</label>
        <input type="text" name="addAddress1" id="addAddress1" required><br><br>
        
        <label for="addAddress2">Address 2:</label>
        <input type="text" name="addAddress2" id="addAddress2"><br><br>
        
        <label for="addCity">City:</label>
        <input type="text" name="addCity" id="addCity" required><br><br>
        
        <label for="addProvince">Province/State:</label>
        <input type="text" name="addProvince" id="addProvince" required><br><br>
        
        <label for="addCountry">Country:</label>
        <input type="text" name="addCountry" id="addCountry" required><br><br>
        
        <label for="addPostal">Postal Code:</label>
        <input type="text" name="addPostal" id="addPostal" required><br><br>
        
        <label for="addEmail">Email:</label>
        <input type="text" name="addEmail" id="addEmail" required><br><br>
        
        <label for="addContact">Contact:</label>
        <input type="text" name="addContact" id="addContact" ><br><br>
        
        <label for="addPhone">Phone:</label>
        <input type="text" name="addPhone" id="addPhone" required><br><br>
        
        <label for="addExtension">Extension:</label>
        <input type="text" name="addExtension" id="addExtension"><br><br>
        
        <input type="submit" value="Add Customer">
         <input type="hidden" name="action" value="addCustomer">
        
    </form>       
</div>
        
        
       
    </body>
</html>

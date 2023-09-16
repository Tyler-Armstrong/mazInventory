<%-- 
    Document   : addWorkorder
    Created on : Jul 30, 2023, 8:10:00 AM
    Author     : Tyler
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/navStyle.css">
        <link rel="stylesheet" href="style/styleAddWorkorder.css">
        <title>Add Work Order</title>
        
        <script>
            function greyedOut(value) {
                if (value == 1){
                    document.getElementById("shippedWhere").disabled = false;
                    document.getElementById("shippedWhere").required = true;
                    
                } else {
                    document.getElementById("shippedWhere").disabled = true;
                    document.getElementById("shippedWhere").required = false;
                }
            }
            function startUp(){
                //var disabled = document.getElementById("")
            }
            
        </script>
        
        
    </head>
    <body>
        
        <div class="wholePage">
        <h1>Add Work Order</h1>
        
        <div class="wholeForm">
        <br>
        Customer:
        <br>
        <form method="post" action="workorder">
            
        <select name="allCustomers" id="allCustomers" onchange="document.submit();">
                       
            <c:forEach var="allCustomersWorkorder" items="${allCustomersWorkorder}">
                <option value="${allCustomersWorkorder.customerId}">${allCustomersWorkorder.company} </option>
                            
             </c:forEach>
                            
        </select>
        <br>
        Job# or PO#:
        <br>
        <input type="text" id="addWorkorderNumber" name="addWorkorderNumber" required>
        <br>
        Quote#:
        <br>
        <input type="text" id="addQuoteNumber" name="addWorkorderNumber" required>
        
        <br>
        Date Ordered:
        <br>
        <input type="date" id="date_out" name="date_out" required>
        <br>
        Date Shipped:
        <br>
        <input type="date" id="date_due" name="date_due" required>
        <br>
        Authorized By:
        <br>
        <input type="text" id="authorizedBy" name="authorizedBy" required>
        <br>
        Shipped Custom:
        <br>
        <input type="radio" id="shippedCustomTrueAdd" name="shippedCustomAdd" value="customTrue" onclick="greyedOut(1)" required>
        <label for="shippedCustomTrueAdd">Custom Shipped</label>
        <br>    
        <input type="radio" id="shippedCustomFalseAdd" name="shippedCustomAdd" value="customFalse" onclick="greyedOut(0)"> 
        <label for="shippedCustomTrueAdd">Custom Head office</label>
        <br>
        Shipped Where:
        <br>
        <input type="text" id="shippedWhere" name="shippedWhere"> 
        <br>
        Comments:
        <br>
        <input type="text" id="commentAdd" name="commentAdd">
        <br>
        Rig Number:
        <br>
        <input type="text" id="addRigNumber" name="addRigNumber">
        <br>
        Oil Company:
        <br>
        <input type="text" id="addOilCompany" name="addOilCompany">
        <br>
        
        <div class="submitLast">
        <input type="submit" value="Create Work Order">
        <input type="hidden" name="action" value="createWorkorder">
        </div>
        
        </form>       
        </div>
        
        </div>
    </body>
</html>

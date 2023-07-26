
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
        <link rel="stylesheet" href="style/navStyle.css">
        <link rel="stylesheet" href="style/styleLogin.css">
       
        <title>Admin Inventory</title>
    </head>
    <body>
        <div class="nav">
  <input type="checkbox" id="nav-check">
  <div class="nav-header">
    <div class="nav-title">
      Mazz &emsp;&emsp;&emsp;&emsp; Inventory
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
        
        
        
        
        <div class="whole">
           
      
            
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
                        <input type="submit" value ="RESET" style="margin-right:70px;">
                    </li>
                </form> 
                    
                    
                   
                    
                    <div class="reportStyle">
                 
                <form method="POST" action="maz_admin">
                    
                    <input type="submit" value="Report Available" style="float: left;"> <input type="hidden" name="action" value="reportAvailable">
                    
                </form>
                       
                    <form method="POST" action="maz_admin" >
                        
                            <input type="submit" value="Report Rented" style="float: left;"> <input type="hidden" name="action" value="reportRent">
                        
                    </form>    
                    
                       
                    <form method="POST" action="maz_admin" >
                        
                        <input type="submit" value="Report All" style="float:left;" > <input type="hidden" name="action" value="reportAll">
                     </form>
                        
                   </div>
                    
                    
                    <div class ='orderBy'>    
                    <form method="POST" action="maz_admin">
                        
                        <label for="searchDescription">Order By:</label>
                        <select name="searchDescription" id="searchDescription" required>
                            
                <option selected disabled>Select Description</option>               
                <option value="NM Slick Collar">NM Slick Collar</option>
                <option value="NM Flex Collar">NM Flex Collar</option>
                <option value="NM Slick Pony">NM Slick Pony</option>
                <option value="NM Flex Pony">NM Flex Pony</option>
                <option value="NM Stabilizer">NM Stabilizer</option>
                <option value="NM Saver Sub">NM Saver Sub</option>
                <option value="NM Cross Over">NM Cross Over</option>
                <option value="NM Float Sub">NM Float Sub</option>
                <option value="NM Brine Slick Collar">NM Brine Slick Collar</option>
                <option value="NM Brine Flex Collar">NM Brine Flex Collar</option>
                <option value="NM Brine Slick Pony">NM Brine Slick Pony</option>
                <option value="NM Brine Flex Pony">NM Brine Flex Pony</option>
                <option value="Jar">Jar</option>
                <option value="Jar Pony">Jar Pony</option>
                <option value="Shock Sub">Shock Sub</option>
                <option value="Steel Stabilizer">Steel Stabilizer</option>
                <option value="Steel Cross Over Sub">Steel Cross Over Sub</option>
                <option value="Pickup Sub">Pickup Sub</option>
                <option value="TAL Dampener">TAL Dampener</option>
                <option value="Steel Saver Sub">Steel Saver Sub</option>
                <option value="Reamer">Reamer</option>
                <option value="Tapered Blade Reamer">Tapered Blade Reamer</option>
                <option value="Sub Basket">Sub Basket</option>
                <option value="Fin Cutter Sub">Fin Cutter Sub</option>
                <option value="Filter Sub">Filter Sub</option>
                <option value="NM Filter Sub">NM Filter Sub</option>
                <option value="Filter Screen">Filter Screen</option>
                
            </select>
                        
                        <input type ="submit" value="Sort">
                        <input type="hidden" name="action" value="descriptionOrder">
                        
                    </form>
                        </div>
                    
            </div>
                 
                
               </ul>
          </header>                      
           </div>
           
            
            <div class="theTable">
            <table  style="width: 95%" cellpadding="5" cellwidth="7%" border="1" class="formtable"> 
                <tr>
                    <th>Serial Number</th>
                    <th>Description</th>
                    <th>OD</th>
                    <th>Pin Connection</th>
                    <th>Box Connection</th>
                    <th>ID</th>
                    <th>Length (Meters)</th>
                    <th>Status</th>
                    <th>Location</th>
                    <th>Edit Row</th>
                    <th>Delete</th>
                </tr>    
                
            <c:forEach var="inventory" items="${inventory}">
                <tr>
                     
                    <td><c:out value="${inventory.serialNumber}"></c:out> </td>
                    
        <form method="POST" action ="maz_admin">                       
                        
                   
                    
                    <td>
                        <select name="editDescription" id="editDescription" required>
                <option value="${inventory.description}" selected>${inventory.description}</option>               
                <option value="NM Slick Collar">NM Slick Collar</option>
                <option value="NM Flex Collar">NM Flex Collar</option>
                <option value="NM Slick Pony">NM Slick Pony</option>
                <option value="NM Flex Pony">NM Flex Pony</option>
                <option value="NM Stabilizer">NM Stabilizer</option>
                <option value="NM Saver Sub">NM Saver Sub</option>
                <option value="NM Cross Over">NM Cross Over</option>
                <option value="NM Float Sub">NM Float Sub</option>
                <option value="NM Brine Slick Collar">NM Brine Slick Collar</option>
                <option value="NM Brine Flex Collar">NM Brine Flex Collar</option>
                <option value="NM Brine Slick Pony">NM Brine Slick Pony</option>
                <option value="NM Brine Flex Pony">NM Brine Flex Pony</option>
                <option value="Jar">Jar</option>
                <option value="Jar Pony">Jar Pony</option>
                <option value="Shock Sub">Shock Sub</option>
                <option value="Steel Stabilizer">Steel Stabilizer</option>
                <option value="Steel Cross Over Sub">Steel Cross Over Sub</option>
                <option value="Pickup Sub">Pickup Sub</option>
                <option value="TAL Dampener">TAL Dampener</option>
                <option value="Steel Saver Sub">Steel Saver Sub</option>
                <option value="Reamer">Reamer</option>
                <option value="Tapered Blade Reamer">Tapered Blade Reamer</option>
                <option value="Sub Basket">Sub Basket</option>
                <option value="Fin Cutter Sub">Fin Cutter Sub</option>
                <option value="Filter Sub">Filter Sub</option>
                <option value="NM Filter Sub">NM Filter Sub</option>
                <option value="Filter Screen">Filter Screen</option>
            </select>
                    </td>                  
                    
                    
                    <td>  
                   <select name="editOD" id="editOD" required>
                <option value="${inventory.od}" selected>${inventory.od}</option>
                <option value="3 1/2">3 1/2"</option>
                <option value="4 3/4">4 3/4"</option>
                <option value="5">5"</option>
                <option value="5 1/4">5 1/4"</option>
                <option value="5 1/2">5 1/2"</option>
                <option value="5 7/8">5 7/8"</option>
                <option value="6">6"</option>
                <option value="6 1/4">6 1/4"</option>
                <option value="6 1/2">6 1/2"</option>
                <option value="6 3/4">6 3/4"</option>
                <option value="7">7"</option>
                <option value="8">8"</option>
                <option value="8 1/4">8 1/4"</option>
                <option value="8 3/8">8 3/8"</option>
                <option value="8 1/2">8 1/2"</option>
                <option value="8 3/4">8 3/4"</option>
                <option value="9">9"</option>
                <option value="9 1/2">9 1/2"</option>
                
                
                   </select>
                    </td>
                    
                    
                    <td>                     
            <select name="editPin" id="editPin" required>
                <option value="${inventory.pinConnect}" selected>${inventory.pinConnect}</option>
                <option value="3 1/2 IF">3 1/2 IF</option>
                <option value="4 FH">4 FH</option>
                <option value="4 1/2 XH">4 1/2 XH</option>
                <option value="4 1/2 IF">4 1/2 IF</option>
                <option value="5 1/2 FH">5 1/2 FH</option>
                <option value="6 5/8 REG">6 5/8 REG</option>
                <option value="7 5/8 REG">7 5/8 REG</option>
                <option value="DS38">DS38</option>
                <option value="DS40">DS40</option>
                <option value="XT39">XT39</option>
                <option value="XT40">XT40</option>
                <option value="CET43">CET43</option>
                <option value="HT55">HT55</option>
                <option value="2 7/8 PH6">2 7/8 PH6</option>
                <option value="3 1/2 REG">3 1/2 REG</option>
                <option value="4 1/2 REG">4 1/2 REG</option>
                <option value="4 H90">4 H90</option>
                <option value="4 1/2 H90">4 1/2 H90</option>
                <option value="5 H90">5 H90</option>
                <option value="7 H90">7 H90</option>
                <option value="5 1/2 IF">5 1/2 IF</option>
                <option value="NC35">NC35</option>
                <option value="Lift Upset">Lift Upset</option>
                <option value="Lift Bail">Lift Bail</option>
            </select>
                    </td>
                    
                    
                    
                    <td>
                        <select name="editBox" id="editBox" required>
                <option value="${inventory.boxConnect}" selected>${inventory.boxConnect}</option>
                <option value="3 1/2 IF">3 1/2 IF</option>
                <option value="4 FH">4 FH</option>
                <option value="4 1/2 XH">4 1/2 XH</option>
                <option value="4 1/2 IF">4 1/2 IF</option>
                <option value="5 1/2 FH">5 1/2 FH</option>
                <option value="6 5/8 REG">6 5/8 REG</option>
                <option value="7 5/8 REG">7 5/8 REG</option>
                <option value="DS38">DS38</option>
                <option value="DS40">DS40</option>
                <option value="XT39">XT39</option>
                <option value="XT40">XT40</option>
                <option value="CET43">CET43</option>
                <option value="HT55">HT55</option>
                <option value="2 7/8 PH6">2 7/8 PH6</option>
                <option value="3 1/2 REG">3 1/2 REG</option>
                <option value="4 1/2 REG">4 1/2 REG</option>
                <option value="4 H90">4 H90</option>
                <option value="4 1/2 H90">4 1/2 H90</option>
                <option value="5 H90">5 H90</option>
                <option value="7 H90">7 H90</option>
                <option value="5 1/2 IF">5 1/2 IF</option>
                <option value="NC35">NC35</option>
                <option value="Lift Upset">Lift Upset</option>
                <option value="Lift Bail">Lift Bail</option>
             </select>
                    </td>                      
                    
                    
                    
                    <td>
                    <select name="editId" id="editId" required>
                <option value="${inventory.id}" selected>${inventory.id}</option>
                <option value="2">2"</option>
                <option value="2 1/4">2 1/4"</option>
                <option value="2 1/2">2 1/2"</option>
                <option value="2 11/16">2 11/16"</option>
                <option value="2 13/16">2 13/16"</option>
                <option value="3">3"</option>
                <option value="3 1/4">3 1/4"</option>
                <option value="3 1/2">3 1/2"</option>
                <option value="4 1/2">4 1/2"</option>
                     </select>
                    </td>
                    
                    
                    
                    <td>                       
                        <input type="number" name="editLength" value="${inventory.length}" step=".001" size="10">
                    </td>
                    
                  
                    <td><select name="editStatus" id="editStatus">
                    <option value="${inventory.statusName}" selected>${inventory.statusName}</option>
                <option value="Available">Available</option>
                <option value="Rented">Rented</option>
                <option value="Deactivated">Deactivated</option>
                <option value="In Service">In Service</option>
                    </select></td>
                    
                                      
              
                    <td>
                        <select name="editLocation" id="editLocation">
                    <option value="${inventory.location}" selected>${inventory.location}</option>
                <option value="Calgary">Calgary</option>
                <option value="Nisku">Nisku</option>
                <option value="Grand Prairie">Grande Prairie</option>
                    </select>
                    </td>
                    
                    
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

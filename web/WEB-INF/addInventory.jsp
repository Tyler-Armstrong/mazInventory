
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/styleAdd.css">
        <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
        <title>Add Item</title>
    </head>
    
    <body>
        
        <h2>Add Inventory</h2>
        
        <div class="adminPage">
        <a href="maz_admin" class="btn btn-primary btn-lg">Admin Page</a><br><br>
        </div>
        
        <div class="container">
        <form method="POST" action="addInventory">
              <p>Serial Number :  <input type="text" name="serialNumberAdd" placeholder="Serial Number" required><br></p>
            
            
            <label for="descriptionAdd">Description :</label>
            <select name="descriptionAdd" id="descriptionAdd" required>
                <option value=""></option>
                <option value="NM Slick Collar">NM Slick Collar</option>
                <option value="NM Flex Collar">NM Flex Collar</option>
                <option value="NM Slick Pony">NM Slick Pony</option>
                <option value="NM Flex Pony">NM Flex Pony</option>
                <option value="NM Stabilizer">NM Stabilizer</option>
                <option value="NM Saver Sub">NM Saver Sub</option>
                <option value="NM Cross Over">NM Cross Over</option>
                <option value="NM Float Sub">NM Float Sub</option>
                <option value="Jar">Jar</option>
                <option value="Jar Pony">Jar Pony</option>
                <option value="Shock Sub">Shock Sub</option>
                <option value="Steel Stablizer">Steel Stablizer</option>
                <option value="Steel Cross Over Sub">Steel Cross Over Sub</option>
                <option value="Pickup Sub">Pickup Sub</option>
                <option value="TAL Dampner">TAL Dampner</option>
                <option value="Steel Saver Sub">Steel Saver Sub</option>
                <option value="Reamer">Reamer</option>
                <option value="Tapered Blade Reamer">Tapered Blade Reamer</option>
                <option value="Sub Basket">Sub Basket</option>
                <option value="Fin Cutter Sub">Fin Cutter Sub</option>
                <option value="Filter Sub">Filter Sub</option>
                <option value="NM Filter Sub">NM Filter Sub</option>
                <option value="Filter Screen">Filter Screen</option>
            </select><br><br>
            
            <label for="ODAdd">OD :</label>
            <select name="ODAdd" id="ODAdd" required>
                <option value=""></option>
                <option value="4 3/4">4 3/4"</option>
                <option value="5">5"</option>
                <option value="5 1/4">5 1/4"</option>
                <option value="5 7/8">5 7/8"</option>
                <option value="6">6"</option>
                <option value="6 1/4">6 1/4"</option>
                <option value="6 1/2">6 1/2"</option>
                <option value="6 3/4">6 3/4"</option>
                <option value="7">7"</option>
                <option value="8">8"</option>
                <option value="8 1/4">8 1/4"</option>
                <option value="8 1/2">8 1/2"</option>
                <option value="9">9"</option>
                <option value="9 1/2">9 1/2"</option>
                
                
            </select> <br><br>
            
            
            <label for="pinAdd">Pin Connection :</label>
            <select name="pinAdd" id="pinAdd" required>
                <option value=""></option>
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
                <option value="CET43">CET43</option>
                <option value="HT55">HT55</option>
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
            </select><br><br>
            
            
            
            <label for="boxAdd">Box Connection :</label>
            <select name="boxAdd" id="boxAdd" required>
                <option value=""></option>
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
                <option value="CET43">CET43</option>
                <option value="HT55">HT55</option>
                <option value="3 1/2 REG">3 1/2 REG</option>
                <option value="4 1/2 REG">4 1/2 REG</option>
                <option value="4 H90">4 H90</option>
                <option value="4 1/2 H90">4 1/2 H90</option>
                <option value="5 H90">5 H90</option>
                <option value="7 H90">7 H90</option>
                <option value="5 1/2 IF">5 1/2 IF</option>
                <option value="NC35">NC35</option>
             </select><br><br>
            
            
            
           <label for="idAdd">ID :</label>
            <select name="idAdd" id="idAdd" required>
                <option value=""></option>
                <option value="2">2"</option>
                <option value="2 1/4">2 1/4"</option>
                <option value="2 1/2">2 1/2"</option>
                <option value="2 11/16">2 11/16"</option>
                <option value="2 13/16">2 13/16"</option>
                <option value="3">3"</option>
                <option value="3 1/4">3 1/4"</option>
            </select><br><br>
           
            <label for="lengthAdd">Length (Meters): </label> <br>
            <input type="number" name="lengthAdd" placeholder="Length" step=".001" required ><br><br>
            
            <label for="statusAdd">Status :</label>
            <select name="statusAdd" id="statusAdd" required>
                <option value=""></option>
                <option value="Available">Available</option>
                <option value="Deactivated">Deactivated</option>
                <option value="Rented">Rented</option>
                <option value="In Service">In Service</option>
            </select><br><br>
            
            <label for="locationAdd">Location :</label>
            <select name="locationAdd" id="locationAdd" required>
                <option value=""></option>
                <option value="Calgary">Calgary</option>
                <option value="Nisku">Nisku</option>
                <option value="Grand Prairie">Grande Prairie</option>
            </select>
            <br><br>
            <input type="submit" value="Add Item"><br><br>
        </form>
            
        <h3>${message}</h3>
       
        </div>
        
    </body>
</html>

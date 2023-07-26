package service;

import dataaccess.InventoryDB;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import models.Inventory;



public class InventoryService {

    public List<Inventory> getAll(int page, int pageSize) throws Exception {
        InventoryDB in = new InventoryDB();
        List<Inventory> inventory = in.getAll((page - 1) * pageSize, pageSize);
        return inventory;
        
    }

    public void insert(String serialNum, String description, String od, String pin, String box, String id, String length, String status, String location) throws Exception {
        InventoryDB in = new InventoryDB();
        BigDecimal decimalLength = new BigDecimal(length);
        Inventory newInv = new Inventory(0, serialNum, description, od, pin, box, id, decimalLength, status, location);
        in.add(newInv);
        
    }

    public void update(String status, String pkValue, String description, String od, String pinCon, String boxCon, String id, String length, String location) throws Exception {
        InventoryDB in = new InventoryDB();
        
        int primary = Integer.parseInt(pkValue);
        
        Inventory updateSerial = in.get(primary);
        
        String serial = updateSerial.getSerialNumber();
        
        BigDecimal decimalLength = new BigDecimal(length);
        
        //(Integer itemId, String serialNumber, String description, String od, String pinConnect, String boxConnect, String id, String length, String statusName, String location)
        Inventory updateItem = new Inventory(primary, serial, description, od, pinCon, boxCon, id, decimalLength, status ,location);
        
        updateItem.setStatusName(status);
        
        in.update(updateItem);
    }

    // might not be needed
    public List<Inventory> searchSerialNummber(String serialSearch) throws Exception {
        InventoryDB in = new InventoryDB();
        List<Inventory> listy = in.searchSerial(serialSearch);
        
        return listy;
    }

    public void delete(int keyValue) throws Exception {
        InventoryDB in = new InventoryDB();      
        in.delete(keyValue);       
    }

    public List<Inventory> itemReport()throws Exception {
        InventoryDB in = new InventoryDB();
        List<Inventory> available = in.getAvailable();       
        return available;
    }
    
    
    
}

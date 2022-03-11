package service;

import dataaccess.InventoryDB;
import java.sql.SQLException;
import java.util.List;
import jdk.internal.org.objectweb.asm.commons.StaticInitMerger;
import models.Inventory;
import org.w3c.dom.stylesheets.LinkStyle;



public class InventoryService {

    public List<Inventory> getAll(int page, int pageSize) throws SQLException {
        InventoryDB in = new InventoryDB();
        List<Inventory> inventory = in.getAll((page - 1) * pageSize, pageSize);
        return inventory;
        
    }

    public void insert(String serialNum, String description, String od, String pin, String box, String id, String length, String status) {
        InventoryDB in = new InventoryDB();
        Inventory newInv = new Inventory(0, serialNum, description, od, pin, box, id, length, status);
        in.add(newInv);
        
    }

    public void update(String status, String pkValue) {
        InventoryDB in = new InventoryDB();
        
        int primary = Integer.parseInt(pkValue);
        
        Inventory updateItem = in.get(primary);
        updateItem.setStatusName(status);
        
        in.update(updateItem);
    }

    // might not be needed
    public List<Inventory> searchSerialNummber(String serialSearch) {
        InventoryDB in = new InventoryDB();
        List<Inventory> listy = in.searchSerial(serialSearch);
        
        return listy;
    }

    public void delete(int keyValue) {
        InventoryDB in = new InventoryDB();      
        in.delete(keyValue);       
    }

    public List<Inventory> itemReport() {
        InventoryDB in = new InventoryDB();
        List<Inventory> available = in.getAvailable();       
        return available;
    }
    
    
    
}

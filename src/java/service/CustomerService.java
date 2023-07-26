
package service;

import dataaccess.CustomerDB;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Customer;


public class CustomerService {

    //get all the customers from the database
    public List<Customer> getAll(int pageCustomer, int pageSize) {
       
        CustomerDB customer = new CustomerDB();
        
        List<Customer> customers = customer.getAll((pageCustomer - 1) * pageSize, pageSize);
        return customers;
    }

    public Customer findCustomer(String customerId) {
        CustomerDB update = new CustomerDB();
        
        Customer customerUpdate = update.findCustomer(customerId);
        
        
        return customerUpdate;
    }

    public void update(String pkValue, String companyUpdate, String address1Update, String address2Update, String cityUpdate, String provinceUpdate,
            String countryUpdate , String postalUpdate, String emailUpdate, String contactUpdate, String phoneUpdate, String extensionUpdate, String isVendorUpdate) {
        CustomerDB update = new CustomerDB();
        boolean vendor;
        int primaryKey = Integer.parseInt(pkValue);
        // Integer customerId, String company, String address1, String address2, String city, String province,
        // String country, String postalCode, String email, String contactList, String phone, String extension
        if(isVendorUpdate.equals("vendor")) {
            
            vendor = true;
            Customer updateCustomer = new Customer(primaryKey, companyUpdate, address1Update, address2Update, cityUpdate, 
                provinceUpdate, countryUpdate, postalUpdate, emailUpdate, contactUpdate, phoneUpdate, extensionUpdate, vendor);
        
          update.updateCustomer(updateCustomer);
            
        }else if(isVendorUpdate.equals("customer")) {
            vendor = false;
            
            Customer updateCustomer = new Customer(primaryKey, companyUpdate, address1Update, address2Update, cityUpdate, 
                provinceUpdate, countryUpdate, postalUpdate, emailUpdate, contactUpdate, phoneUpdate, extensionUpdate, vendor);
        
            update.updateCustomer(updateCustomer);
        }
        /*
        Customer updateCustomer = new Customer(primaryKey, companyUpdate, address1Update, address2Update, cityUpdate, 
                provinceUpdate, countryUpdate, postalUpdate, emailUpdate, contactUpdate, phoneUpdate, extensionUpdate, vendor);
        
        update.updateCustomer(updateCustomer);
        */
    }

    public void deleteCustomer(String pkValue) throws Exception {
        CustomerDB delete = new CustomerDB();
        
        int primaryKey = Integer.parseInt(pkValue);
        
        try {
            delete.deleteCustomer(primaryKey);
        } catch (Exception ex) {
            //Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public void add(String company, String address1, String address2, String city, String province,
            String country, String postal, String email, String contact, String phone, String extension, String IsVendor) throws Exception {
        CustomerDB customdb = new CustomerDB();
         boolean vendor;
        
        if (IsVendor.equals("vendor")){
            vendor = true;
            Customer add = new Customer( company, address1, address2, city, province, country, postal, email, contact, phone, extension, vendor);
        
            try {
                customdb.addCustomer(add);
            } catch (Exception ex) {
                throw ex;
            }
            
        }else if(IsVendor.equals("customer")){
            vendor = true;
            
            Customer add = new Customer( company, address1, address2, city, province, country, postal, email, contact, phone, extension, vendor);
        
        try {
            customdb.addCustomer(add);
        } catch (Exception ex) {
            throw ex;
        }
            
        }
        
        /*
        Customer add = new Customer( company, address1, address2, city, province, country, postal, email, contact, phone, extension, vendor);
        
        try {
            customdb.addCustomer(add);
        } catch (Exception ex) {
            throw ex;
        } */
        
    }

    public List<Customer> showCustomersAndVendors(String searchValue) {
       CustomerDB customdb = new CustomerDB();
       boolean type;
       List<Customer> search = null;
       if(searchValue.equals("vendor")) {
           type = true;
           search = customdb.showCustomersAndVendors(type);
       }else if (searchValue.equals("customer")) {
           type = false;
           search = customdb.showCustomersAndVendors(type);
       }
 
       return search;
    }

    

    

    
    
    
    
    
    
    
}


package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Customer;





public class CustomerDB {

    public List<Customer> getAll(int i, int pageSize) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        List<Customer> customers = em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
        //Customer.findAll
        
        em.close();
        return customers;
        
    }

    public Customer findCustomer(String customerId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        //Customer found = em.createNamedQuery("Customer.findByCustomerId", Customer.class).getSingleResult();
        //Inventory in = em.find(Inventory.class, primary);
        
        int id = Integer.parseInt(customerId);
        Customer found = em.find(Customer.class, id);
        
        return found;
    }

    public void updateCustomer(Customer updateCustomer) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
       EntityTransaction trans = em.getTransaction();
       
       try {
        trans.begin();
        em.merge(updateCustomer);
        trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        }finally {
            em.close();
        }
        
    }

    public void deleteCustomer(int primaryKey) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction(); 
        
        Customer delete = em.find(Customer.class, primaryKey);
        
        try {
            trans.begin();
            em.remove(delete);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
            throw ex;
        }finally {
            em.close();
        }
        
    }

    public void addCustomer(Customer add) throws Exception{
       EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
        trans.begin();
        em.persist(add);
        trans.commit();
        }catch (Exception ex) {            
            trans.rollback();
            throw ex;
        } finally {
            em.close();
        }
        
    }

    public List<Customer> showCustomersAndVendors(boolean type) {
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        List<Customer> customers = em.createNamedQuery("Customer.findByIsVendor", Customer.class).setParameter("isVendor", type).getResultList();
        //Customer.findAll    = em.createNamedQuery("Customer.findAll", Customer.class).setP
        
        em.close();
        return customers;
    }

  

    
    
    
    
    
    
}

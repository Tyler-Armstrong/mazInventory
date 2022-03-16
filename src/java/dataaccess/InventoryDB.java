
package dataaccess;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Inventory;



public class InventoryDB {
    
    public List<Inventory> getAll(int offset, int count) throws Exception{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        //User user = em.find(User.class, email);
        try{
        List<Inventory> inventory = em.createNamedQuery("Inventory.findAll", Inventory.class).getResultList() ;
        
        return inventory;
        }catch (Exception ex) {
            return null;
        }finally {
           
        em.close();
        
        }
    }

    public void add(Inventory newInv)throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
        trans.begin();
        em.persist(newInv);
        trans.commit();
        }catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
        
        
    }    

    public void update(Inventory updateItem) throws Exception {        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        
        try {
        trans.begin();
        em.merge(updateItem);
        trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        }finally {
            em.close();
        }
        
    }

    public Inventory get(int primary) throws Exception {
       EntityManager em = DBUtil.getEmFactory().createEntityManager();
       try {
       //List<Inventory> inventory = em.createNamedQuery("Inventory.findAll", Inventory.class).getResultList();
       
       Inventory in = em.find(Inventory.class, primary);
       return in;
       }catch (Exception ex) {
            return null;
       }finally {
       em.close();
       }
       
    }

    //doesnt do anything probably dont need
    public List<Inventory> searchSerial(String serialSearch) throws Exception {
        EntityManager em =  DBUtil.getEmFactory().createEntityManager();
        
        try {
        List<Inventory> listy = em.createNamedQuery("Inventory.findBySerialNumber", Inventory.class).getResultList();
        
        return listy;
        }catch (Exception ex) {
            return null;
        }finally {
            em.close();
        }
    }

    public void delete(int keyValue) throws Exception{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();  
        
        Inventory delete = em.find(Inventory.class, keyValue);
        
        try {
            trans.begin();
            em.remove(delete);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        }finally {
            em.close();
        }
        
        
    }

    public List<Inventory> getAvailable() throws Exception {
        EntityManager em =  DBUtil.getEmFactory().createEntityManager();
        
        try {
        List<Inventory> available = em.createNamedQuery("Inventory.findByStatusName").setParameter("statusName", "Available") .getResultList();
        
        return available;
        }catch (Exception ex) {
            return null;
        }finally {
         em.close();
                }
    }
}

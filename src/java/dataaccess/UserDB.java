
package dataaccess;

import javax.persistence.EntityManager;
import models.User;

public class UserDB {
    
    public User get(String incomingUser)throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();       
        
       try { 
        User get = em.find(User.class, incomingUser);
        return get;
       }finally {
           em.close();
       }
        
    }
    
}

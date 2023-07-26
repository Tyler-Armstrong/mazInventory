/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Tyler
 */
@Embeddable
public class RentalPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "customer_id")
    private int customerId;
    @Basic(optional = false)
    @Column(name = "item_id")
    private int itemId;
    @Basic(optional = false)
    @Column(name = "date_out")
    @Temporal(TemporalType.DATE)
    private Date dateOut;

    public RentalPK() {
    }

    public RentalPK(int customerId, int itemId, Date dateOut) {
        this.customerId = customerId;
        this.itemId = itemId;
        this.dateOut = dateOut;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) customerId;
        hash += (int) itemId;
        hash += (dateOut != null ? dateOut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RentalPK)) {
            return false;
        }
        RentalPK other = (RentalPK) object;
        if (this.customerId != other.customerId) {
            return false;
        }
        if (this.itemId != other.itemId) {
            return false;
        }
        if ((this.dateOut == null && other.dateOut != null) || (this.dateOut != null && !this.dateOut.equals(other.dateOut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.RentalPK[ customerId=" + customerId + ", itemId=" + itemId + ", dateOut=" + dateOut + " ]";
    }
    
}

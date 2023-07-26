/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.catalina.tribes.ChannelSender;

/**
 *
 * @author Tyler
 */
@Entity
@Table(name = "rental")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rental.findAll", query = "SELECT r FROM Rental r")
    , @NamedQuery(name = "Rental.findByCustomerId", query = "SELECT r FROM Rental r WHERE r.rentalPK.customerId = :customerId")
    , @NamedQuery(name = "Rental.findByItemId", query = "SELECT r FROM Rental r WHERE r.rentalPK.itemId = :itemId")
    , @NamedQuery(name = "Rental.findByDateOut", query = "SELECT r FROM Rental r WHERE r.rentalPK.dateOut = :dateOut")
    , @NamedQuery(name = "Rental.findByDateDue", query = "SELECT r FROM Rental r WHERE r.dateDue = :dateDue")
    , @NamedQuery(name = "Rental.findByActualReturnDate", query = "SELECT r FROM Rental r WHERE r.actualReturnDate = :actualReturnDate")})
public class Rental implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RentalPK rentalPK;
    @Column(name = "date_due")
    @Temporal(TemporalType.DATE)
    private Date dateDue;
    @Column(name = "actual_return_date")
    @Temporal(TemporalType.DATE)
    private Date actualReturnDate;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customer customer;
    @JoinColumn(name = "item_id", referencedColumnName = "item_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Inventory inventory;

    public Rental() {
    }

    public Rental(RentalPK rentalPK) {
        this.rentalPK = rentalPK;
    }

    public Rental(int customerId, int itemId, Date dateOut) {     
        this.rentalPK = new RentalPK(customerId, itemId, dateOut);
    }

    public RentalPK getRentalPK() {
        return rentalPK;
    }

    public void setRentalPK(RentalPK rentalPK) {
        this.rentalPK = rentalPK;
    }

    public Date getDateDue() {
        return dateDue;
    }

    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
    }

    public Date getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(Date actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rentalPK != null ? rentalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rental)) {
            return false;
        }
        Rental other = (Rental) object;
        if ((this.rentalPK == null && other.rentalPK != null) || (this.rentalPK != null && !this.rentalPK.equals(other.rentalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Rental[ rentalPK=" + rentalPK + " ]";
    }
    
}
